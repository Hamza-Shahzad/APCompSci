//****************************************************************************************
//
// @author: Hamza Shahzad ||| PascalTriangle.java
// 
//****************************************************************************************
import java.util.Scanner;
public class PascalTriangle {

   public static void print(int numRows) {
       for (int i = 0; i < numRows; i++) {
           for (int j = 0; j <= i; j++) {
            // System.out.print(PascalTriangle.getSpaces((numRows - j) - 1 ));
             
             System.out.print(pascal(i, j) + " ");
           }
           System.out.println();
       }
   }

   private static int pascal(int row, int col) {
     int result;
     
     if (col == 0) 
       result = 1;
     
      else if (col == row) 
       result = 1;
      
      else 
       result = pascal(row - 1, col - 1) + pascal(row - 1, col);
     
     return result;
   }
   
   private static String getSpaces(int num){
     String space = "";
     
     for(int i = 0; i < num; i++){
       space += " ";
     }
     
     return space;
   }
   
   public static void main(String[] args){
     
     Scanner scan = new Scanner(System.in);
     
     int num;
     
     System.out.println("Enter num:");
     
     num = scan.nextInt();
     
     print(num);
   }
}