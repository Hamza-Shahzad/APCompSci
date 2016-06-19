import java.util.Scanner;
public class Checkers{
  public static void main(String[] args){
    
    Scanner scan = new Scanner(System.in);
    CheckerBoard cb = new CheckerBoard();
    System.out.println("*****************************************************\nPlease enter the coordinates of the piece you want " +
                       "to move.\nEnter the following when asked where to move:\n" +
                       "UR- Up Right\nUL- Up Left\nDR- Down Right\nDL- Down Left\n*****************************************************");
    String answer;
    System.out.println(cb);
    do{
      System.out.println("Enter the column of the box you'd like to move");
      int column = scan.nextInt();
      System.out.println("Enter the row of the box you'd like to move");
      int row = scan.nextInt();
      System.out.println("Enter the direction where you'd like to move");
      String movement = scan.next();
      scan.nextLine();
      
      cb.move(column, row, movement);
      System.out.println(cb);
      
      System.out.println("\nThe Computer is thinking...");
      cb.computer();
      System.out.println(cb);
      
    }while (cb.winner() == Checkboardsquare.State.EMPTY);
    if (cb.winner() == Checkboardsquare.State.RED)
      System.out.println("Congrats! You've won against the computer!");
    else 
      System.out.println("The Computer has won!");
  }
}