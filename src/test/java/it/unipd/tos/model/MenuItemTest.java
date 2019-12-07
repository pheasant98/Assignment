////////////////////////////////////////////////////////////////////
// [FEDERICO] [PERIN] [1170747]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

public class MenuItemTest {
    
    private static MenuItem ordine;

    @BeforeClass
    public static void BeforeClass()
    {
        ordine = new MenuItem(ItemType.Panini, "Fantasia", 15);
    }
    
    @Test
    public void testGetItemType()
    {    
        assertEquals(ItemType.Panini, ordine.getType());
    }
    
    @Test
    public void testGetName()
    {
        assertEquals("Fantasia", ordine.getName());
    }
    
    @Test
    public void testGetPrice()
    {
        assertEquals(15, ordine.getPrice(), 0);
    }
 
}
