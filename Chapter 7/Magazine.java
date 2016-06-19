//****************************************************************************************
//
// @author: Hamza Shahzad ||| Magazine.java
// A class that inherits from ReadingMaterial and has an issue number
//
//****************************************************************************************

public class Magazine extends ReadingMaterial{
  
  private int issueNum;
  
  public Magazine(int pageNums, String title, int issue){
    super(pageNums, title);
    setIssue(issue);
  }
  
  public void setIssue(int x){
    issueNum = x;
  }
  
  public int getIssue(){
    return issueNum;
  }
  
  public String toString(){
    return "Issue " + issueNum + " of " + this.getTitle();
  }
  
}