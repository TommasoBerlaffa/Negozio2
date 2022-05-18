////////////////////////////////////////////////////////////////////
// [Tommaso] [Berlaffa] [1201234]
// [Matteo] [Vignaga] [1201147]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import java.util.List;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;

public class Calculator implements Bill {

 @Override
 public double getOrderPrice(List<EItem> itemsOrdered, User user) throws BillException
 {
  double total = 0.0;
  for(EItem i : itemsOrdered)
  {
   total += i.getPrice();
  }
  return total;
 }
}