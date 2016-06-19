//****************************************************************************************
//
// @author: Hamza Shahzad ||| Ticketer.java
// Moves people in and out of line
//
//****************************************************************************************

public class Ticketer{
  
  private CustomerQueue list;
  private static int noCustomers;
  
  public Ticketer(){
    list = new CustomerQueue();
    
  }
  public void add(Customer t){
    list.add(t);
    noCustomers++;
    System.out.println("Customer added");
  }
  public void remove(){
    ListNode temp = (ListNode)list.remove();
    if(temp != null){
      Customer ticket = (Customer)temp.getValue();
      
      ticket.setTicketState(true);
        
      noCustomers--;
      System.out.println("Customer no. " + noCustomers + " has been removed");
    }
  }
  
  public int size(){
    return list.getSize();
  }
  
  public static int totalCustomers(){
    return noCustomers;
  }
    
  private void addRemove(){
    
    while(!list.isEmpty()){//will add and remove
      int rand = (int) (Math.random() * 5);
      
      if(rand > 2){
        
        Customer ticket = new Customer();
        list.add(ticket);

        System.out.println("A customer has been added.");
      }
      else{
        
        ListNode temp = (ListNode)list.remove();
        Customer ticket = (Customer)temp.getValue();
        
        ticket.setTicketState(true);
        
        noCustomers++;
        System.out.println("Customer no. " + noCustomers + " has been removed");
      }
    }
    System.out.println("\nAll Tickets are sold out!");
  }
}
      
      