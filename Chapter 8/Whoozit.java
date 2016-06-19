//*********************************************************************************************
//
// @author: Hamza Shahzad ||| Whoozit.java
// In an alien language that speaks in blurbs, a whoozit is one component of a blurb
// A whoozit is a: "x"
//           or a: "xys"
//           or a: "xysysys...ys"
//
//*********************************************************************************************

public class Whoozit{
  
  private int numberOfYS;
  
  public Whoozit(){}
  
  public String generate(){
    String response;
    
    numberOfYS = (int) (Math.random() * 8);
    
    response = "x" + this.addYS(numberOfYS);
    
    return response;
  
  }
  
  private String addYS(int times){
    String result = "";
    
    if(times == 1)
      result += "ys";
    else if(times < 1)
      result = "";
    else
      result += "ys" + this.addYS(times - 1);
    
    return result;
  }
  
  public static void main(String[] args){
    
    Whoozit a = new Whoozit();
    
    for(int i = 0; i < 3; i++)
      System.out.println(a.generate());
    
  }
}