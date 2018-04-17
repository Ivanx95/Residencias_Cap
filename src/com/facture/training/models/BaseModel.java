/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facture.training.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author jaisen
 * @since 06/01/18
 * @version 1.0
 * 
 * De esta forma debe crearse los modelos
 * <br/>
 * Modelo base
 */

public class BaseModel {
    
    /**
     * Generic attributes for the facturas
     */
    private String id;
    
    private String serial;
    
    private String date;

    
    /**
     * 
     */
    public BaseModel() {
    
    }

    
    /**
     * 
     * @return {@link #id}
     */
    public String getId() {
        return id;
    }

    
    /**
     * set {@link #id}
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * {@link #Serial}
     * @return 
     */
    public String getSerial() {
        return serial;
    }

    
  /**
   * <p>set {@link #serial}</p>
   * @param serial 
   */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * Gets the {@link #date}
     * @return 
     */
    public String getDate() {
        return date;
    }

    /**
     * sets the {@link #date}
     * @param date 
     */
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
      
        String result = "-- [id]: "+this.id +" [serial]: "+this.serial +" [date]: "+this.date.toString() +" --";
        return result;
    }

    
    /**
     * For cloning objects
     * @return
     * @throws CloneNotSupportedException 
     */
    @Override
    protected BaseModel clone() throws CloneNotSupportedException {
    
        BaseModel clone = new BaseModel();
        clone.setId(this.id);
        clone.setSerial(this.serial);
        clone.setDate(this.date);
        
        return clone;
    }
    
    
    
    
}
