//****************************************************************************************
//
// @author: Hamza Shahzad ||| IntegerList.java
// Creates a list of integers that can be sorted through
//
//*****************************************************************************************

public class IntegerList{
  
  private ListNode list = null;
  
  //-------------------------------------------
  //Adds an Integer Object to the list
  //-------------------------------------------
  public void add (Integer num)
  {
    ListNode node = new ListNode (num, null, null);
    ListNode current;
    
    if (list == null){ //if it's the first element of the list, make it the first
      list = node;
      list.setFirst(node);
    }
    else
    {
      current = list;
      while (current.getNext() != null)
        current = current.getNext();
      current.setNext(node);
      node.setPrevious(current);
    }
  }
  //--------------------------------------------------------
  // Deletes the first ocurrence of the integer
  //--------------------------------------------------------
  public void delete (Integer num){
    ListNode deleteThis;

    if(list != null){
      ListNode current = list;
          
      while(current.getValue() != num)//when the list does not equal the element, increment
        current = current.getNext();
      deleteThis = current;
      
      if(deleteThis.getPrevious() == null){//if this is the first element of the list
        deleteThis.getNext().setPrevious(null);//Go to the next element's previous reference, and delete it
        list = deleteThis.getNext();
        deleteThis.setNext(null);
        
      }
      else if (deleteThis.getNext() == null){//if this is the last element of the list
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
  
  //----------------------------------------
  //Uses a selection sort to sort the list
  //----------------------------------------
  public void selectionSort(){
    
    ListNode current = list;
    int smallest;
    try{
    while(current.getValue() != null){
      
      try{
        
      ListNode subCurrent = current;
      smallest = (int) current.getValue();
      
      while (subCurrent.getValue() != null && smallest <= (int) subCurrent.getValue()){//iterate through the list until one of the numbers is greater than the smallest
        subCurrent = subCurrent.getNext();
      }

      if(smallest > (int) subCurrent.getValue()){ //if our smallest # is bigger than their's, swap them
        int temp = (int) subCurrent.getValue();
        subCurrent.setValue(smallest);
        smallest = temp;
        current.setValue(smallest);
      }
      else
        current = current.getNext();
    }    
    
    catch (NullPointerException e) { current = current.getNext(); }    
    }
    }catch(NullPointerException e){}
  }
  //----------------------------------------------
  //Searches the list for largest number and returns it
  //----------------------------------------------
  private int search(){
    ListNode current = list;
    int largest = (int)current.getValue();
    
    while(current != null){
      
      if((int)current.getValue() > largest)
        largest = (int)current.getValue();
      else
        current = current.getNext();
    }
    
    return largest;
  }
  //------------------------------------------
  // Sorts the list through the insertion sort
  //------------------------------------------
  public void insertionSort_OLD(){
        ListNode current = list.getNext();//similar to an array, this current starts at the second element
    int largest = this.search();
    
    while(current != null){
      
      int key = (int)current.getValue();
      ListNode position = current.getPrevious();
      ListNode current2 = current;
      
      while(position != null && (int) position.getValue() > key){
        
        current2.setValue(position.getValue());
        
        position = position.getPrevious();
        
        current2 = current2.getPrevious();
        
      }
      if(position == null){
        position = current2;
        position.setValue(key);//may make a null check?
      }
      else if(current.getNext() == null)//key > (int)position.getValue())
        current2.setValue(key);
      
      if(current2.getNext() != null && (int)current2.getNext().getValue() == largest)
        current2.setValue(key);
      
      current = current.getNext();
    }
  }
  //swaps the values in the nodes
  private void swap(ListNode one, ListNode two){
    int temp = (int)two.getValue();
    two.setValue(one.getValue());
    one.setValue(temp);
  }
//must have one  node on the list
  public void insertionSort() {
    ListNode toBeSorted;//rest of the list
    ListNode sortedList = list;
    ListNode sortedCurrent = list;//very top of the list
    ListNode first = list;
    
    while (list.getNext() != null) {
      toBeSorted = list.getNext();
      sortedCurrent = first;
      
      while (sortedCurrent != null && (int)sortedCurrent.getValue() < (int)toBeSorted.getValue()) {
        sortedCurrent = sortedCurrent.getNext();
      }
      if(sortedCurrent != null && sortedCurrent != toBeSorted)
        swap(sortedCurrent, toBeSorted);
      else
        list = list.getNext();
    }
    
    sortedList = first;
    list = sortedList;
  }
    
  //------------------------------------
  //Prints the result as a String
  //------------------------------------
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