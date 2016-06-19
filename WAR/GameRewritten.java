//*********************************************************************************************
//
// @author: Hamza Shahzad ||| GameRewritten.java
// Because I'm bad at making classes, I will rewrite Game top down
//
//*********************************************************************************************

import java.util.*;

public class GameRewritten{
  
  private ArrayList<Player> players;
  private ArrayList<Card> pile;
  
  public GameRewritten(ArrayList<String> names, int numPlayers){
    Player.resetDeck();
    
    pile = new ArrayList<Card>();
    players = new ArrayList<Player>();
    
    for(int i = 0; i < numPlayers; i++)
      players.add( new Player(names.get(i), 52 / numPlayers));
      
  }
  
  public void run(){
    
    while(players.size() > 1){
      
      for(Player x : players){//Takes a top card and prints hand
        pile.add(x.flip());
        
        System.out.print(x.getName() + "'s hand: ");
        x.printHand();
      }
      
      //prints pile
      System.out.print("Trick: ");
      for(Card x : pile)
        System.out.print(x + ", ");
      System.out.println();
      
      Player largest = biggestCardInPile(0);//instead of getting the coordinates, I can return the actual player
      
      if(largest != null){
        largest.add(pile);
        removeEmpty();
      }
      
      
      else{
        int largeNum = searchLargest(0);
        ArrayList<Player> biggestPlayers = thoseWithTheLargest(0, largeNum);
        war(biggestPlayers);
      }
    }
    
    System.out.println(players.get(0).getName() + " has won!!");
  }
  
  private void war(ArrayList<Player> enWar){//add in an arraylist that  only deals with the correct players
    if(enWar.size() != 1){
      System.out.println("WAR!!");
      
      
      for(int i = 0; i < enWar.size(); i++){
        
        for(int j = 0; j < 3; j++){
          Card wantToPutIn = enWar.get(i).flip();
          
          if(wantToPutIn != null)
            pile.add(wantToPutIn);
          else{
            removeEmpty();
            break;
          }
          removeEmpty();
          if(i > enWar.size())//not sure this makes sense?
            break;
        }
      }
      for(int i = 0; i < enWar.size(); i++){
        
        if(i < players.size()){
          
          Card wantToPutIn = players.get(i).flip();
          if(wantToPutIn != null)
            pile.add(wantToPutIn);
        }
        
      }
      
      for(Player x : players){//Takes a top card and prints hand
        System.out.print(x.getName() + "'s hand: ");
        x.printHand();
      }
     
      if(players.size() > 1){
        
      System.out.print("Trick: ");
      for(int i = pile.size() - enWar.size(); i < pile.size(); i++)
        System.out.print(pile.get(i) + ", ");
      System.out.println();
    
      }
      
    Player largest = biggestCardInPile(pile.size() - enWar.size());
    
    if(largest != null){
      largest.add(pile);//POTENTIAL LOGIC ERROR HERE
      removeEmpty();
    }
    else{
      int largeNum = searchLargest(pile.size() - enWar.size());
      
      ArrayList<Player> large = thoseWithTheLargest(pile.size() - enWar.size(), largeNum);
      war(large);
      
    }
    }
  }
  
  //finds the biggest card in the pile, and returns
  //the player that "owns" it
  //if two players own equally large cards, it will 
  //return null
  
  private Player biggestCardInPile(int startingIndex){
    
    Player result = null;
    int largestValue = Integer.MIN_VALUE;
    
    for(int i = startingIndex; i < pile.size(); i++){
      
      
      if(pile.get(i) != null && pile.get(i).getIntFace() == largestValue)
        result = null;
      
      else if(pile.get(i) != null && pile.get(i).getIntFace() > largestValue){
        result = pile.get(i).getOwner();
        largestValue = pile.get(i).getIntFace();
      }
    }
    
    return result;
  }
  
  private void removeEmpty(){
    int leng = players.size();
    
    for(int i = 0; i < players.size(); i++){
      
      if(players.get(i).isHandEmpty()){
        System.out.println(players.get(i).getName() + " has been eliminated.");
        players.remove(players.get(i));
      }
    }
  }
  
  private int findPlayer(int startingPoint, int largestNum){
    int count = 0;//count is the index of the player in ArrayList players
    
    for(int i = startingPoint; i < pile.size(); i++){
      
      if(pile.get(i).getIntFace() != largestNum)
        count++;
    }
    
    return count;
  }
  
  private ArrayList<Player> thoseWithTheLargest(int startingIndex, int largestNum){
    ArrayList<Player> list = new ArrayList<Player>();
    
    for(int i = startingIndex; i < pile.size(); i++){
      
      if(pile.get(i).getIntFace() == largestNum){
        list.add(pile.get(i).getOwner());//removed the index add, so that they're just added linearly
      }
    }
    
    return list;
  }
  
  private int searchLargest(int startingIndex){
    int result = -1;
    
    for(int i = startingIndex; i < pile.size(); i++){
      
      if(pile.get(i).getIntFace() > result)
        result = pile.get(i).getIntFace();
    }
    
    return result;
  }
 
}