/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facture.training.models;

import java.math.BigDecimal;

/**
 *
 * @author jaisen
 * Un simple comprobante
 */
public class Comprobante extends BaseModel{
    
    private String rfc;
    
    private BigDecimal total;

    public Comprobante() {
    }

    
    /**
     * 
     * @return 
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * 
     * @param rfc 
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * 
     * @return 
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * 
     * @param total 
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    
    
}
