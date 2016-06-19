public class TestChild extends TestParent implements DoIt{
  
  public TestChild(){
   super();
    System.out.println("World!");
  }
  public int calculate(int x){
    cow = x;
    return cow;
  }
  
  public String whereIsTheCow(){
    location = "The Park";
    return location;
  }
}