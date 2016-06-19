public class Checkboardsquare{
  public enum State {EMPTY, BLACK, RED};

  
  private State state = State.EMPTY;
  
  public void setState(State s){
    state = s;

  }
  public State getState(){
    return state;
  }
  public String toString(){
    String result = " |";
    
    if(getState() == State.BLACK)
      result = "B|";
    else if (getState() == State.RED)
      result = "R|";
    return result;
  }
  public static void main(String[] args){
    Checkboardsquare ch = new Checkboardsquare();
    
    ch.setState(State.BLACK);
    System.out.println(ch);
  }
}
  