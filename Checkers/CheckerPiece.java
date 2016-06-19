public class CheckerPiece{
  
  private boolean isRed;
  public static enum movements {UL, UR, DL, DR};
  
  public CheckerPiece(String a){
    if (a.equals("Red"))
      isRed = true;
    else
      isRed = false;
  }
  
  public void move(movements location){
    
  }
}