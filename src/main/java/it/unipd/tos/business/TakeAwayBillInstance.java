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
            throws TakeAwayBillException {
        // TODO Auto-generated method stub
        double price=0;
        double pricePF=0;
        double countP=0;
        double minP=Double.MAX_VALUE;
        for(int i=0; i < itemsOrdered.size(); i++)
        {
            price+=itemsOrdered.get(i).getPrice();
            if(itemsOrdered.get(i).getType() == ItemType.Panini)
            {
                countP++;
                if(minP>price)
                {
                    minP=price;
                }
            }
            
            if((itemsOrdered.get(i).getType() == ItemType.Panini) 
                    || (itemsOrdered.get(i).getType() == ItemType.Panini))
            {
                pricePF+=itemsOrdered.get(i).getPrice();
            }
            
        }
        
        if(pricePF>50)
        {
            price=price-price*0.1;
        }
        
        if(countP>5)
        {
            price=price-minP*0.5;
        }
        
        

        
        return price;
    }
    
    

}
