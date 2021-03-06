//****************************************************************************************
//
// @Hamza Shahzad ||| Player.java
// A Player contains a hand of cards, can pull a card from the top, and is able to see if
// hand is empty
//
//****************************************************************************************

import java.util.*;

public class Player{
  
  private static Deck d = new Deck();// maybe make this deck in the Game class instead?
  private ArrayList<Card> hand;
  private boolean removed;
  private String name;
  
  public Player(String nombre, int handSize){
    
    hand = d.giveRandomCards(handSize);
    //add a for loop here to assign each of the cards in their hands to them
    for(Card x : hand)
      x.changeOwner(this);
      
    name = nombre;
    removed = false;
  }
  
  //returns the topmost card and removes it from the hand
  public Card flip(){
    if(!this.isHandEmpty())
      return hand.remove(0);
    else
      return null;
    
  }
  
  //returns if the hand is empty
  public boolean isHandEmpty(){
    if(hand.size() == 0)
      return true;
    else return false;
  }
  
  //When two players have equal cards, War is initiated in which 3 Cards are released
  public ArrayList<Card> war(){
    ArrayList<Card> result = null;
    if(hand.size() >= 3){
      
      result = new ArrayList<Card>();
      for(int i = 3; i > 0; i--)//removed = because it would run 4 times
        result.add(flip());
    }
    else{
      result = new ArrayList<Card>();
      
      for(int i = 0; i < hand.size(); i++)
        result.add(flip());
    }
    return result;
  }
  
  //Checks if the player is removed
  public boolean isRemoved(){
    return removed;
  }
  public void changeRemoved(){
    removed = !removed;
  }
  
  public String getName(){
    return name;
  }
  public void setName(String nombre){
    name = nombre;
  }
  
  //prints out all the cards in the persons hand
  public void printHand(){
    for(Card x : hand)
      System.out.print(x + ", ");
    System.out.println();
  }
  
  //allows client to add Cards to the hand
  public void add(ArrayList<Card> pile){
    int originalSize = pile.size();
    
    for(int i = 0; i < originalSize; i++){
      
      if(pile.get(0) != null){
        pile.get(0).changeOwner(this);
        hand.add(pile.remove(0));
      }
    }
  }
  
  public static void resetDeck(){
    d = new Deck();
  }

}

    
    