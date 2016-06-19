//********************************************************************
//  Sorting.java       Author: Lewis/Loftus
//
//  Demonstrates the selection sort and insertion sort algorithms.
//********************************************************************

public class Sorts
{
   //-----------------------------------------------------------------
   //  Sorts the specified array of objects using the selection
   //  sort algorithm.
   //-----------------------------------------------------------------
   public static void selectionSort (Comparable[] list)
   {
      int highest;
      Comparable temp;

      for (int index = 0; index < list.length-1; index++)
      {
         highest = index;
         for (int scan = index+1; scan < list.length; scan++)
            if (list[scan].compareTo(list[highest]) > 0) //changed sign to greater than
               highest = scan;

         // Swap the values
         temp = list[highest];
         list[highest] = list[index];
         list[index] = temp;
      }
   }
   //-----------------------------------------------------------------
   //Overloaded Selection sort that sorts any Object somehow
   //-----------------------------------------------------------------
   public static void selectionSort (Object[] list){
     String least;
     Object temp;
     for(int i = 0; i < list.length - 1; i++){
       least = list[i].toString();
       for(int j = i + 1; j < list.length; j++){
         if(list[i].toString().compareTo(list[j].toString()) > 0){
           temp = list[i];
           list[i] = list[j];
           list[j] = temp;
         }
       }
     }
   }
   //-----------------------------------------------------------------
   //  Sorts the specified array of objects using the insertion
   //  sort algorithm.
   //-----------------------------------------------------------------
   public static void insertionSort (Comparable[] list)
   {
      for (int index = 1; index < list.length; index++)
      {
         Comparable key = list[index];
         int position = index;

         //  Shift larger values to the right
         while (position > 0 && key.compareTo(list[position-1]) > 0) //changed the less than key to greater than
         {
            list[position] = list[position-1];
            position--;
         }
            
         list[position] = key;
      }
   }
}