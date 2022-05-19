////////////////////////////////////////////////////////////////////
// [Tommaso] [Berlaffa] [1201234]
// [Matteo] [Vignaga] [1201147]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public class User {
 int Id, Age;
 String Name, Surname;

 public User(int i, int a, String N, String S) {
  Id=i;
  Age=a;
  Name=N;
  Surname=S;
 }

 public int getId() {
  return Id;
 }
 
 public int getAge() {
  return Age;
  }

 public String getName() {
  return Name;
 }

 public String getSurname() {
  return Surname;
 }
}