////////////////////////////////////////////////////////////////////
// [FEDERICO] [PERIN] [1170747]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
public class TakeAwayBillInstance implements TakeAwayBill {
    

    public double getOrderPrice(List<MenuItem> itemsOrdered)
            throws TakeAwayBillException 
    {
        double PrezzoTotale=0.0;
        double PaninoMin=0.0;
        double PrezzoPaninoEFritti=0.0;
        double ScontoTotale=0.0;
        int sandwichNumber=0;
        
        if(itemsOrdered.size() > 30) {
            throw new TakeAwayBillException("ERRORE");
        }
        for(MenuItem itemOrdered : itemsOrdered) 
        {
            PrezzoTotale+=itemOrdered.getPrice();
            
            if(itemOrdered.getType()==ItemType.Panini) 
            {
                if(sandwichNumber==0) 
                {
                    PaninoMin=itemOrdered.getPrice();
                } else if(itemOrdered.getPrice()<PaninoMin) 
                {
                    PaninoMin=itemOrdered.getPrice();
                }
                
                PrezzoPaninoEFritti+=itemOrdered.getPrice();
                
                sandwichNumber++;
            }
            
            if(itemOrdered.getType()==ItemType.Fritti) {
                PrezzoPaninoEFritti+=itemOrdered.getPrice();
            }
        }
        
        if(sandwichNumber>5) 
        {
            ScontoTotale+=PaninoMin / 2.0;
        }
        
        if(PrezzoPaninoEFritti>50.0) 
        {
            ScontoTotale+=PrezzoTotale * 0.10;
        }
        
        return PrezzoTotale-ScontoTotale;
    }  
    

}
