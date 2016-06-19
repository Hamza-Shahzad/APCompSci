//******************************************************************************************
//
// @author: Hamza Shahzad ||| Operator.java
// Supports the operators + - * /
//
//******************************************************************************************

public class Operator{
  
  private char op;
  private boolean used = false;
  
  public Operator(char x){
    if(isLegalChar(x))
      op = x;
    else
      throw new RuntimeException("Illegal Operator");
  }
  
  
  public static boolean isLegalChar(char x){
    
    if(x == '+' || x == '-' ||
       x == '*' || x == '/' ||
       x == '(' || x == ')' ||
       x == '^' || x == 'e')
      return true;
    else
      return false;
  }
  
  public static int indexOfOperator(String x){
    int result = -1;
    
    for(int i = 0; i < x.length(); i++){
      if(isLegalChar(x.charAt(i)))
        result = i;
    }
    
    return result;
  }
  
  
  
  public double doAction(double num1, double num2){
    
    if(op == '+')
      return num1 + num2;
    else if(op == '-')
      return num1 - num2;
    else if(op == '*')
      return num1 * num2;
    else if(op == '/')
      return num1 / num2;
    else 
      return Math.pow(num1,num2);
  }
  
  public char identify(){
    return op;
  }
  
  public void setUsed(){
    used = !used;
  }
  
  public boolean getUsed(){
    return used;
  }
  
  public int hashCode(){
    return 1111;
  }
              
}