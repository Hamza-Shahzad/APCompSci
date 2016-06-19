//****************************************************************************************
//
// @Hamza Shahzad ||| Deck.java
// Contains an Array of 52 cards
//
//****************************************************************************************
import java.util.*;

public class Deck{

  private ArrayList<Card> list;
  private int amtUsed = 0;
  
  public Deck(){
    list = new ArrayList<Card>();
    
    for(int suits = 1; suits <= 4; suits++){
      for(int face = 2; face <= 13; face++){
        
        Card temp = new Card(suits, face);
        list.add(temp);
      }
    }
  }
  
  //Precondition: amt > 1
  //returns amt random cards
  public ArrayList<Card> giveRandomCards(int amt){

    ArrayList<Card> answer = new ArrayList<Card>();
    while(amt > 0 && this.getUsed() != list.size()){
      
      Card rand = list.get((int) (Math.random() *list.size()));
      
      if(!used(answer, rand) && !rand.isUsed()){
        rand.changeUsed();
        answer.add(rand);
        amtUsed++;
        amt--;
        
      }
    }
    return answer;
  }
  
  //Shuffles all the cards 
  public static void shuffle(ArrayList<Card> deck){
    ArrayList<Card> temp = new ArrayList<Card>();
    int index = 0;
    int sizeDeck = deck.size();
    
    while(index != sizeDeck){
      
      int rand = (int) (Math.random() * deck.size());
      if(!used(temp, deck.get(rand))){
        temp.add(deck.remove(rand));
        deck.add(temp.get(index));
        index++;
      }
    }
  }
  
  public void resetAmtUsed(){
    amtUsed = 0;
  }
    
  //Precondition: c is not null
  //Returns true if the Card is in the other ArrayList
  //Returns false if the Card is not in the other AL
  private static boolean used(ArrayList<Card> listo, Card c){
    boolean result = false;
    
    if(listo.size() != 0){
      
      for(int i = 0; i < listo.size(); i++){
        if(listo.get(i) == c)
          result = true;
      }
    }
    return result;
  }
  
  //Returns how many of the cards have been used up
  private int getUsed(){
    return amtUsed;
  }

  public static void main(String[] args){
    
    Deck d1 = new Deck();
    
    ArrayList<Card> hand = d1.giveRandomCards(5);
    
    for(Card x : hand)
      System.out.println(x);
    
    Deck.shuffle(hand);
    System.out.println();
    
    for(Card x : hand)
      System.out.println(x);
  }
}