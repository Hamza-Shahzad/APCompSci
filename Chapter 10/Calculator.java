


import java.util.*;

public class Calculator{
  
  private String fullEquation;
  private EquationList el;
  
  public Calculator(String input){
    
    fullEquation = input;
    el = new EquationList(input);
    
    
  }
  public double solve(){
   return solve(fullEquation);
  }
  
  public double solve(String input){
    double answer = 0;
    
   // for(int i = 0; i < input.length(); i++){
      
      if(indexMultDiv(input).size() != 0){
        ArrayList<Integer> indices = indexMultDiv(input);
        
        for(int h = 0; h < indices.size(); h++){
          int[] sub = findStartEnd(input, indices.get(h));
          
          checkIfFinalElementIsLength(sub);
          
          if(sub[0] == 0 || !el.getBoolean(sub[0])){
            SmallEq thing = new SmallEq(input.substring(sub[0], sub[1]));
            el.setEquation(thing, sub[0], sub[1]);
          }
          else{
            SmallEq thing = new SmallEq(el.getEquation(sub[0] -1), input.substring(sub[0] , sub[1]));//does sub[0] ever contain a sign?
            el.setEquation(thing, sub[0], sub[1]);
          }
        }
      }
    
   // for(int i = 0; i < input.length(); i++){
      if(indexAddSub(input).size() != 0){
        
        ArrayList<Integer> indices = indexAddSub(input);
        
        for(int h = 0; h < indices.size(); h++){
          int[] sub = findStartEnd(input, indices.get(h));
          
          checkIfFinalElementIsLength(sub);
                                      
          if(sub[0] == 0 ||!el.getBoolean(sub[0])){
               if(!el.getBoolean(sub[0]  + (sub[1] - (sub[0] + 1)))){//+2 used to be here
                 
                 SmallEq thing = new SmallEq(input.substring(sub[0], sub[1]));
                 el.setEquation(thing, sub[0], sub[1]);
               }
               else{
                 SmallEq thing = new SmallEq( input.substring(sub[0] , sub[1] - 1), el.getEquation(sub[1]));
                 el.setEquation(thing, sub[0], sub[1]);
               }
          }
          else if(el.getBoolean(sub[0])){
            SmallEq thing = new SmallEq(el.getEquation(sub[0]), input.substring(sub[0] + 1, sub[1]));
            el.setEquation(thing, sub[0], sub[1]);
          }
          else{
            SmallEq thing = new SmallEq( input.substring(sub[0] , sub[1] - 1), el.getEquation(sub[1]));
            el.setEquation(thing, sub[0], sub[1]);
          }
        }
      }
    
  
    return el.returnRecent().getAnswer();
  }
  
  //finds the indices of all multiplication and division signs
  private ArrayList<Integer> indexMultDiv(String eval){
    ArrayList<Integer> arr = new ArrayList<Integer>();
      
    for(int i = 0; i < eval.length(); i++){
      
      if(eval.charAt(i) == '*' || eval.charAt(i) == '/')
        arr.add(i);
    }
    
    return arr;
  }
  
  private ArrayList<Integer> indexAddSub(String eval){
    ArrayList<Integer> arr = new ArrayList<Integer>();
      
    for(int i = 0; i < eval.length(); i++){
      
      if(eval.charAt(i) == '+' || eval.charAt(i) == '-')
        arr.add(i);
    }
    
    return arr;
  }
  
  //finds the start and end of the equation's indices
  //result[0] does not point to the operator
  //result[1] points to the rightmost operator
  private int[] findStartEnd(String eval, int locSign){
    
    int[] result = new int[2];
    
    for(int i = locSign - 1; i > -1; i--){//locSign is the exact location of the sign
      
      if(i == 0 )
        result[0] = i;
      else if( Operator.isLegalChar(eval.charAt(i))){
        result[0] = i + 1;
        break;
      }
    }
    for(int p = locSign + 1 ; p < eval.length() ; p++){
      
      if(p == eval.length() - 1)
        result[1] = p;
      else if(Operator.isLegalChar(eval.charAt(p))){
        result[1] = p;
        break;
      }
      
    }
    
    return result;
  }
  
  private void checkIfFinalElementIsLength(int[] indices){
    
    if(indices[1] == fullEquation.length() -1)
       indices[1] = fullEquation.length();
  }
  
  public static void main(String[] args){
    
    Calculator x = new Calculator("3*24/2-3*4+2*6");
    System.out.println(x.solve());
  }
}