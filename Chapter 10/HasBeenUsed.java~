//******************************************************************************************
//
// @author: Hamza Shahzad ||| HasBeenUsed.java
// Client enters a string that defines two arrays, with one containing boolean values
// and another containing root TreeNodes if the respective boolean value is true
// The TreeNodes array will be the size of the amount of signs in the string
//
//******************************************************************************************

public class HasBeenUsed{
  
  private String equation;
  private boolean[] used;
  private TreeNode[] rootNodes;
  
  
  public HasBeenUsed(String x){
    
    equation = x;
    used = new boolean[x.length()];
    rootNodes = new TreeNode[searchOperators(x)];
      
  }
  
  public boolean hasItBeenUsed(int index){//index is the index of the string they want to check
    return used[index];
  }
  public TreeNode getRoot(int index){
    return rootNodes[index];
  }
  
  
  private int searchOperators(String n){
    int count = 0;
    
    for(int i = 0; i < n.length(); i++){
      
      if(Operator.isLegalChar(n.charAt(i)))
        count++;
    }
    
    return count;
  }
}