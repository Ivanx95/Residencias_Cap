/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facture.training.controller;

import com.facture.training.models.Comprobante;
import com.facture.training.view.BaseView;
import com.facture.training.view.ComprobanteView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author jaisen
 * Controlador para el modelo comprobante, no hace gran cosa solo guarda un objeto comprobante
 */
public class ComprobanteController extends BaseController<Comprobante>{
    
    private Comprobante theComprobante;

    public ComprobanteController() {
        super();
    }

    @Override
    public void setViewAndcontroller(BaseView view) {
        super.setViewAndcontroller(view);
        
        ComprobanteView theView = (ComprobanteView) view;
        
       theView.getAlgo().addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(theView, "ME HICISTE CLIC");
			
		}
	});
}

  
    
    @Override
    protected Comprobante initializeModel() {
//    	this.model.
        theComprobante = new Comprobante();
        theComprobante.setId("1");
        theComprobante.setSerial("21123");
        theComprobante.setDate(new Date().toString());
        theComprobante.setRfc("LAOJ82908");
        theComprobante.setTotal(BigDecimal.valueOf(12312.23));
        return theComprobante; 
    }

    
    public void newModel(Comprobante comp){
        this.model = comp;
    }
    
    /**
     * @TODO: add something
     */
    @Override
    protected void onBeforeSave() {

    }

    /**
     * El total debe ser diferente de Cero
     * @return 
     */
    @Override
    protected boolean customValidation() {
    	if(getModel().getSerial().equals("")) {
    		return false;
    	}
       if(getModel().getTotal().compareTo(BigDecimal.ZERO)==0){
           return false;
       }else{
           return true;
       }
        
    }

    /**
     * @TODO: añadir Implementacion
     * @param model 
     */
    @Override
    protected void doRequest(Comprobante model) {
        
    }

  
    
    
    
   
}
