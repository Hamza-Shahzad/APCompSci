//****************************************************************************************
//
// @author: Hamza Shahzad ||| BlurbDriver.java
//  In an alien language, blurbs are how they speak
//
//****************************************************************************************

import java.util.Scanner;
public class BlurbDriver{
      
  public static void main(String[] args){
    
    Scanner scan = new Scanner(System.in);
    Blurb saying = new Blurb();
    
    for(int i = 0; i < 3; i++){
      System.out.println("Alien 1: " + saying.generateWord());
      System.out.println("Alien 2: " + saying.generateWord());
    }
    
    System.out.println("Enter a potential blurb:");
    
    String answer = scan.next();
    
    if(saying.isBlurb(answer))
      System.out.println("That is a blurb.");
    else
      System.out.println("That is not a blurb.");
    
  }
}
    