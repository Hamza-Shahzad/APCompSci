//****************************************************************************************
//
// @author: Hamza Shahzad ||| Whatzit.java
// In an alien language that speaks in blurbs, a whatzit is a component of a Blurb
// A Whatzit is a: "qz" + Whoozit
//           or a: "qd" + Whoozit
//
//****************************************************************************************

public class Whatzit{
  
  private static Whoozit who = new Whoozit();
  
  public Whatzit(){}
  
  public String generate(){
    
    String result = "q";
    int chance = (int) (Math.random() * 2);
    
    if(chance == 0)
      result += "z";
    else 
      result += "d";
    
    result += who.generate();
    
    return result;
    
  }
  
  public static void main(String[] args){
    Whatzit w = new Whatzit();
    
    for(int i = 0; i < 5; i++)
      System.out.println(w.generate());
    
  }
}