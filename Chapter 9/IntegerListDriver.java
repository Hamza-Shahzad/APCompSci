//**********************************************************************
//
// @author: Hamza Shahzad ||| IntegerListDriver.java
//
//**********************************************************************
import java.util.Scanner;

public class IntegerListDriver{
  
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    IntegerList list = new IntegerList();
    IntegerList list2 = new IntegerList();
    int next;
 /*   
    do{
      System.out.println("Enter a number(-789 to stop program)");
      next = scan.nextInt();
      if(next != -789)
        list.add(next);
    }while(next != -789);
    
    System.out.println(list);
    list.selectionSort();
    System.out.println("Selection sort: \n" + list);
    */
    do{
      System.out.println("Enter a number(-789 to stop program)");
      next = scan.nextInt();
      if(next != -789)
        list2.add(next);
    }while(next != -789);
    
    System.out.println(list2);
    list2.insertionSort();
    System.out.println("Insertion sort: \n" + list2);
  }
}
    
    