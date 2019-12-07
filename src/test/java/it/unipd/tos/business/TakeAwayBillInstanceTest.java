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
    public void TakeAwayBillInstanceTestPriceCalcolator()
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
    
    @Test
    public void TakeAwayBillInstanceTestDiscountIfMoreThan5Sandwiches()
    {
        List<MenuItem> lista=  new ArrayList();
        lista.add(new MenuItem(ItemType.Panini, "Fantasia", 8));
        lista.add(new MenuItem(ItemType.Panini, "Vegetariano", 5));
        lista.add(new MenuItem(ItemType.Panini, "Bellissima", 5));
        lista.add(new MenuItem(ItemType.Panini, "Primavera", 8));
        lista.add(new MenuItem(ItemType.Panini, "Sole", 5));
        lista.add(new MenuItem(ItemType.Panini, "Luna", 4));
        lista.add(new MenuItem(ItemType.Bevande, "Coca-Cola", 4));
        try
        {
            assertEquals(37, app.getOrderPrice(lista),0);
        }
        catch(TakeAwayBillException e)
        {
            fail("Exception");
        }    
    }
    
    @Test
    public void TakeAwayBillInstanceTestDiscountfor50EuroSandwichesAndFried()
    {
        List<MenuItem> lista=  new ArrayList();
        lista.add(new MenuItem(ItemType.Panini, "Fantasia", 25));
        lista.add(new MenuItem(ItemType.Panini, "Vegetariano", 25));
        lista.add(new MenuItem(ItemType.Fritti, "Bellissima", 25));
        lista.add(new MenuItem(ItemType.Fritti, "FrittoTutto", 15));
        lista.add(new MenuItem(ItemType.Bevande, "Coca-Cola", 10));
        try
        {
            assertEquals(90, app.getOrderPrice(lista),0);
        }
        catch(TakeAwayBillException e)
        {
            fail("Exception");
        }    
    }
    @Test
    public void TakeAwayBillInstanceTestDiscountx2for50ESandwichesAndFried()
    {
        List<MenuItem> lista=  new ArrayList();
        lista.add(new MenuItem(ItemType.Panini, "Fantasia", 10));
        lista.add(new MenuItem(ItemType.Panini, "Vegetariano", 10));
        lista.add(new MenuItem(ItemType.Fritti, "Bellissima", 10));
        lista.add(new MenuItem(ItemType.Fritti, "FrittoTutto", 10));
        lista.add(new MenuItem(ItemType.Bevande, "Coca-Cola", 10));
        lista.add(new MenuItem(ItemType.Panini, "Fantasia", 16));
        lista.add(new MenuItem(ItemType.Panini, "Vegetariano", 15));
        lista.add(new MenuItem(ItemType.Panini, "Fantasia", 15));
        lista.add(new MenuItem(ItemType.Panini, "Vegetariano", 4));
        try
        {
            assertEquals(88, app.getOrderPrice(lista),0);
        }
        catch(TakeAwayBillException e)
        {
            fail("Exception");
        }    
    }
    
    @Test(expected = TakeAwayBillException.class) 
    public void testErrorForOrdersWithMoreThan30Elements() 
            throws TakeAwayBillException
    {
        
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        for(int i = 0; i < 31; ++i) {
            itemsOrdered.add(new MenuItem(ItemType.Panini, "Fantasia", 2));
        }
        
        app.getOrderPrice(itemsOrdered);
    }
    
    @Test
    public void TakeAwayBillInstanceTestCaseZero()
    {
        List<MenuItem> lista=  new ArrayList();
        lista.add(new MenuItem(ItemType.Bevande, "Acqua", 0));
        try
        {
            assertEquals(0, app.getOrderPrice(lista),0);
        }
        catch(TakeAwayBillException e)
        {
            fail("Exception");
        }    
    }
    
    @Test
    public void TakeAwayBillInstanceTestAmountLessThan10() 
    {
        List<MenuItem> lista=  new ArrayList();
        lista.add(new MenuItem(ItemType.Bevande, "Coca-cola", 9));
        try
        {
            assertEquals(9.50, app.getOrderPrice(lista),0);
        }
        catch(TakeAwayBillException e)
        {
            fail("Exception");
        }    
    }
}
