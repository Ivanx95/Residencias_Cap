/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facture.training.controller;

import com.facture.training.library.SenchaTextField;
import com.facture.training.models.BaseModel;
import com.facture.training.view.BaseView;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import org.apache.commons.beanutils.BeanUtils;
/**
 *  Main controller has all the generics funcion to save a element
 * @author jaisen
 */
public abstract class BaseController<T> {
    
    /**
     * El modelo se transforma en lo que especifiques al extender esta clase
     */
    protected T model;

    /**
     * La vista muestra los valores que ya posea el model y setea los valores que se pongan en los textfields al modelo
     */
    protected BaseView view;
    
    
    /**
     * Constructor el modelo inicia con metodos predefinidos por el desarrollador si es que se desea
     */
    public BaseController() {
          model= initializeModel();
    }
    
    /**
     * Obtener el modelo
     * @return 
     */
    protected  T getModel(){
        return this.model;
    }
    
    
    /**
     * Al momento de desplegar la vista se obtiene los valores que ya posee el modelo
     *  y se le coloca en la vista
     */
    protected void bindingForm(){
    
        Component [] components = view.getContenedor().getComponents();
        
        
        for (Component component : components) {
            
            if(component instanceof SenchaTextField ){
                try {
                	
                    SenchaTextField txtField = (SenchaTextField)component;
                    
                    String property = txtField.getNameProperty();
                    
                    String method = "get"+  property.substring(0, 1).toUpperCase() + property.substring(1);
                    //con reflexion obtenemos la clas
                    Class clasesita =  model.getClass();
                    
                    Object obj = (Object)clasesita.getMethod(method, null).invoke(model, null);
                    
                    txtField.setText(obj.toString());
                    
                    
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException |  SecurityException ex) {
                    Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    
                } 
              
                
            }
            
        }   
    
    }
    
    
    /**
     * Se hace el bindeo y se coloca las funcionalidades genericas
     * @param bView 
     */
    protected  void setViewAndcontroller(BaseView bView){
     

        view=bView;
        bindingForm();
         view.getCancelBtn().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
         });
         
         view.getSaveBtn().addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                   JOptionPane.showConfirmDialog(null, "Guardando");
                   doSaveAction();
             }
         });
        
    }
    
    //Inicializa el modelo especificado por el desarrollador
    protected abstract T initializeModel();
    
    /**
     * Acciones a hacer antes de guardar
     */
    protected abstract void onBeforeSave();
    
    /**
     * Add custom validattion
     * @return 
     */
    protected abstract boolean customValidation();
    
    /**
     * Sending the Model to Server
     * @param model 
     */
    protected abstract void doRequest(T model);
    
   
    
    
    /**Obtener el contenido de las vistas
     * No pude lograr que deje de tronar no se como lo hace GXT
     * @TODO: realizarlo truena
     */
    protected void retrivingContent(){
        
        Component [] components = view.getContenedor().getComponents();
        
        
        for (Component component : components) {
            
            if(component instanceof SenchaTextField ){
                try {
                    SenchaTextField txtField = (SenchaTextField)component;
                    
                    String property = txtField.getNameProperty();
                    
                    
                    Class<?> clasesita =  model.getClass();
                    
                    List<Field> fields = getIhneratedFields(clasesita);
                    
                    for (Field field : fields) {
                        if(property.equalsIgnoreCase(field.getName())){
                        	
                             String method = "set"+  property.substring(0, 1).toUpperCase() + property.substring(1);
                             
                             clasesita.getMethod(method, String.class).invoke(model, txtField.getText());
                             
//                             BeanUtils.setProperty(model, method, txtField.getText());
                             
                        }
                    }

                } catch (Exception ex) {
                    Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                    
                    
                } 
              
                
            }
            
        }
        
        
    }
    
    
    /**
     * Funcion generica al guardar
     */
    protected void doSaveAction(){
        
        onBeforeSave();
        retrivingContent();
        if(customValidation()){
        
            Class<?> classModel = model.getClass();
            
            
            List<Method> methods = getIhneratedMethods(classModel);
            List<Field> fields = getIhneratedFields(classModel);
            
            String textToScreen="";
            
            
            
            for (Field fld : fields) {
                
                for (Method mtd : methods) {
                
                    if(  mtd.getName()
                         .equalsIgnoreCase(
                            "get".concat(fld.getName())
                         )
                      )
                    {
                        try {
                            Object obj = (Object)mtd.invoke(model, null);
                            textToScreen+=obj.toString()+"\n";
                            
                            
                        } catch (IllegalAccessException  | IllegalArgumentException | InvocationTargetException ex) {
                            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
                        }                                                                                                                                                     
                    
                    }
                    
                }
            }
            
            JOptionPane.showConfirmDialog(null, "Objeto  a guardar\n"+textToScreen);
            //List<Method> theMethods = Arrays.asList(methods);
            
            doRequest(model);
            
            
            
            
        }else{
            JOptionPane.showMessageDialog(null, "Campos incorrectos");
                    
        }
        
    }
    
    /**
     * Funcion propia de la clase para obtener todos los campos, no importa si son heredados
     * @param classModel
     * @return 
     */
    private  List<Field> getIhneratedFields( Class<?> classModel){
         List<Field> fields = new ArrayList<>();
        for (Class<?> c = classModel; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }
    
    /**
     * * Funcion propia de la clase para obtener todos los metodos, no importa si son heredados
     * @param classModel
     * @return 
     */
    private List<Method>getIhneratedMethods (Class<?> classModel){
        
        List<Method> methods = new ArrayList<>();
        for (Class<?> c = classModel; c != null; c = c.getSuperclass()) {
            methods.addAll(Arrays.asList(c.getDeclaredMethods()));
        }
        return methods;
    }
    
}
