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
  int counterProc = 0;
  int counterMouse =0;
  double costProc= 0.0;
  double costMouse=0.0;
  for(EItem i : itemsOrdered)
  {
   total += i.getPrice();
   if(i.getType()==itemType.Processor)
   {
    counterProc++;
    if(costProc==0.0)
    {
     costProc=i.getPrice();
    }
     else 
    {
     if(costProc>i.getPrice())
     {
      costProc=i.getPrice();
     }
    }
   }
   if(i.getType()==itemType.Mouse)
   {
    counterMouse++;
    if(costMouse==0.0)
    {
     costMouse= i.getPrice();
    }
    else
    {
     if(costMouse>i.getPrice())
     {
      costMouse=i.getPrice();
     }
    }
   }
  }
  if(counterProc>=5)
  {
   total-=costProc*0.5;
  }
  if(counterMouse>=10)
  {
   total-=costMouse;
  }
  return total;
 }
}