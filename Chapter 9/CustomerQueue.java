//****************************************************************************************
//
// @author: Hamza Shahzad ||| CustomerQueue.java
// Implements the Queue method on the Customer class
//
//****************************************************************************************
import java.util.*;


public class CustomerQueue{
  
  private ListNode list;
  private int size;
  
  public CustomerQueue(){
    
    list = null;
  }
  //------------------------------
  //Adds a Customer to the end
  //------------------------------
  public boolean add(Customer obj){
    
    Customer firstIn = obj;
    
    ListNode node = new ListNode (firstIn, null, null);
    ListNode current;
    
    if (list == null){ //if it's the first element of the list, make it the first
      list = node;
      
    }
    else
    {
      current = list;
      while (current.getNext() != null)//continue untill the end of the list, then insert it
        current = current.getNext();
      current.setNext(node);
      node.setPrevious(current);
    }
    //Look at the IntegerList add method, implement it exactly like that
    //Start changing the code at the remove method, and take off the top
    //one only. Look and modify the delete method of the IntegerList
    size++;
    return true;
  }
  
  //--------------------------------------------
  //Deletes the Object and returns it
  //--------------------------------------------
  public Object remove (){
    ListNode deleteThis = list;
    ListNode returned = null;
    
    if(list != null && list.getNext() != null){
     
      //this is the first element of the list
      returned = deleteThis.getNext();
      deleteThis.getNext().setPrevious(null);//Go to the next element's previous reference, and delete it
      list = deleteThis.getNext();
      deleteThis.setNext(null);
      
    }
    else if(list != null){//this is the last element
      returned = deleteThis;
      deleteThis.setPrevious(null);
      list.setNext(null);
    }
    size--;
    return returned;
  }
  //------------------------------------------
  //Allows the client to see the next element
  //------------------------------------------
  public Object peek(){
    return list;
  }
  //-------------------------------------------
  //Checks if the list is empty
  //-------------------------------------------
  public boolean isEmpty(){
    if(list.getNext() == null)
      return true;
    else
      return false;
  }
  
  public int getSize(){
    return size;
  }
}