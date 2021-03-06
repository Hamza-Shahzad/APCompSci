//*****************************************************************************************
//
// @author: Hamza Shahzad ||| ScanEquation.java
// This class will separate each parenthesis, symbol, and number into an ArrayList
// of TreeNodes, and then starts to form trees based on each binary operator

import java.util.*;

public class ScanEquation{

  private String originalEquation;
  private ArrayList<TreeNode> treeList;
  private int elementsRemoved = 0;
  
  public ScanEquation(String n){
    
    originalEquation = n;
    treeList = new ArrayList<TreeNode>();
    
    fillTree();

  }
  
  public TreeNode formTree(){
    return formTree(0, treeList.size());
  }
  
  //Recursive definition that should form binary trees
  private TreeNode formTree(int start, int end){
      
    int currentIndex = findIndexHighestOperandUnused(start, end);//0, treeList.size()
    
    Operator val = (Operator)treeList.get(currentIndex).getValue();
    
    while(treeList.get(currentIndex).getValue().hashCode() == 1111 && ((Operator) treeList.get(currentIndex).getValue()).identify() == '('){
      //when a parenthesis is found, find the end paranthesis, run the method again to solve what is inside the
      //parenthesis, and then remove those parenthesis, 
     int endParan = findEndParan(currentIndex);
     int startParan = currentIndex;
     
     formTree(startParan + 1, endParan);
     
     endParan = findEndParan(startParan);
     treeList.remove(endParan);
     treeList.remove(startParan);
     
     elementsRemoved += 2;
     
     end = updateEnd(end);
     currentIndex = findIndexHighestOperandUnused(start, end);

    }
    
    joinChildrenToParent(currentIndex);
    if(start != 0 && treeList.get(start - 1).getValue().hashCode() == 1111 && ((Operator)treeList.get(start - 1).getValue()).identify() == '(')
      return null;
    
    if(treeList.size() > 1)
      return formTree(0, treeList.size());
    else
      return treeList.get(0);
  }
  
  
  
  private int findIndexHighestOperandUnused(int start, int end){
    int answer = -1;
    
    for(int i = start; i < end; i++){
      
      if(isLegalOperator(treeList.get(i).getValue())){
        Operator val2 = (Operator) treeList.get(i).getValue();
        
          if(val2.identify() == '(')
            return i;
        }
      }
    
    for(int i = start; i < end; i++){
      
      if(isLegalOperator(treeList.get(i).getValue())){
        Operator val2 = (Operator) treeList.get(i).getValue();
        
          if(val2.identify() == '^')
            return i;
        }
      }
    
    for(int i = start; i < end; i++){
      
      if(isLegalOperator(treeList.get(i).getValue())){
        Operator val2 = (Operator) treeList.get(i).getValue();
        
          if(val2.identify() == '*' || val2.identify() == '/')
            return i;
        }
      }
    
    
    for(int i = start; i < end; i++){
      
      if(isLegalOperator(treeList.get(i).getValue())){
        Operator val2 = (Operator) treeList.get(i).getValue();
        
          if(val2.identify() == '+' || val2.identify() == '-')
            return i;
      }
    }
    
    return answer;
  }
  
  //This will make an Operator TreeNode have two children which are either
  //Used Operators or Doubles
  private void joinChildrenToParent(int startingIndex){

      treeList.get(startingIndex).setLeft(treeList.get(startingIndex - 1));//EXCEPTION HERE DUE TO STARTING INDEX = -1
      treeList.get(startingIndex).setRight(treeList.get(startingIndex + 1));
      //proceeds to remove the two numerals used
      treeList.remove(startingIndex + 1);
      treeList.remove(startingIndex - 1);
      
      elementsRemoved += 2;
    
    ((Operator)treeList.get(startingIndex - 1).getValue()).setUsed();
  }
  
  private void fillTree(){
    
    for(int i = 0; i < originalEquation.length(); i++){
      
      if(isNum(originalEquation.charAt(i))){
        int index2 = i + 1;
        
        while(index2 < originalEquation.length() && ( isNum(originalEquation.charAt(index2)) || originalEquation.charAt(index2) == '.') )//if it contains more than one digit
          index2++;
        
        String entry = originalEquation.substring(i, index2);
        Double value = Double.parseDouble(entry);
        treeList.add(new TreeNode(value, null, null));
        
        i = index2 - 1;//since this number is done being parsed, skip over iterating over it
      }
      
      else if(Operator.isLegalChar(originalEquation.charAt(i))){
        
        Operator op = new Operator(originalEquation.charAt(i));
        treeList.add(new TreeNode(op, null, null));
      }
      
    }
          
      
  }
  
  private int updateEnd(int var){
   int answer = var;
    if( var > treeList.size()){
      answer = var - elementsRemoved;
      elementsRemoved = 0;
    }
    
      return answer;
  }
      
  private boolean isNum(char x){
    if( x >= 48 && x <= 57)
      return true;
    else 
      return false;
  }
  
  private boolean isLegalOperator(Object n){
     boolean result = false;
     
    if(n.hashCode() == 1111){
      Operator val2 = (Operator) n;
        
      if(!val2.getUsed())
        result = true;
      
    }
    return result;
  }
  
  //Precondition: treeList.size() == 1
  public double solve(TreeNode start){
    double operand1 = 0;
    double operand2 = 0;
    Operator op = (Operator) start.getValue();
    double answer = 0;
    
    if(start.getLeft().getValue().hashCode() == 1111)
      operand1 = solve(start.getLeft());
    else
      operand1 = (Double) start.getLeft().getValue();
    
    if(start.getRight().getValue().hashCode() == 1111)
      operand2 = solve(start.getRight());
    else
      operand2 = (Double) start.getRight().getValue();

    answer = op.doAction(operand1, operand2);
    
    return answer;
  }
  
  //finds the location of the corresponding end parenthesis
  private int findEndParan(int indexFirstParan){
    
    for(int i = indexFirstParan + 1; i < treeList.size(); i++){
      
      if(treeList.get(i).getValue().hashCode() == 1111){
        
        if(((Operator) treeList.get(i).getValue()).identify() == '(')
          i = findEndParan(i);
        
        else if(((Operator) treeList.get(i).getValue()).identify() == ')')
          return i;
      }
    }
    
    return -1;
  }
  
  private int findStartParan(int indexEndParan){
   
   for(int i = indexEndParan - 1; i >= 0; i--){
    
    if(treeList.get(i).getValue().hashCode() == 1111){
     
     if(((Operator) treeList.get(i).getValue()).identify() == ')')
            i = findStartParan(i);
          
        else if(((Operator) treeList.get(i).getValue()).identify() == '(')
            return i;
    }
   }
   return -1;
  }
  
  public static void main(String[] args){
    
    ScanEquation s = new ScanEquation("(5+3)");
    
    TreeNode ting = s.formTree();
    double answer = s.solve(ting);
    
    System.out.println(answer);
  }

}