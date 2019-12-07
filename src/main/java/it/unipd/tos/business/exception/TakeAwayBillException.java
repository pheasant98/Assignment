////////////////////////////////////////////////////////////////////
// [FEDERICO] [PERIN] [1170747]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;
public class TakeAwayBillException extends Exception{
    public TakeAwayBillException(){

    }

    public TakeAwayBillException(String message){
        super(message);
    }

    public String getMessage(){
        return super.getMessage();
    }
}
