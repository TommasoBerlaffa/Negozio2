////////////////////////////////////////////////////////////////////
// [Tommaso] [Berlaffa] [1201234]
// [Matteo] [Vignaga] [1201147]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;
import java.time.LocalTime;
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
        User u=new User(4,20,"Gino", "Bob");
        double total = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:15:00"));
        assertEquals(11.0D, total, 0.0D);
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
        User u=new User(4,20,"Gino", "Bob");
        double total = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("14:00:00"));
        assertEquals(15.25D, total, 0.0D);
	}
	
	//If there are ten or more mice, the price of cheapest one will set to 0
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
	        User u=new User(4,20,"Gino", "Bob");
	        double total = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("14:00:00"));
	        assertEquals(90.0D, total, 0.0D);
		}
		
		//If there are the same number of mice and keyboards, the cheapest one will set to 0 
		//if the number of mice is more than 10, the cheapest mouse and keyboard will both be set to 0
		@Test
		public void EqualNumberOfMiceAndKeyboards_Test() throws BillException {
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
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse10",1.0));

	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard1",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard2",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard3",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard4",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard5",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard6",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard7",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard8",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard9",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard10",2.0));
	        
	        User u=new User(4,20,"Gino", "Bob");
	        double total = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("14:00:00"));
	        assertEquals(180.0D, total, 0.0D);
		}
		
		//If there are the same number of mice and keyboards, the cheapest one will set to 0
		@Test
		public void EqualNumberOfMiceAndKeyboardsLessThan10_Test() throws BillException {
			List<EItem> itemsOrdered = new ArrayList<EItem>();

	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse1",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse2",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse3",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse4",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse5",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse6",10.0));
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse10",2.0));

	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard1",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard2",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard3",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard4",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard5",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard6",10.0));
	        itemsOrdered.add(new EItem(itemType.Keyboard,"Keyboard10",1.0));
	        
	        User u=new User(4,20,"Gino", "Bob");
	        double total = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("14:00:00"));
	        assertEquals(122.0D, total, 0.0D);
		}
		
		// If the price is higher than 1000, the total get reduced by 10%
		@Test
		public void TotalHigherThan1000_Test() throws BillException {
			List<EItem> itemsOrdered = new ArrayList<EItem>();
	        itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.0));
	        itemsOrdered.add(new EItem(itemType.Motherboard,"Motherboard Bella",990.00));
	        itemsOrdered.add(new EItem(itemType.Processor,"Processore Bello",1000.0));
	        User u=new User(4,20,"Gino", "Bob");
	        double total = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("14:00:00"));
	        assertEquals(1800.0D, total, 0.0D);
		}
		
		//If there are more than 30 items, an error message will be thrown
		@Test(expected = BillException.class)
		public void MoreThan30Items_Test() throws BillException {
			List<EItem> itemsOrdered = new ArrayList<EItem>();
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			itemsOrdered.add(new EItem(itemType.Mouse,"Mouse Bello",10.52));
			
	        User u=new User(4,20,"Gino", "Bob");
	        double total = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("14:00:00"));
		}
		
		//If the total is below 10.0, add 2.0 to the total
		@Test
		public void Commission_Test() throws BillException {
			List<EItem> itemsOrdered = new ArrayList<EItem>();
	        itemsOrdered.add(new EItem(itemType.Processor,"Processore1",1.0));
	        User u=new User(4,20,"Gino", "Bob");
	        double total = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("20:00:00"));
	        assertEquals(3.0D, total, 0.0D);
		}
		
		//If the order is between 18:00 and 19:00 and user is under age, 10 random orders will be set to 0
		@Test
		public void FreeGift_Test() throws BillException {
			List<EItem> itemsOrdered = new ArrayList<EItem>();
			itemsOrdered.add(new EItem(itemType.Processor,"Processore1",400.0));
			User u=new User(4,15,"Gino", "Bob");
			double total = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:02:00"));
			assertEquals(0.0D, total, 0.0D);
		}
		
		//If the order is between 18:00 and 19:00 and user is under age, 10 random orders will be set to 0
		@Test
	    public void TooManyFreeGifts_Test() throws BillException {
		List<EItem> itemsOrdered = new ArrayList<EItem>();
		itemsOrdered.add(new EItem(itemType.Processor,"Processore1",200.0));
		User u=new User(4,15,"Gino", "Bob");
		double total = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:02:00"));
		double total1 = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:02:00"));
		double total2 = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:02:00"));
		double total3 = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:02:00"));
		double total4 = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:02:00"));
		double total5 = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:02:00"));
		double total6 = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:02:00"));
		double total7 = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:02:00"));
		double total8 = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:02:00"));
		double total9 = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:02:00"));
		double total10 = C.getOrderPrice(itemsOrdered,u,LocalTime.parse("18:02:00"));
		assertEquals(200.0D, total10, 0.0D);
		}
}