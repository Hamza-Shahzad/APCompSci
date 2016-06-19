//****************************************************************************************
//
// @author: Hamza Shahzad ||| TechnicalJournal.java
// A class that inherits from ReadingMaterial and has a reasercher institute behind it
//
//****************************************************************************************

public class TechnicalJournal extends ReadingMaterial{
  
  private String researchInstitute, monthYear;
  
  public TechnicalJournal(int pageNums, String title, String researchers, String release){
    super(pageNums, title);
    setResearch(researchers);
    setRelease(release);
  }
  
  public void setResearch(String x){
    researchInstitute = x;
  }
  public void setRelease(String x){
    monthYear = x;
  }
  
  public String getResearch(){
    return researchInstitute;
  }
  public String getRelease(){
    return monthYear;
  }
  
  public String toString(){
    return this.getResearch() + " " + this.getRelease() + " : " + this.getTitle();
  }
}