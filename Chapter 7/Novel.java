//****************************************************************************************
//
// @author: Hamza Shahzad ||| Novel.java
// A type of book with a theme and series(if it is part of one)
//
//****************************************************************************************

public class Novel extends Book{
  
  private String theme, series;
  private int bookNumInSeries = 1;
  
  public Novel(int pageNums, String title, String writer){
    super(pageNums, title, writer);
  }
  
  public void setTheme(String x){
    theme = x;
  }
  public void setSeries(String x){
    series = x;
  }
  public void setBookSeriesNum(int x){
    bookNumInSeries = x;
  }
  
  public String getTheme(){
    return theme;
  }
  public String getSeries(){
    return series;
  }
  public int getBookSeriesNum(){
    return bookNumInSeries;
  }
  
}
  