//****************************************************************************************
//
// @author: Hamza Shahzad ||| Card.java
// A card class which allows the user to make a new card
//
//****************************************************************************************

public class Card implements Comparable<Card> {
  private enum suitVals {Hearts, Clovers, Diamonds, Spades};
  public enum faceVals {Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace};
  private int suitNo, faceNo;
  private String suit;
  private String face;
  private boolean used = false;
  private Player owner;
  
  //default Constructor
  public Card(){}
  
  //Parameter: 1 < faceID <=13
  //Parameter: 0 < suitID <= 4
  public Card(int suitID, int faceID){
    suitNo = suitID - 1;
    faceNo = faceID - 2;
    findSuit(suitID);
    findFace(faceID);
  }
  //User enters a number which gives the value of the Face and suit
  public String makeRandomCard(){
    suitNo = (int) (Math.random() * 4);
    faceNo = (int) (Math.random() * 12);
    findSuit(suitNo);
    findFace(faceNo);
    
    return "Card is " + suit + " " + face;
  }
  
  //Parameter: 0 < id <= 4
  //returns the correct suit
  private String findSuit(int id){
    int i = 0, realId = id - 1;
    
    for (suitVals find : suitVals.values()){
      if (i == realId){
        suit = find.toString().substring(0,1);
        break;
      }
      else
        i++;
    }
      return suit;
  }
  //Parameter: 1 < id <= 13
  //returns the correct Face
  private String findFace(int id){
    int i = 0, realId = id - 2;
    
    for (faceVals find : faceVals.values()){
      
      if (i == realId){
        face = correctFace(find.toString());
        break;
      }
      else
        i++;
    }
     return face;

  }
  public String getSuit(){
    return suit;
  }
  public String getFace(){
    return face;
  }
  //returns the Face as an int value
  public int getIntFace(){
    
    return faceNo + 2;
  }
  
  public String toString(){
    return suit + face;
  }
  
  //Precondition: next != null and has a face value
  public int compareTo(Card next){
    if(this.getIntFace() > next.getIntFace())
      return 1;
    else if (this.getIntFace() < next.getIntFace())
      return -1;
    else return 0;
  }
  //Changes the condition of used
  public void changeUsed(){
    used = !used;
  }
  //accesses used
  public boolean isUsed(){
    return used;
  }
  private String correctFace(String x){
    String result = "";
    
    switch(x){
      case "Two": result = "2"; break;
      case "Three": result = "3"; break;
      case  "Four": result = "4"; break;
      case  "Five": result = "5"; break;
      case  "Six": result = "6"; break;
      case  "Seven": result = "7"; break;
      case  "Eight": result = "8"; break;
      case  "Nine": result = "9"; break;
      case  "Ten": result = "10"; break;
      case  "Jack": result = "J"; break;
      case  "Queen": result = "Q"; break;
      case  "King": result = "K"; break;
      case  "Ace": result = "A"; break;
    }
  return result;
  }
  
  public void changeOwner(Player p){
    owner = p;
  }
  public Player getOwner(){
    return owner;
  }
  
  public static void main(String[] args){
    Card c1 = new Card(4, 10);
    
    System.out.println(c1);
    
    System.out.println(c1.getIntFace());
  }
}