//****************************************************************************************
//
// @author: Hamza Shahzad ||| Textbook.java
// Class that inherits from the book class to check if the book has a bookcover and has
// a quality condition. If the person using the book degrades it to poor or bad,
// the user will have to pay a penalty on the book
//
//****************************************************************************************

public class Textbook extends Book{
  
  private enum Condition {NEW, GOOD, FAIR, POOR, BAD};
  private Condition howIsIt;
  public String[] authors;
  private boolean bookCover;
  
  
  public Textbook(int pageNums, String title, String[] writers, String publishing, String condition){
    super(pageNums, title);
    stringToEnum(condition);
    setAuthors(writers);
    this.setPublisher(publishing);
  }
  
  private void stringToEnum(String x){
    switch(x){
      case "New": howIsIt = Condition.NEW; break;
      case "Good": howIsIt = Condition.GOOD; break;
      case "Fair": howIsIt = Condition.FAIR; break;
      case "Poor": howIsIt = Condition.POOR; break;
      case "Bad": howIsIt = Condition.BAD; break;
      
    }
  }
  
  public void setCondition(String x){
    stringToEnum(x);
  }
  public void changeCover(){
    bookCover = !bookCover;
  }
  public void setAuthors(String[] writers){
    authors = writers;
  }
  
  public String getCondition(){
    return howIsIt.toString();
  }
  public boolean isThereABookcover(){
    return bookCover;
  }
  public String[] getAuthors(){
    return authors;
  }
  
  public boolean isConditionPoor(){
    boolean result = false;
    
    if(howIsIt == Condition.POOR || howIsIt == Condition.BAD)
      result = true;
    
    return result;
  }
  public double studentMustPay(){
    double cost = 0;
    
    if(isConditionPoor()){
      if(howIsIt == Condition.POOR)
        cost = 0.5 * this.getPrice();
      else
        cost = this.getPrice();
    }
    return cost;
  }
  
  public String toString(){
    return this.getTitle() + " published by " + this.getPublisher();
  }
  
}
    