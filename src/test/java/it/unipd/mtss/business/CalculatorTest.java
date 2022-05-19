////////////////////////////////////////////////////////////////////
// [Tommaso] [Berlaffa] [1201234]
// [Matteo] [Vignaga] [1201147]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import it.unipd.mtss.model.*;
import it.unipd.mtss.business.exception.*;

public class CalculatorTest {
	
	Calculator C = new Calculator();
	
	@Test
	public void Test_Calculator() throws BillException {
		List<EItem> itemsOrdered = new ArrayList<EItem>();
        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard Bella",10.00));
        itemsOrdered.add(new EItem(itemType.Processor,"Processore Bello",0.48));
        User u=new User(4,"Gino", "Bob");
        double total = C.getOrderPrice(itemsOrdered,u);
        assertEquals(21.0D, total, 0.0D);
	}
	//If there are five or more processors, the price of cheapest one will be halved
	@Test
	public void MoreThan5Processor_Test() throws BillException {
		List<EItem> itemsOrdered = new ArrayList<EItem>();
        itemsOrdered.add(new EItem(itemType.Processor,"Processore1",1.0));
        itemsOrdered.add(new EItem(itemType.Processor,"Processore2",2.0));
        itemsOrdered.add(new EItem(itemType.Processor,"Processore3",3.0));
        itemsOrdered.add(new EItem(itemType.Processor,"Processore4",4.0));
        itemsOrdered.add(new EItem(itemType.Processor,"Processore5",5.0));
        itemsOrdered.add(new EItem(itemType.Processor,"Processore6",0.5));
        User u=new User(4,"Gino", "Bob");
        double total = C.getOrderPrice(itemsOrdered,u);
        assertEquals(15.25D, total, 0.0D);
	}
	
	//If there are five or more processors, the price of cheapest one will be halved
		@Test
		public void MoreThan10Mouse_Test() throws BillException {
			List<EItem> itemsOrdered = new ArrayList<EItem>();

	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse1",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse2",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse3",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse4",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse5",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse6",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse7",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse8",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse9",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse0",1.0));
	        User u=new User(4,"Gino", "Bob");
	        double total = C.getOrderPrice(itemsOrdered,u);
	        assertEquals(90.0D, total, 0.0D);
		}
}