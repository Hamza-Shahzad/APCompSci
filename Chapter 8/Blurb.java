//**********************************************************************************************
//
// @author: Hamza Shahzad ||| Blurb.java
// In an alien language that speaks in blurbs, a Blurb is a word that is a Whoozit + a Whatzit
// A Blurb is a: Whoozit + Whatzit
//         or a: Whoozit + many Whatzit
//
//**********************************************************************************************

public class Blurb{
  
  private static Whatzit what = new Whatzit();
  private static Whoozit who = new Whoozit();
  private int whenWhoozitEnds = 1;
  
  public Blurb(){}
  
  public String generateWord(){
    String result;
    int noWhat = (int) (Math.random() * 10 + 1);
    
    result =  who.generate() + makeWhat(noWhat);
    return result;
  }
  
  private String makeWhat(int n){
    String result = what.generate();
    
    if(n != 1)
      result += makeWhat(n-1);
    
    return result;
  }
  public boolean isWhoozit(String answer){
    boolean result = false;
    
    if(answer.charAt(0) == 'x'){
      if(answer.length() == 1)
        result = true;
      else
        result = this.isWhoozit(answer.substring(1, answer.length()));
    }
    else if(answer.length() > 1 && answer.charAt(0) == 'y' && answer.charAt(1) == 's'){
      
      if( answer.length() <= 2 || answer.charAt(2) != 'y'){
        whenWhoozitEnds += 2;
        result = true;
      }
      else{
        whenWhoozitEnds += 2;
        result = this.isWhoozit(answer.substring(2, answer.length()));
      }
    }
    
    return result;
  }
  
  private boolean isWhatzit(String answer){
    boolean result = false;
    
    if(answer.charAt(0) == 'q'){
      if(answer.charAt(1) == 'z' || answer.charAt(1) == 'd'){
        result = isWhoozit(answer.substring(2, answer.length()));
      }
    }
    return result;
  }
  
  public boolean isBlurb(String answer){
    boolean result = false;
    int theq = answer.indexOf('q');
    if(theq != -1){
      if(isWhoozit(answer.substring(0, theq)) && isWhatzit(answer.substring(whenWhoozitEnds, answer.length()))){
      
        result = true;
      }
    }
    return result;
  }
        
  
  public static void main(String[] args){
    
    Blurb b = new Blurb();
    
    String x = "xysysqdxysysysysysysys";
    
    System.out.println(b.isBlurb(x));
    
  }
}
    
    