//****************************************************************************************
//
// @author: Hamza Shahzad ||| DivisorCalc.java
// Class made to calculate the greatest common denominator of two numbers using the
// Euclidean algorithm
//
//****************************************************************************************

import java.util.Scanner;

public class DivisorCalc{
  
  public static int gcd(int num1, int num2){
    int result = 0;
    
    //if the second number is less than or equal to 
    //the first, and is divisible to the first one
    if(num2 <= num1 && num1 % num2 == 0)
      result = num2;
    
    //if the first number is less than the second,
    //switch the order of the numbers
    else if(num1 < num2)
      result = gcd(num2, num1);
    
    //otherwise try to find the two numbers that could fit
    //into it.
    else
      result = gcd(num2, num1 % num2);
    
    return result;
  }
  
  public static void main(String[] args){   
    
    Scanner scan = new Scanner(System.in);
    
    int n1, n2;
    String answer;
    
    do{
      
      System.out.println("Enter a number you'd like see if it's divisible by:");
      n1 = scan.nextInt();
      System.out.println("Another:");
      n2 = scan.nextInt();
      
      System.out.println("GCD = " + DivisorCalc.gcd(n1, n2));
      
      System.out.println("run again?");
      
      answer = scan.next();
      
    } while(answer.charAt(0) == 'y');
  }
}