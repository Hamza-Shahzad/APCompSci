public class ListNode{
  
  private Object value;
  private ListNode previous;
  private ListNode next;
  private ListNode top;
  
  public ListNode (Object initValue, ListNode initNext, ListNode initPrevious)
  {
    value = initValue;
    next = initNext;
    previous = initPrevious;
  }
//-----------------------------------------------------------------
//Returns the value of this node.
//----------------------------------------------------------------- 
  public Object getValue ()
  {
    return value;
  }
//----------------------------------------------------------------- 
//Returns the next reference in this node.
//----------------------------------------------------------------- 
  public ListNode getNext ()
  {
    return next;
  }
//-----------------------------------------------------------------
//Returns the previous reference in this node
//-----------------------------------------------------------------
  public ListNode getPrevious(){
    return previous;
  }
  public ListNode getFirst(){
    return top;
  }
//----------------------------------------------------------------- 
//Sets the value of this node.
//----------------------------------------------------------------- 
  public void setValue (Object theNewValue)
  {
    value = theNewValue;
  }
//----------------------------------------------------------------- 
//Sets the next reference in this node.
//----------------------------------------------------------------- 
  public void setNext (ListNode theNewNext)
{
    next = theNewNext;
  }
//-----------------------------------------------------------------
//Sets the previous reference in this node
//-----------------------------------------------------------------
  public void setPrevious(ListNode theNewPrev){
    previous = theNewPrev;
  }
  public void setFirst(ListNode theNewTop){
    top = theNewTop;
  }
}