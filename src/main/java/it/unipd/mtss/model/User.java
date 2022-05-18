////////////////////////////////////////////////////////////////////
// [Tommaso] [Berlaffa] [1201234]
// [Matteo] [Vignaga] [1201147]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public class User {
 int Id;
 String Name, Surname;

 public User(int i, String N, String S) {
  Id=i;
  Name=N;
  Surname=S;
 }

 public int getId() {
  return Id;
 }

 public String getName() {
  return Name;
 }

 public String getSurname() {
  return Surname;
 }
}