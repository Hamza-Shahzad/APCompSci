//***************************************************************************************************
//
// @author: Hamza Shahzad ||| Game.java
// Allows the player to run() the War game
// EDITS:
// Changed the players from an array to ArrayList to allow removal of players
//
//***************************************************************************************************

import java.util.*;

public class Game{
  
  private ArrayList<Player> players;
  private ArrayList<Card> pile;
  
  
  //sets up Player List with amt of players
  // and sets up the handSize of the Player
  public Game(int numPlayers, int handSize){
    
    resetPile();
    players = new ArrayList<Player>();
    
    for(int i = 0; i < numPlayers; i++)
      players.add( new Player(null, handSize));
    
  }
  public void setName(int index, String nam){
    players.get(index).setName(nam);
  }
  
  public void run(){
    
    while(players.size() > 1){
      
    //Print out the hand of all the players and takes the top cards into the pile /*
      for(Player x : players){
        pile.add(x.flip());
        
        System.out.print(x.getName() + "'s hand: ");
        x.printHand();
      }
      
    //print out the pile /*
      System.out.print("Pile: ");
      for(Card x : pile)
        System.out.print(x + ", ");
      System.out.println();
    
    //Find the index of the biggest Card */
      int[] coordAndVal = biggestCardInPile(0);
      
      if(coordAndVal[0] != -1)//makes sure there is only one war
        players.get(search(coordAndVal[1])).add(pile);
      
      
         //WAR MODE
         //Use the War method on the players and compare the top card again
         //Make sure that each player has enough cards to put down
         //Check if two or more indices share the same number, enter War Mode
         //Find the winner and give the cards to him/her/*
      
      else{//potential error area
        ArrayList<Player> potentialWinners = thoseWithTheLargest(coordAndVal[1], pile.size() - players.size());//POTENTIAL ERROR AREA
        Player winner = null;
        
        do{
          System.out.println("WAR!");
          winner = war(potentialWinners);
          if(winner != null)
            winner.add(pile);
        }while(winner == null);
      }
    
    
    removeEmpty();
    
    }
    
  }
  
  //returns the amt of players left int the players class
  private int numPlayersLeft(){
    
    int result = 0;
    
    for(Player plat : players){
      if(!plat.isRemoved())
        result++;
    }
    return result;
  }
  
  //takes the topmost card from each player and adds it to the pile
  private void takeAllTopCards(){
    
    for(int i = 0; i < players.size(); i++){
      
      if(!players.get(i).isRemoved())
        pile.set(i, players.get(i).flip());
      
    }
  }
  //adds two cards in war
  private void takeAllTopCards(int uselessNums){
    
    for(int i = 0; i < players.size(); i++){
      pile.add(players.get(i).flip());//THIS MAY NOT WORK WHEN THE PLAYER RUNS OUT OF CARDS
    }
      
    
  }
  //sets the pile array back to 0
  private void resetPile(){
    pile = new ArrayList<Card>();
  }
  
  //finds the index of the biggest card in the pile
  //and the largest value, where [1] is the value
  //returns -1 if there are more than one big cards
  private int[] biggestCardInPile(int startingIndex){
    
    int largestIndex = -1;
    int largestValue = 0;
    int[] result = new int[2];
    
    for(int i = startingIndex; i < pile.size(); i++){
      
      if(pile.get(i) != null && pile.get(i).getIntFace() == largestValue)//POTENTIAL AREA FOR ERROR WITH THE PILE.GET(I) != NULL
        largestIndex = -1;
      
      else if(pile.get(i) != null && pile.get(i).getIntFace() > largestValue){
        largestIndex = i;
        largestValue = pile.get(i).getIntFace();
      }
    }
    result[0] = largestIndex;
    result[1] = largestValue;
    
    return result;
  }
  
