////////////////////////////////////////////////////////////////////
// [Tommaso] [Berlaffa] [1201234]
// [Matteo] [Vignaga] [1201147]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import java.util.List;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.itemType;

public class Calculator implements Bill {

 @Override
 public double getOrderPrice(List<EItem> itemsOrdered, User user) throws BillException
 {
  double total = 0.0;
  int counter = 0;
  double cost= 0.0;
  for(EItem i : itemsOrdered)
  {
   total += i.getPrice();
   if(i.getType()==itemType.Processor)
   {
    counter++;
    if(cost==0.0)
    {
     cost=i.getPrice();
    }
     else if(cost>i.getPrice())
    {
     cost=i.getPrice();
    }
   }
  }
  if(counter>=5)
  {
   total-=cost*0.5;
  }
  return total;
 }
}