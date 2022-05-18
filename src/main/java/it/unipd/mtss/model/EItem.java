////////////////////////////////////////////////////////////////////
// [Tommaso] [Berlaffa] [1201234]
// [Matteo] [Vignaga] [1201147]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public class EItem {
 itemType Type;
 String Name;
 double Price;

 public EItem(itemType T,String N,double P) {
  Type=T;
  Name=N;
  Price=P;
 }

 public itemType getType() {
  return Type;
 }

 public String getName() {
  return Name;
 }

 public double getPrice() {
  return Price;
 }
}