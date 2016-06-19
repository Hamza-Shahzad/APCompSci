//**************************************************************************************
//
//@author: Hamza Shahzad ||| IllegalMoveException.java
//Prints an exception when the move is illegal
//
//**************************************************************************************
public class IllegalMoveException extends RuntimeException {

    public IllegalMoveException(){
        super("This move is illegal!"); //Initializes Parent class 'Runtime Exception'-- that's what super does
    }

    public IllegalMoveException(String message){
        super(message);
    }
}