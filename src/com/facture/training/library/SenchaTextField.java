/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facture.training.library;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *Imitacion del TextField de GXT
 * @author jaisen
 */
public class SenchaTextField extends JTextField{
    
    private String nameProperty;
    private String invalidMessage;
    private String pattern;

    
    
    
    public SenchaTextField() {
		super();
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()=='\n') {
					validation();
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// TODO Auto-generated constructor stub
	}
    
    private void validation() {
    if(this.pattern!=null) {
    	String text = this.getText();
   
            Pattern pattern = Pattern.compile(this.pattern);

            Matcher matcher = pattern.matcher(text);
            boolean matches = matcher.matches();
            
            if(!matches) {
            	
            	if(invalidMessage!=null) {
            		System.out.println(invalidMessage);
            	}else {
            		System.out.println("Campo incorrecto");
            		
            	}
            }else {
            	
            }
            
    }
    }

	public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getNameProperty() {
        return nameProperty;
    }

    public void setNameProperty(String nameProperty) {
        this.nameProperty = nameProperty;
    }
    
    
    
    public String getInvalidMessage() {
		return invalidMessage;
	}

	public void setInvalidMessage(String invalidMessage) {
		this.invalidMessage = invalidMessage;
	}


    public void addRegex(String pattern, String msg) {
    	this.pattern = pattern;
    	this.invalidMessage = msg;
    }
}
