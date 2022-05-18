////////////////////////////////////////////////////////////////////
// [Tommaso] [Berlaffa] [1201234]
// [Matteo] [Vignaga] [1201147]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

 @Test
 public void Test_User() {
  User U = new User(1,"Tommaso","Berlaffa");
  assertEquals("Tommaso",U.getName());
  assertEquals("Berlaffa",U.getSurname());
  assertEquals(1,U.getId());
 }
}
