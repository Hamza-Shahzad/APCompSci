//*********************************************************************************************
//
// @author: Hamza Shahzad ||| ReadingMaterial.java
// Abstract class that allows creation of specific types of reading materials
//
//*********************************************************************************************

public abstract class ReadingMaterial{
  
  private int noPages;
  private String subject, title, publisher;
  private double price;
  
  public ReadingMaterial(int pageNums, String title){
    setPageNums(noPages);
    setTitle(title);
  }
  
  public void setPageNums(int x){
    noPages = x;
  }
  
  public void setTitle(String x){
    title = x;
  }
  
  public void setSubject(String x){
    subject = x;
  }
  
  public void setPublisher(String x){
    publisher = x;
  }
  public void setPrice(double x){
    price = x;
  }
  
  public int getPageNums(){
    return noPages;
  }
  
  public String getTitle(){
    return title;
  }
  
  public String getSubjet(){
    return subject;
  }
  public String getPublisher(){
    return publisher;
  }
  public double getPrice(){
    return price;
  }
  
  public abstract String toString();
  
}