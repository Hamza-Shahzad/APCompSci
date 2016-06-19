//*******************************************************************
// MagazineList.java Author: Lewis/Loftus/Cocking
//
// Represents a collection of magazines.
//*******************************************************************
public class MagazineList
{
  private ListNode list;
//---------------------------------------------------------------- 
// Sets up an empty list of magazines.
//---------------------------------------------------------------- 
  public MagazineList()
  {
    list = null;
  }
//---------------------------------------------------------------- 
// Creates a new MagazineNode object and adds it to the end of
// the linked list.
//---------------------------------------------------------------- 
  public void add (Magazine mag)
  {
    ListNode node = new ListNode (mag, null, null);
    ListNode current;
    if (list == null) //if it's the first element of the list
      list = node;
    else
    {
      current = list;
      while (current.getNext() != null)
        current = current.getNext();
      current.setNext(node);
      node.setPrevious(current);
    }
  }
  //---------------------------------------------------------------------------------------
  //Deletes a magazine by using the name of the magazine
  //---------------------------------------------------------------------------------------
  public void delete (Magazine mag){
    ListNode deleteThis;

    if(list != null){
      ListNode current = list;
          
      while(!current.getValue().toString().equals(mag.toString()))//when the list does not equal the element, increment
        current = current.getNext();
      deleteThis = current;
      
      if(deleteThis.getPrevious() == null){
        deleteThis.getNext().setPrevious(null);//Go to the next element's previous reference, and delete it
        deleteThis.setNext(null);
      }
      else if (deleteThis.getNext() == null){
        deleteThis.getPrevious().setNext(null);//Go to the previous element's next reference, and delete it
        deleteThis.setPrevious(null);
      }
      else{
        deleteThis.getPrevious().setNext(deleteThis.getNext());//Go to the previous element, and set that next element to this element's next
        deleteThis.getNext().setPrevious(deleteThis.getPrevious());//Go to the next element, and set that previous element to this element's previous
        
        deleteThis.setPrevious(null);
        deleteThis.setNext(null);
      }
    }
  }
  public void insert(Magazine mag, String previousTitle){//user enters what the magazine before they would like to be if it's in the middle or end
    if(list == null)
      add(mag);

    else{
      ListNode myElement = new ListNode(mag, null, null);
      ListNode current = list;
      
      while(!current.getValue().toString().equals(previousTitle))//when the list does not equal the element, increment
        current = current.getNext(); //current eventually equals the previous title
      
      if(current.getNext() == null)
        add(mag);
      else{
        ListNode newNext = current.getNext();
        current.setNext(myElement);
        myElement.setPrevious(current);
        myElement.setNext(newNext);
        newNext.setPrevious(myElement);
      }
    }
  }
  
  public void insert(Magazine mag){
    ListNode current = list;
    ListNode myElement = new ListNode(mag, null, current);

    current.setPrevious(myElement);
    current.setValue(mag);
  }
      
//---------------------------------------------------------------- 
// Returns this list of magazines as a string.
//---------------------------------------------------------------- 
  public String toString ()
  {
    String result = "";
    ListNode current = list;
    while (current != null)
    {
      result += current.getValue().toString() + "\n";
      current = current.getNext();
    }
    return result;
  }
}