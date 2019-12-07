////////////////////////////////////////////////////////////////////
// [FEDERICO] [PERIN] [1170747]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import org.junit.BeforeClass;
import org.junit.Test;

public class TakeAwayBillInstanceTest {
    
    private static TakeAwayBillInstance app;
    
    @BeforeClass
    public static void BeforeClass()
    {
        app = new TakeAwayBillInstance();
    }
    
    @Test
    public void TakeAwayBillInstanceTest()
    {
        List<MenuItem> lista=  new ArrayList();
        lista.add(new MenuItem(ItemType.Panini, "Fantasia", 8));
        lista.add(new MenuItem(ItemType.Fritti, "FrigiTutto", 5));
        lista.add(new MenuItem(ItemType.Panini, "Fantasia", 5));
        try
        {
            assertEquals(18, app.getOrderPrice(lista),0);
        }
        catch(TakeAwayBillException e)
        {
            fail("Exception");
        }
        
        
    }
}
