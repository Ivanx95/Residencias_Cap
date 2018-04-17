/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facture.training.view;

import com.facture.training.library.SenchaTextField;
import javax.swing.*;
import javax.swing.JTextField;

/**
 *
 * @author jaisen
 * Nota no se maquetar swing sin la herramienta gráfica
 * vista para comprobante posee dos TextFields 
 * @TODO: añadir los textField que faltan
 */
public class ComprobanteView extends BaseView {

    private SenchaTextField idTxtField;
    
    
    private JButton algo;
    
    public JButton getAlgo() {
		return algo;
	}


	public SenchaTextField getIdTxtField() {
		return idTxtField;
	}


	private SenchaTextField serailTxtF;
	
	
    public SenchaTextField getSerailTxtF() {
		return serailTxtF;
	}


	private SenchaTextField totalTxtF;
    
    
    public ComprobanteView() {
        super("Comprobante");
    }

    
    @Override
    protected void configureForm() {
       JLabel idLabel = new JLabel("ID");
       
       JLabel serialLabel = new JLabel("Serial");
       idTxtField= new SenchaTextField();
       
     
       idTxtField.setText("             ");
       idTxtField.setNameProperty("id");
    
       serailTxtF = new SenchaTextField();
       serailTxtF.setNameProperty("serial");
       serailTxtF.setText("             ");
       
       serailTxtF.addRegex("\\d+", "Debe ser numeros");
       //no supe ponerle width
       
       algo = new JButton("Test Button");
       
       this.contenedor.add(algo);
       this.contenedor.add(idLabel);
       this.contenedor.add(idTxtField);
       
       this.contenedor.add(serialLabel);
       this.contenedor.add(serailTxtF);
       
    }
    
}
