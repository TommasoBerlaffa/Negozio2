////////////////////////////////////////////////////////////////////
// [Tommaso] [Berlaffa] [1201234]
// [Matteo] [Vignaga] [1201147]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business.exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class BillExceptionTest {

	@Test
	public void Test_BillException() {
		BillException exc = new BillException("Costa Troppo");
        assertEquals("Costa Troppo", exc.getMessage());
	}

}