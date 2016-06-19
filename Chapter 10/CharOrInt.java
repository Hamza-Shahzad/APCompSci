//*****************************************************************************************
//
// @author: Hamza Shahzad ||| CharOrInt.java
// Class that stores either a Character or an Integer value
//
//*****************************************************************************************

public class CharOrInt{
  
  private boolean isCharacter = false;
  private boolean used = false;
  private Character charValue;
  private Integer intValue;
  
  public CharOrInt(Character x){
    charValue = x;
    isCharacter = true;
  }
  public CharOrInt(Integer x){
    intValue = x;
  }
  
  public boolean isChar(){
    return isCharacter;
  }
  
  //Assume that the user will
  //check if the object is a char
  //or int before using the methods
  public Integer getInt(){
    return intValue;
  }
  public Character getChar(){
    return charValue;
  }
  
  public String toString() {
    String result = "";
    if(isChar())
      result += getChar();
    else
      result += getInt();
    return result;
  }
  
  public void changeUsed(){
    used = !used;
  }
  public boolean getUsed(){
    return used;
  }
}