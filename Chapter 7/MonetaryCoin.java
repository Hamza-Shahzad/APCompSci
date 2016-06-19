//****************************************************************************************
//
// @author: Hamza Shahzad ||| MonetaryCoin.java
// Uses the Coin class and stores a value
//
//****************************************************************************************

public class MonetaryCoin extends Coin{
  private double value;
  
  public MonetaryCoin(){
    super();
  }
  
  public double getValue(){
    return value;
  }
  public void setValue(double x){
    value = x;
  }
  
}