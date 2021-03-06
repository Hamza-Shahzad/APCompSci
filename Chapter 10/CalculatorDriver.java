
import java.util.Scanner;

public class CalculatorDriver{
  
  public static void main(String[] args){
    
    Scanner scan = new Scanner(System.in);
    String entry = "";
    do{
      
      System.out.println("Enter an equation(or -1 to exit the program)");
      entry = scan.next();
      ScanEquation s = new ScanEquation(entry);
      
      if(!entry.equals("-1")){
        
        TreeNode eq = s.formTree();
        System.out.println(s.solve(eq));
      }
    }while(!entry.equals("-1"));
  }
  }