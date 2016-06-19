//***************************************************************************************
//
//@author: Hamza Shahzad ||| CH6PP3.java
// Uses the sort class to sort a list of integers from greatest to least
//
//***************************************************************************************

import java.util.Scanner;
public class Ch6PP3 {
  public static void main(String[] args){
 
    Integer[] xi = {3, 1, 2, 4 , 2};
    Integer[] xii = {2, 8, 4, 9, 2, 20, 37, 29, 12};
    
    Sorts.selectionSort(xi);
    for(int i: xi)
      System.out.println(i);
    
    System.out.println();
    
    Sorts.selectionSort(xii);
    for(int i: xii)
      System.out.println(i);
  }
}

