//********************************************************************
// PalindromeTester.java Author: Lewis/Loftus/Cocking
//
// Demonstrates the use of nested while loops.
//********************************************************************
import java.util.Scanner;
public class PalindromeTester
{
  public static boolean isPalindrome(String str){
    str = str.toLowerCase();
    
    boolean result;
    
    if(str.length() == 1 || str.length() == 0)
      result = true;
    else if(str.charAt(0) == str.charAt(str.length() - 1))
      result = isPalindrome(str.substring(1, str.length() - 1));
    else
      result = false;
    
    return result;
  }
//-----------------------------------------------------------------
// Tests strings to see if they are palindromes.
//-----------------------------------------------------------------
  public static void main (String[] args)
  {
    String str, another = "y";
    Scanner scan = new Scanner(System.in);
    
    while (another.equalsIgnoreCase("y")) // allows y or Y
    {
      System.out.println ("Enter a potential palindrome:");
      str = scan.nextLine();
      
      System.out.println();
      
      if (isPalindrome(str))
        System.out.println ("That string IS a palindrome.");
      else
        System.out.println ("That string is NOT a palindrome.");
      
      
      System.out.println();
      System.out.print ("Test another palindrome (y/n)? ");
      
      another = scan.next();
      scan.nextLine();
    }
  }
} 