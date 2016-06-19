//*********************************************************************************************
//
// @author: Hamza Shahzad ||| Shelf.java
// Runner class to instantiate different types of Reading Materials
//
//*********************************************************************************************

public class Shelf{
  public static void main(String[] args){
    
    String[] authors = {"Bobby Shmurda", "Kanye West", "Pusha T"};
    
    ReadingMaterial[] list = new ReadingMaterial[5];
    
    list[0] = new Book(420, "Communist Manifesto", "Karl Marx");
    list[1] = new Novel(359, "Native Son", "Richard Wright");
    list[2] = new Textbook(621, "The Art of Rapping", authors,"Huffington Press", "New");
    list[3] = new Magazine(100, "Computer Hardware", 45);
    list[4] = new TechnicalJournal(150, "Focusing on Polymorphism in 2016", "IBM", "March 2016");
    
    for(ReadingMaterial thing : list)
      System.out.println(thing);
  
  }
}