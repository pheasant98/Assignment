////////////////////////////////////////////////////////////////////
// [FEDERICO] [PERIN] [1170747]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
public class TakeAwayBillInstance implements TakeAwayBill {
    

    public double getOrderPrice(List<MenuItem> itemsOrdered)
            throws TakeAwayBillException {
        // TODO Auto-generated method stub
        double price=0;
        for(int i=0; i < itemsOrdered.size(); i++)
        {
            price+=itemsOrdered.get(i).getPrice();
        }
        return price;
    }

}
