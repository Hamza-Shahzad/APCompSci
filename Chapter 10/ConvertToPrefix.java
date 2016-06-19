//****************************************************************************************
//
// @author: Hamza Shahzad ||| ConvertToPostfix.java
// Converts an infix expression to a prefix expression
//
//****************************************************************************************
import java.util.*;

public class ConvertToPrefix{
  
  public static CharOrInt[] convert(String infix){
    
    String infixRev = reverseString(infix);
    CharOrInt[] infixReal = convertToCharInt(infixRev);
    Stack stack = new Stack();
    Stack preResult = new Stack();
    
    for(int i = 0; i < infixReal.length; i++){
      
      if(infixReal[i] != null && infixReal[i].isChar() && infixReal[i].getChar() != ' '){
        
        if(infixReal[i].getChar().charValue() == ')')
          stack.push(infixReal[i]);
        
        else if(infixReal[i].getChar().charValue() == '('){
          while(!stack.isEmpty() && ((CharOrInt)stack.peek()).getChar().charValue() != ')')
            preResult.push(stack.pop());
          stack.pop();
        }
        
        else if(infixReal[i].getChar().charValue() == '*' || infixReal[i].getChar().charValue() == '/')
          stack.push(infixReal[i]);
        
        else if(infixReal[i].getChar().charValue() == '+' || infixReal[i].getChar().charValue() == '-'){
        
          if(!stack.isEmpty() && (((CharOrInt)stack.peek()).getChar().charValue() == '*' || ((CharOrInt)stack.peek()).getChar().charValue() == '/')){
            
            while(!stack.isEmpty() && (((CharOrInt)stack.peek()).getChar().charValue() != '*' || ((CharOrInt)stack.peek()).getChar().charValue() != '/'))
              preResult.push(stack.pop());
          }
          
          stack.push(infixReal[i]);
        }
      }
      else if(infixReal[i] != null)//why don't i add spaces which will just be added?
        preResult.push(infixReal[i]);
    }
    while(!stack.isEmpty())
      preResult.push(stack.pop());
    
    while(isThereNull(preResult))
      preResult.remove(null);
    
    /*Object[] objResult = preResult.toArray();
    Character[] charResult = new Character[objResult.length];
    charResult = (Character[])preResult.toArray(new Character[preResult.size()]);
    char[] typeCharRes = toCharArray(charResult);*/
    CharOrInt[] finalResult = (CharOrInt[])preResult.toArray(new CharOrInt[preResult.size()]);
    
    reverseArray(finalResult);
    
    
   // String finalResult = new String(typeCharRes);
    
    return finalResult;
  }
  
  
  private static String reverseString(String x){
    String result = "";
    
    for(int i = x.length() - 1; i >= 0; i--)
      result += x.charAt(i);
    
    return result;
  }
  private static char[] toCharArray(Character[] a){
    char[] result = new char[a.length];
    
    for(int i = 0; i < a.length; i++)
      result[i] = a[i];
    
    return result;
  }
  private static void reverseArray(CharOrInt[] a){
    
    for(int i = 0; i < a.length / 2; i++)
    {
      CharOrInt temp = a[i];
      a[i] = a[a.length - i - 1];
      a[a.length - i - 1] = temp;
    }
  }
  
  private static CharOrInt[] convertToCharInt(String val){
    CharOrInt[] answer = new CharOrInt[val.length()];
    int[] locations = locationOfSpaces(val);
    int answerCount = 0;
    
    
    for(int i = 0; i < locations.length - 1; i++){
      String sub = val.substring(locations[i], locations[i + 1]);
      
      if(sub.length() > 2){
        sub = new StringBuilder(sub).reverse().toString();
        Integer ans = Integer.parseInt(sub.substring(0, sub.length() - 1));
        answer[answerCount] = new CharOrInt(ans);
        answerCount++;
      }
      else if(sub.indexOf("+") != -1 || sub.indexOf("-") != -1 || sub.indexOf("*") != -1 || sub.indexOf("/") != -1 ||
      sub.indexOf("(") != -1 || sub.indexOf(")") != -1){
        
        if(sub.indexOf("+") != -1)
          answer[answerCount] = new CharOrInt('+');
        else if(sub.indexOf("-") != -1)
          answer[answerCount] = new CharOrInt('-');
        else if(sub.indexOf("*") != -1)
          answer[answerCount] = new CharOrInt('*');
        else if(sub.indexOf("/") != -1)
          answer[answerCount] = new CharOrInt('/');
        else if(sub.indexOf("(") != -1)
          answer[answerCount] = new CharOrInt('(');
        else
          answer[answerCount] = new CharOrInt(')');
        
        answerCount++;
      }
      else{
        Integer ans = Integer.parseInt(sub);
        answer[answerCount] = new CharOrInt(ans);
        answerCount++;
      }
      if(answerCount < answer.length){
        answer[answerCount] = new CharOrInt(' ');
        answerCount++;
      }
    }
    
    String sub2 = val.substring(locations[locations.length -1], val.length());
    Integer ans = Integer.parseInt(sub2.substring(1));
    answer[answerCount] = new CharOrInt(ans);
    answerCount++;
    
    return answer;
  }
  
  private static int numSpaces(String val){
    int result = 0;
    for(int i = 0; i < val.length(); i++){
      
      if(val.charAt(i) == ' ')
        result++;
    }
    return result;
  }
  private static int[] locationOfSpaces(String val){
    int[] result = new int[numSpaces(val) + 1];
    int count = 1;
    for(int i = 0; i < val.length(); i++){
      
      if(val.charAt(i) == ' '){
        result[count] = i;
        count++;
      }
    }
    return result;
  }
  
  
  private static boolean isThereNull(Stack e){
    boolean result = false;;
    
    for(int i = 0; i < e.size(); i++){
      if(e.get(i) == null)
        result = true;
    }
    return result;
  }
  
  public static void main(String[] args){
    
    String thing = "5 * 12 + 105 / 5";
    CharOrInt[] result = ConvertToPrefix.convert(thing);
    
    for(CharOrInt x : result)
      System.out.print(x);
  }
  
}


    