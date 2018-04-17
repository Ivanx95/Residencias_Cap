/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacitacion;

import com.facture.training.controller.ComprobanteController;
import com.facture.training.models.Comprobante;
import com.facture.training.view.BaseView;
import com.facture.training.view.ComprobanteView;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author jaisen
 */
public class Capacitacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BaseView view = new ComprobanteView();
        
        ComprobanteController compT = new ComprobanteController();
        
//        Comprobante comp = new Comprobante();
//        comp.setSerial("AAAA");
//        comp.setId(BigDecimal.TEN);
//        comp.setRfc("ghghjgjh");
//        comp.setDate(new Date());
//        comp.setTotal(BigDecimal.valueOf(1000.0));
        
        
//        compT.newModel(comp);
       
        compT.setViewAndcontroller(view);
     
        
    }
    
    
}
