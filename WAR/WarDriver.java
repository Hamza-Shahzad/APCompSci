import java.util.*;

public class WarDriver{
  
  private static Scanner scan = new Scanner(System.in);
  private static ArrayList<String> result = new ArrayList<String>();
  
  private static void nameThem(int numHumans){
    
    for(int i = 0; i < numHumans; i++){
      System.out.println("Enter a human player's name:");
      result.add(scan.next());
    }
  }
  private static void nameComputers(int numPlayers, int numComp){
    int count = 1;
    
    for(int i = numPlayers - numComp ; i < numPlayers; i++){//should i not have -1?
      result.add(("Computer_" + count));
      count++;
    }
  }
  private static void resetResult(){
    result = new ArrayList<String>();
  }
  
  public static void main(String[] args){
    int numPlayers = 0, humans = 0;
    String answer = "";
    
    System.out.println("Welcome to War!");
    
    do{
      GameRewritten g;
      
      do{
        System.out.println("How many players will battle (2-4):");
        numPlayers = scan.nextInt();
        
        if(numPlayers > 4 || numPlayers < 2)
          System.err.println("ERROR, ENTER A NUMBER FROM 2-4");
        
      }while(numPlayers > 4 || numPlayers < 2);
      
      do{
      System.out.println("How many players are human (0-4):");
      humans = scan.nextInt();
      
      if(humans > numPlayers || humans < 0)
        System.err.println("ERROR, ENTER A NUMBER WITHIN THE RANGE OF THE NUMBER OF PLAYERS");
      
      }while(humans > numPlayers || humans < 0);
      
      nameThem(humans);
      nameComputers(numPlayers, numPlayers - humans);
      g = new GameRewritten(result, numPlayers);
      
      g.run();
      
      System.out.println();
      System.out.println("Play again?(yes/no)");
      answer = scan.next();
      
      resetResult();
    }while(answer.equalsIgnoreCase("yes"));
  }
}