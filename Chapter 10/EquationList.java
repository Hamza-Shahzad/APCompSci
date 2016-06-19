

public class EquationList{
  
  private String longEquation;
  private boolean[] madeIntoEq;
  private SmallEq[] actualEqs;
  private SmallEq mostRecent;
  
  public EquationList(String x){
    
    longEquation = x;
    madeIntoEq = new boolean[x.length()];
    actualEqs = new SmallEq[x.length()];
    
  }
  
  public boolean getBoolean(int index){
    return madeIntoEq[index];
  }
  public SmallEq getEquation(int index){
    return actualEqs[index];
  }
  
  public void setEquation(SmallEq thing, int start, int end){
    mostRecent = thing;
    
    for(int i = start; i < end; i++){
      madeIntoEq[i] = true;
      actualEqs[i] = thing;
      
    }
    /*
    for(int i = 0; i < actualEqs.length; i++){
      if(madeIntoEq[i])
        actualEqs[i] = thing;
    } Causes other parts of the program to malfunction 
    
    if the former equations are involved in this equation, then fill those with the mostRecent answer*/
  }
  

  public SmallEq returnRecent(){
    return mostRecent;
  }
  
}