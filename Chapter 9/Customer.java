//****************************************************************************************
//
// @author: Hamza Shahzad ||| Customer.java
// A Customer, either has a ticket or not; 
//
//****************************************************************************************

public class Customer{
  
  private boolean hasTicket = false;
  
  public boolean getTicketState(){
    return hasTicket;
  }
  
  public void setTicketState(boolean answer){
    hasTicket = answer;
  }
  
}