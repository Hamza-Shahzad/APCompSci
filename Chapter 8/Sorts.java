//********************************************************************
//  Sorts.java       Author: Shahzaaad
//
//  Demonstrates the merge sort and algorithms.
//********************************************************************

public class Sorts
{
  private static int rChecks, n2Checks, rSplits, rMerges;
  
   //-----------------------------------------------------------------
   //  Sorts the specified array of integers using merge sort, runs in O(n*log(n))
   //-----------------------------------------------------------------
   public static void mergeSort (int[] numbers)
   {
      doMergeSort(numbers, 0, numbers.length - 1);
   }

   //-----------------------------------------------------------------
   //  Recursively sorts the the portion of the given array beginning
   //  at start and ending at end.
   //-----------------------------------------------------------------
   private static void doMergeSort (int[] numbers, int start, int end)
   {
      if (start < end)
      {
         int middle = (start + end) / 2;
         rSplits++;//split once
         doMergeSort (numbers, start, middle);
         doMergeSort (numbers, middle + 1, end);
         merge (numbers, start, middle, end);
      }
   }

   //-----------------------------------------------------------------
   //  Merges in sorted order the two sorted subarrays
   //  [start, middle] and [middle + 1, end].
   //-----------------------------------------------------------------
   private static void merge (int[] numbers, int start, int middle,
                     int end)
   {
      // This temporary array will be used to build the merged list.
      int[] tmp = new int[end - start + 1];

      int index1 = start;
      int index2 = middle + 1;
      int indexTmp = 0;

      // Loop until one of the sublists is exhausted, adding the smaller
      // of the first elements of each sublist to the merged list.
      while (index1 <= middle && index2 <= end)
      {
         if (numbers[index1] < numbers[index2])
         {
             tmp[indexTmp] = numbers[index1];
             index1++;
         }
         else
         {
             tmp[indexTmp] = numbers[index2];
             index2++;
         }
          indexTmp++;
      }

      // Add to the merged list the remaining elements of whichever sublist
      // is not yet exhausted.
      while (index1 <= middle)
      {
         tmp[indexTmp] = numbers[index1];
         index1++;
         indexTmp++;
      }
      while (index2 <= end)
      {
         tmp[indexTmp] = numbers[index2];
         index2++;
         indexTmp++;
      }
      rChecks++;//keeps track of how many checks have occurred
      
      // Copy the merged list from tmp into numbers.
      for (indexTmp = 0; indexTmp < tmp.length; indexTmp++)
      {
        numbers[start + indexTmp] = tmp[indexTmp];
      }
      rMerges++;//after it has been merged
   }
   
   //runs in O(n^2)
   public static void selectionSort (int[] list)
   {
     int highest;
     int temp;
     
     for (int index = 0; index < list.length-1; index++)
     {
       highest = index;
       for (int scan = index+1; scan < list.length; scan++){
         n2Checks++;
         if (list[scan] < list[highest]) //changed sign to greater than
           highest = scan;
       }
       
       // Swap the values
       temp = list[highest];
       list[highest] = list[index];
       list[index] = temp;
     }
   }
   
   public static void mergeResults(){
     System.out.println("For Merge Sort: \n# of Comparisons: " + rChecks);
     System.out.println("# of Splits: " + rSplits);
     System.out.println("# of Merges: " + rMerges);
   }
   
   public static void selectionResults(){
     System.out.println("For Selection Sort: \n# of Comparisons: " + n2Checks);
   }
   
   
   
   //-----------------------------------------------------------------
   //  Sorts the specified array of integers using quick sort.
   //-----------------------------------------------------------------
   public static void quickSort (int[] numbers)
   {
     doQuickSort(numbers, 0, numbers.length - 1);
   }
   //-----------------------------------------------------------------
   //  Recursively sorts the portion of the given array beginning
   //  at start and ending at end.
   //-----------------------------------------------------------------
   private static void doQuickSort (int[] numbers, int start, int end)
   {
     if (start < end)
     {
       int middle = partition(numbers, start, end);
       doQuickSort(numbers, start, middle);
       doQuickSort(numbers, middle + 1, end);
     }
   }
   
   //-----------------------------------------------------------------
   //  Partitions the array such that each value in [start, middle]
   //  is less than or equal to each value in [middle + 1, end].
   //  The index middle is determined in the procedure and returned.
   //-----------------------------------------------------------------
   private static int partition (int[] numbers, int start, int end)
   {
     int pivot = numbers[0];
     int low = start - 1;
     int high = end + 1;
     
     // As the loop progresses, the indices i and j move towards each other.
     // Elements at i and j that are on the wrong side of the partition are
     // exchanged. When i and j pass each other, the loop ends and j is
     // returned as the index at which the elements are partitioned around.
     while (true)
     {
       low = low + 1;
       while (numbers[low] < pivot)
         low = low + 1;
       
       high = high - 1;
       while (numbers[high] > pivot)
         high = high - 1;
       
       if (low < high)
       {
         int tmp = numbers[low];
         numbers[low] = numbers[high];
         numbers[high] = tmp;
       }
       else return high;
     }
   }
}

