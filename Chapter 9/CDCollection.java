//********************************************************************
//  CDCollection.java       Author: Lewis/Loftus/Cocking
//
//  Represents a collection of compact discs.
//********************************************************************

import java.text.NumberFormat;

public class CDCollection
{
   private ListNode list;
   private int count;
   private double totalCost;

   //-----------------------------------------------------------------
   //  Creates an initially empty collection.
   //-----------------------------------------------------------------
   public CDCollection ()
   {
      list = null;
      count = 0;
      totalCost = 0.0;
   }

   //-----------------------------------------------------------------
   //  Adds a CD to the collection, increasing the size of the
   //  collection if necessary.
   //-----------------------------------------------------------------
   public void addCD (String title, String artist, double cost,
                      int tracks)

   {
     ListNode node = new ListNode(new CD(title, artist, cost, tracks), null);
     ListNode current;
     
      if (list == null)
         list = node;
      else{
        current = list;
          while(current.getNext() != null)
          current = current.getNext();
        current.setNext(node);

      totalCost += cost;
      count++;
      }
   }
   
   public void addCD(CD mixtape){
     addCD(mixtape.getTitle(), mixtape.getSinger(), mixtape.getPrice(), mixtape.getTracks());
   }//---------
   //  Returns a report describing the CD collection.
   //-----------------------------------------------------------------
   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      String report = "******************************************\n";
      report += "My CD Collection\n\n";

      report += "Number of CDs: " + count + "\n";
      report += "Total cost: " + fmt.format(totalCost) + "\n";
      report += "Average cost: " + fmt.format(totalCost/count);

      report += "\n\nCD List:\n\n";

      ListNode thing = list;
      
      
      for (;thing != null; thing = thing.getNext()){
        CD x = (CD)thing.getValue();
         report += x.toString() + "\n";
         
      }

      return report;
   }
   //-----------------------------------------------------------------
   //  Doubles the size of the col
}