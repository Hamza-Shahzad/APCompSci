//****************************************************************************************
//
// @author: Hamza Shahzad ||| SmallEq.java
// A 'SmallEq' is a small equation with only one operator and two operands
// The operands may be another 'SmallEq', returns a small tree of the operands and
// operands
//
//****************************************************************************************

import java.util.*;

public class SmallEq{
  
  private Operator sign;
  private double operand1;
  private double operand2;
  private double answer;
  private TreeNode result;
 
  public SmallEq(String x){
    parseString(x);
    makeTree();
  }
  
  //String x in this case is an operator and a number
  // [3 * 5] - 2
  //In this case, the brackets are a SmallEq, and the 2 is operand2
  public SmallEq(SmallEq express, String x){
    parseString(express, x);
    makeTree(express, x);
  }
  
  //String x in this case is a number and an operator
  // 5 - [12 / 4]
  //In this case, the brackets are a SmallEq, and the 5 is operand1
  public SmallEq(String x, SmallEq express){
      parseString(x, express);
      makeTree(x, express);
  }

   //Both cases are SmallEq's
  public SmallEq(SmallEq express1, SmallEq express2, Operator op){
    sign = op;
    parseString(express1, express2);
    makeTree(express1, express2);
  }
  
  
  //Works when only a String is entered in the constructor
  //Precondition: the String only contains one operator and no parenthesis
  private void parseString(String x){
  
    int indexOfOp = Operator.indexOfOperator(x);
    sign = new Operator(x.charAt(indexOfOp));
                      
    String op1 = x.substring(0, indexOfOp);
    String op2 = x.substring(indexOfOp + 1, x.length());
    
    operand1 = Double.parseDouble(op1);
    operand2 = Double.parseDouble(op2);
    
    answer = sign.doAction(operand1, operand2);
  }
  
  //Works when the first param is an expression, and the second is an operator with a number
  private void parseString(SmallEq express, String x){
    
    int indexOfOp = Operator.indexOfOperator(x);
    sign = new Operator(x.charAt(indexOfOp));
    
    String op2 = x.substring(indexOfOp + 1, x.length());
    
    operand1 = express.getAnswer();
    operand2 = Double.parseDouble(op2);
    
    answer = sign.doAction(operand1, operand2);
  }
  
  private void parseString(String x, SmallEq express){
    
    int indexOfOp = Operator.indexOfOperator(x);
    sign = new Operator(x.charAt(indexOfOp));
    
    String op1 = x.substring(0, indexOfOp);
    
    operand1 = Double.parseDouble(op1);
    operand2 = express.getAnswer();
    
    answer = sign.doAction(operand1, operand2);
  }
  
  private void parseString(SmallEq expr1, SmallEq expr2){
    operand1 = expr1.getAnswer();
    operand2 = expr2.getAnswer();
    
    answer = sign.doAction(operand1, operand2);
  }
  


  public double getAnswer(){
    return answer;
  }
  
  private void makeTree(SmallEq one, String not){
    result = new TreeNode(this,null, null);
    result.setLeft(one.getTree());
    result.setRight(new TreeNode(operand2, null, null));
  }
  
  private void makeTree(String not, SmallEq two){
    result = new TreeNode(this, null, null);
    result.setLeft(new TreeNode(operand1, null, null));
    result.setRight(two.getTree());
  }
  
  private void makeTree(SmallEq one, SmallEq two){
    result = new TreeNode(this, one.getTree(), two.getTree());
  }
  
  private void makeTree(){
    
    result = new TreeNode(this, null, null);
    result.setLeft(new TreeNode(operand1, null, null));
    result.setRight(new TreeNode(operand2, null, null));
 
  }
  
  public TreeNode getTree(){
    return result;
  }
  
  public static void main(String[] args){
    boolean yes = true;
    
    
    SmallEq x = new SmallEq("3+5");
    SmallEq y = new SmallEq("-5*", x);
    Operator op = new Operator('/');
    if(!yes)
      System.out.println("Hello");;
    SmallEq z = new SmallEq(y, x, op);
    
    System.out.println(z.getTree().getLeft().getRight().getRight().getValue());
}
}
    
      