////////////////////////////////////////////////////////////////////
// [FEDERICO] [PERIN] [1170747]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
public class TakeAwayBillExceptionTest {

    private static TakeAwayBillException exp;
    
    @BeforeClass
    public static void BeforeClass() {
        exp = new TakeAwayBillException("ERRORE");
    }

    @Test
    public void testGetMessage() {
        assertEquals("ERRORE", exp.getMessage());
    }
}
