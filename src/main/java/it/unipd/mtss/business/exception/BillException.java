////////////////////////////////////////////////////////////////////
// [Tommaso] [Berlaffa] [1201234]
// [Matteo] [Vignaga] [1201147]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business.exception;

public class BillException extends Throwable {

 private String message;

 public BillException(String msg){
  message=msg;
 }

 @Override
 public String getMessage() {
  return message;
 }
}
