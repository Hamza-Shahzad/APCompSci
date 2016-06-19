public class TicketerDriver{
  
  private static Ticketer searchSmall(Ticketer[] machines){
    
    Ticketer smallest = machines[0];
    for(int i = 1; i < machines.length; i++){
      
      if(machines[i].size() < smallest.size())
        smallest = machines[i];
    }
    
    return smallest;
  }
  
    private static Ticketer searchLarge(Ticketer[] machines){
    
    Ticketer largest = machines[0];
    for(int i = 1; i < machines.length; i++){
      
      if(machines[i].size() > largest.size())
        largest = machines[i];
    }
    
    return largest;
  }
  public static void main(String[] args){
    
    Ticketer[] queuedLine = new Ticketer[4];
    
    for(int i = 0; i < queuedLine.length; i++){
      queuedLine[i] = new Ticketer();
      
      for(int j = 0; j < 5; j++){
        Customer t = new Customer();
        queuedLine[i].add(t);
      }
    }
    
    do{
      int rand = (int) (Math.random() * 5);
      
      if(rand > 2){
        Customer ticket = new Customer();
        searchSmall(queuedLine).add(ticket);
      }
      else if(Ticketer.totalCustomers() > 0)
        searchLarge(queuedLine).remove();
    }while(Ticketer.totalCustomers() != 0);
  }
}