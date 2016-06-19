public class CheckerBoard{
  private Checkboardsquare[][] board = new Checkboardsquare[8][8];
  public enum directions {UR, UL, DR, DL, ERROR};
  public static int noBlack = 0;
  public static int noRed = 0;
  private Checkboardsquare.State black = Checkboardsquare.State.BLACK;
  private Checkboardsquare.State red = Checkboardsquare.State.RED;
  private Checkboardsquare.State empty = Checkboardsquare.State.EMPTY;
  
  
  public CheckerBoard(){
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        board[i][j] = new Checkboardsquare();
      }
    }
    cleanBoard();
  }
  public Checkboardsquare searchForState(Checkboardsquare.State state){
    
    for(int col  = (int) (Math.random() * 8); col < 8; col++){
      for(int row = (int) (Math.random() * 8); row < 8; row++){
        if(board[col][row].getState() == state)
          return board[col][row];
      }
    }
    return board[0][0];
  }
          
  public void SetSq(int col, int row, Checkboardsquare.State set){
    board[col][row].setState(set);
  }
  
  public Checkboardsquare.State getState(int col, int row){
    return board[col][row].getState();
  }
  
  public void cleanBoard(){
     
    resetBlack();
    resetRed();
    noBlack = 12;
    noRed = 12;
  }
  private void resetBlack(){
    
    for(int col = 0; col < 3; col++){
      
      if (col % 2 == 1){
        
        for(int row = 1; row < 8; row += 2)
          SetSq(col, row, Checkboardsquare.State.BLACK);
      }
      else{ //row is even
        for(int row = 0; row < 8; row += 2)
          SetSq(col, row, Checkboardsquare.State.BLACK);
      }
    }
  }
  private void resetRed(){
    
    for(int col = 7; col > 4; col--){
      
      if (col % 2 == 1){ //SWITCH THE ROWS AND COLUMNS
        for (int row = 1; row < 8; row += 2)
          SetSq(col, row, Checkboardsquare.State.RED);
      }
      else{ //row is even
        for(int row = 0; row < 8; row += 2)
          SetSq(col, row, Checkboardsquare.State.RED);
      }
    }
  }
  public void move(int col, int row, String howTheyWant2Move){

    if(isLegal(col, row, howTheyWant2Move)){
     Checkboardsquare.State piece = board[col][row].getState();
      board[col][row].setState(empty);
      
      switch (toDirections(howTheyWant2Move)) {
        case UL:  col--; row--; break;
        case UR:  col--; row++; break;
        case DR:  col++; row++; break;
        case DL:  col++; row--; break;
      }
      board[col][row].setState(piece);
      
    }
    else if(capturable(col, row, toDirections(howTheyWant2Move)));
    else if (col > 7 || row > 7 || col < 0 || row < 0)
      throw new IllegalMoveException("The Numbers you entered are illegal");
    else
      throw new IllegalMoveException("The Direction where you want to move is illegal");
      
  }
  private boolean isLegal(int col, int row, String where){
    boolean legality = false;
    directions theirMove = toDirections(where);
    //finds where the user wants to move
    switch (theirMove) {
      case UL:  col--; row--; break;
      case UR:  col--; row++; break;
      case DR:  col++; row++; break;
      case DL:  col++; row--; break;
    }
    try{
    if (board[col][row].getState() == empty)
      legality = true;
    }catch (ArrayIndexOutOfBoundsException except){
      throw new IllegalMoveException();
    }
    return legality;
  }

  //@PreCondition: Legality is False, and this comes after isLegal method
  private boolean capturable(int col, int row, directions where){
    boolean canCapture = false;
    Checkboardsquare.State originalState = board[col][row].getState();
    
    int originalColumn = col;
    int originalRow = row;
    switch (where) {
      case UL:  col--; row--; break;
      case UR:  col--; row++; break;
      case DR:  col++; row++; break;
      case DL:  col++; row--; break;
    }
    int enemyColumn = col;
    int enemyRow = row;
    if(board[col][row].getState() != empty && board[col][row].getState() != originalState){//if it's equal to black, then the current piece is red
      Checkboardsquare.State enemyState = board[col][row].getState();
      switch (where) {
        case UL:  col--; row--; break;
        case UR:  col--; row++; break;
        case DR:  col++; row++; break;
        case DL:  col++; row--; break;
      }
      canCapture = true;
      //decrease the number
      if (originalState == black)
        noRed--;
      else if (originalState == red)
        noBlack--;
      try{
      board[originalColumn][originalRow].setState(empty);
      board[enemyColumn][enemyRow].setState(empty);
      board[col][row].setState(originalState);
      }catch(ArrayIndexOutOfBoundsException helpMe){
        throw new IllegalMoveException();
      }
    }
  
  return canCapture;
}
  public void computer(){
    int col = (int) (Math.random() * 8);
    int row = (int) (Math.random() * 8);
    if (noBlack == 0)
      return;
    
    else if(board[col][row].getState() == black){
      int lOrR = (int) (Math.random() * 2);
      try{
      if(lOrR == 0)
        move(col, row, "DL");
      else
        move(col, row, "DR");
      }catch(IllegalMoveException except){
        computer();
      }
        
      //NEED TO CATCH AN EXCEPTION THROWN WHEN THE MOVE IS ILLEGAL
    }
    else
      computer();
  }

  private directions toDirections(String convert){
    directions location;
    //makes 'where' into a direction type of the enum
    switch (convert) {
      case "UR":  location = directions.UR; break;
      case "UL":  location = directions.UL; break;
      case "DR":  location = directions.DR; break;
      case "DL":  location = directions.DL; break;
      default: location = directions.ERROR; break;
    }
    return location;
  }

  public Checkboardsquare.State winner(){
    if (noBlack == 0)
      return red;
    if (noRed == 0)
      return black;
    else return empty;
  }
    
  public String toString(){
    System.out.println("  0 1 2 3 4 5 6 7");
    System.out.println(" +-+-+-+-+-+-+-+-");
    String result = "";
    for (int col = 0; col < 8; col++){
      result += col + "|";
      for(int row = 0; row < 8; row++)
        result += board[col][row].toString();
      result += "\n";
    }
    result += " +-+-+-+-+-+-+-+-";
    return result;
  }
}