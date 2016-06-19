//******************************************************************************************
//
// @author: Hamza Shahzad ||| sortNums.java
// Write a merge sort and an O(n^2) sort in a test program.  The runner of the program 
// should loop asking the user how many items to sort.  Make an array of ints that many long 
// and run the mergesort first on the array and print number of comparisions done 
// (<, >, =, etc), number of splits, number of merges and how long the sort took to run. 
// Then unsort the array, ransomize it again, and sort it using the O(n^2) algorithm sort 
// and print out the number of comparisons done and how long the sort took to run.
//
//******************************************************************************************

import java.util.Scanner;
import java.text.DecimalFormat;

public class sortNums{
  
  public static void randomize(int[] nums){
    
    for(int x = 0; x < nums.length; x++) //O(n)
      nums[x] = (int) (Math.random() * 1000);
  }
  
  public static void main(String[] args){
    
  DecimalFormat formatter = new DecimalFormat("#,###");
  Scanner scan = new Scanner(System.in);
  
  System.out.println("How many items do you want to sort?");
  
  int size = scan.nextInt();
  int[] list = new int[size];
  sortNums.randomize(list);
  
  long start = System.nanoTime();
  Sorts.mergeSort(list);
  long ending = System.nanoTime() - start;
  
/*  for(int x : list)
    System.out.print(x + " "); */
  System.out.println();
  
  Sorts.mergeResults();
  System.out.println("Amount of time it took: " + formatter.format(ending) + " ns");
  System.out.println();
  
  sortNums.randomize(list);
  
  start = System.nanoTime();
 // Sorts.quickSort(list);
  ending = System.nanoTime() - start;
  
 /* for(int x : list)
    System.out.print(x + " "); */
  System.out.println();
  
  //System.out.println("Amount of time it took: " + formatter.format(ending) + " ns");
  }
}
    
    
  