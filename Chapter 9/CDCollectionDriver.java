public class CDCollectionDriver{
  
  public static void main(String[] args){
    
    CD grime = new CD("Mand don't care", "JME", 25, 3);
    CD trap = new CD("Come Get Her", "Rae Sremmud", 35, 10);
    CD rap = new CD("Still Sellin'", "ILoveMakonen", 20.05, 4);
    
    CDCollection list = new CDCollection();
    list.addCD(grime);
    list.addCD(trap);
    list.addCD(rap);
    
    System.out.println(list);
    
  }
}