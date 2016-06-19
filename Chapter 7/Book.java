//*********************************************************************************************
//
// @author: Hamza Shahzad ||| Book.java
// class that allows the user to create a book
//
//*********************************************************************************************

public class Book extends ReadingMaterial{
  
  private boolean hardcover;
  private String author;
  private int chapters;
  
  public Book(int pageNums, String title, String writer){
    super(pageNums, title);
    setAuthor(writer);
  }
  public Book(int pageNums, String title){
    super(pageNums, title);
  }
  
  public void hardcover(){
    hardcover = !hardcover;
  }
  public void setAuthor(String x){
    author = x;
  }
  public void setChapters(int x){
    chapters = x;
  }
  
  public boolean isHardcovered(){
    return hardcover;
  }
  public String getAuthor(){
    return author;
  }
  public int getChapters(){
    return chapters;
  }
  
  public String toString(){
    return this.getTitle() + " by " + this.getAuthor();
  }
  
}