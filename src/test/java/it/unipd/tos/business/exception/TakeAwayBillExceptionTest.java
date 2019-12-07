////////////////////////////////////////////////////////////////////
// [FEDERICO] [PERIN] [1170747]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.BeforeClass;
import it.unipd.tos.model.ItemType;
public class TakeAwayBillExceptionTest {

    private static TakeAwayBillException exp;
    
    @BeforeClass
    public static void BeforeClass() {
        exp = new TakeAwayBillException("ERRORE");
    }

    public static void testGetMessage() {
        assertEquals("ERRORE", exp.getMessage());
    }
}
