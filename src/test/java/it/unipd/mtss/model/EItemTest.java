////////////////////////////////////////////////////////////////////
// [Tommaso] [Berlaffa] [1201234]
// [Matteo] [Vignaga] [1201147]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EItemTest {

 @Test
 public void Test_EItem() {
  EItem It= new EItem(itemType.Mouse,"Mouse Bello",10.52);
  assertEquals(itemType.Mouse,It.getType());
  assertEquals("Mouse Bello",It.getName());
  assertEquals(10.52D, It.getPrice(), 0.0D);
 }
}