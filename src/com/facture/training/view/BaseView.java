/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facture.training.view;

import com.facture.training.library.SenchaTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jaisen
 * Vista base posee los botones guardar y borrar
 */
public abstract class  BaseView  extends JFrame{
    protected JPanel contenedor;

    protected int height = 500;
    
    protected int width=800;
    
    protected JButton saveBtn;
    
    protected JButton cancelBtn;
    
    public BaseView(String title) {

        this.contenedor = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle(title);

        this.setBounds(0, 0, width, height);

        this.contenedor.setBounds(WIDTH, WIDTH, width - 5, height - 5);
        this.contenedor.setBackground(Color.red);

        configureBaseForm();

        this.add(contenedor);

        this.pack();

        this.setVisible(true);

    }

    /**
     * Se configura los botones guardar y cancelar
     */
    private void  configureBaseForm(){
     
            this.saveBtn = new JButton("Guardar");
            this.cancelBtn = new JButton("Cancelar");
            
            this.contenedor.add(this.saveBtn);
            this.contenedor.add(this.cancelBtn);
            configureForm();
    
    }
    
    /**
     * Lo que el desarrollador desee añadir a la vista
     */
    protected abstract void configureForm();
    
    
    /**
     * 
     * @return 
     */
     public JButton getSaveBtn() {
        return saveBtn;
    }

     
    /**
     * 
     * @return 
     */
    public JButton getCancelBtn() {
        return cancelBtn;
    }
    
    
      /**
       * 
       * @return 
       */
    public JPanel getContenedor() {
        return contenedor;
    }

    
}