  //Precondition: 2 people in pile have equal faceNums
  //Return the Players with the largest face Card
  //in order to enter war mode
  private ArrayList<Player> thoseWithTheLargest(int largestNum){
    ArrayList<Player> list = new ArrayList<Player>();
    int count = 0;
    
    for(int i = 0; i < pile.size(); i++){
      
      if(pile.get(i).getIntFace() == largestNum){
        list.add(players.get(i));//removed the index add, so that they're just added linearly
        count++;
      }
    }
    
    return list;
  }
  
  //specifically made for war
  //UselessCards are the cards in pile that are not to be compared
  //When there are two players, this number is 6
    private ArrayList<Player> thoseWithTheLargest(int largestNum, int sizeOfUselessCards){
    ArrayList<Player> list = new ArrayList<Player>();
    int count = 0;
    
    for(int i = pile.size() -1; i >= sizeOfUselessCards; i--){//made this to start at the end and go down//maybe make i not equal to?
      if(pile.get(i) != null){
        
        if(pile.size() > players.size() && pile.get(i).getIntFace() == largestNum){
          list.add(players.get(i - (pile.size() - players.size())));//THIS MAY FAIL WITH MORE THAN TWO PLAYERS
          count++;
        }
        
        else if(pile.get(i).getIntFace() == largestNum){
          list.add(players.get(i));//removed the index add, so that they're just added linearly
          count++;
        }
      }
    }
    
    return list;
  }
  private void addToPlayer(int indexOfWinner){
    
    players.get(indexOfWinner).add(pile);
  }
  
  //removes the empty card player
  private void removeEmpty(){
    int leng = players.size();
    
    for(int i = 0; i < players.size(); i++){
      
      if(players.get(i).isHandEmpty()){
        System.out.println(players.get(i).getName() + " has been eliminated.");
        players.remove(players.get(i));
      }
    }
  }
  
  //Returns the player who won the war or null if there is another war
  // ArrayList<Player> p is the players who are at war
  private Player war(ArrayList<Player> p){
    Player winner = null;
    int amtCards = pile.size();
    
    for(int i = 0; i < p.size(); i++){//adds 3 cards from each player onto the pile
      ArrayList<Card> pList = p.get(i).war();
      amtCards += 3;
      
      if(locationOfNull(pList) == -1)
        pile.addAll(pList);
      else if (pList != null){//if the player runs out of cards during war, the rest of his cards are added to the pile, and he is removed from the game
        //if it's null, the guy ran out of cards, and he needs to be removed
        for(int n = 0; n < pList.size(); n++){
          if(pList.get(n) != null)
            pile.add(pList.get(n));
        }
        
        removeEmpty();
      }
    }
    takeAllTopCards(amtCards);
    
    for(Player x : players){
      System.out.print(x.getName() + "'s hand: ");
      x.printHand();
    }
    System.out.print("Pile: ");
      for(int count = pile.size() - p.size(); count < pile.size(); count++)
        System.out.print(pile.get(count) + ", ");
      
    int[] coordAndVal = biggestCardInPile(amtCards);
    
    if(coordAndVal[0] != -1){
      ArrayList<Player> winners = thoseWithTheLargest(coordAndVal[1], amtCards);//forgot about the two cards already put down in pile
      
        winner = winners.get(0);//no eason to get the null, it shouldn't even exist here
    }
    else{
      for(int i = 0; i < players.size(); i++){
        
        if(players.get(i).isHandEmpty()){
          removeEmpty();
          winner = war(players);
        }
        else
          winner = null;
      }
    }
    return winner;
  }
  
  private int locationOfNull(ArrayList x){
    int result = -1;
    if(x == null)
      result = 0;
    else{
      for(int i = 0; i < x.size(); i++){
        if(x.get(i) == null)
          result = i;
      }
    }
    return result;
  }
  //Returns the index of the number
  private int search(int num){
    
    for(int i = 0; i < pile.size(); i++){
      if (pile.get(i) != null && pile.get(i).getIntFace() == num)
        return i;
    }
    
    return -1;
  }
  
  
  public static void main(String[] args){
    Game g1 = new Game(2, 26);
    
    g1.run();
  }
}
    
    //This program may be failing due to the fact that the program never checks in the middle of the loop