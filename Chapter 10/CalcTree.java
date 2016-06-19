//******************************************************************************
//
// @author: Hamza Shahzad ||| CalcTree.java
// Scans a String for PEMDAS and inserts small parts of equations as SmallEq
// 5-3*8/4
// would be 5-[[3*8]/4]
//
//*******************************************************************************
import java.util.*;


public class CalcTree{

  private String fullEquation;
  private char[] arrEq;
  private double answer;
  private boolean[] usedChars;
  private SmallEq[] equations;
  
  public CalcTree(String eq){
    fullEquation = eq;
    arrEq = fullEquation.toCharArray();
    usedChars = new boolean[arrEq.length];
    equations = new SmallEq[arrEq.length];
    
    //write an evaluate method
  }
  
  private SmallEq evaluate(String toEval){
    SmallEq result = null;
    char[] toEvalChar = toEval.toCharArray();
    
    for(int i = 0; i < toEvalChar.length; i++){
      
      if(indexMultDiv(toEval).size() != 0){
        ArrayList<Integer> indices = indexMultDiv(toEval);
        
        for(int j = 0; j < indices.size(); j++)
    }
    return result;
  }
  
  //This method should be used when there are parenthesis
  //to see how many operators there are
  //Parameters: firstPar is index of '('
  //secondPar is index of ')'
  private int howManyOperators(int firstPar, int secondPar){
    int count = 0;
    
    for(int i = firstPar + 1; i < secondPar; i++){
      if(Operator.isLegalChar(arrEq[i]))
        count++;
    }
    
    return count;
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
  
  //returns [a (operator) b]
  private String getOpSubstring(String x, int indexOp){
    
    String result = null;
    
    
}