//****************************************************************************************
//
// @author: Hamza Shahzad ||| QuizTime.java
// Uses the Quiz class to give a torcherous quiz to a student
//
//****************************************************************************************
import java.util.Scanner;

public class QuizTime{
  
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    
    String[] questions = {"What is the capital of Peru?", "What's 9 + 10?",
      "What do many children ride on to go to school?",
      "Who lives in a trash can on 'Sesame Street'?",
      "What farm animal gives us milk to drink?",
      "Johnny had five pumpkins and he made two Jack-O-Lanterns. Out of the five, how many would there be left without a face?",
      "What color are leaves on trees and grass?",
      "If you wanted to dig a hole, which of the following would you be most likely to use?",
      "On a clock, if the big hand is on 12 and the little hand is on 3 what time would it be?",
      "If an average person counted all of their fingers and toes, how many would they have?",
      "What color is a stop sign?",
      "What holds school supplies and children also carry them on their backs?",
      "How many separate books (chapters) are there in the Odyssey?",
      "Which goddess first visits Telemachus at the home of Odysseus in Book 1?",
      "Which metal is heavier, silver or gold?",
      "How many legs do butterflies have?",
      "Which is the country hosting the 2016 Olympic Games?",
      "Which is the country where reggae music originated?",
      "Should we end government subsidization of Protein bars?",
      "Which is the sport where you could be out 'leg before wicket' or 'hit a six'?",
      "Who was the last name of the economist that served under Ronald Reagan?",
      "In cricket what is the maximum number of people that can be on the field when the ball is in play?",
      "Which city is Trent Bridge in?",
      "3 wickets in an over is called a ____ trick",
      "A batsman is ________ when the bails have been dislodged without seeking a run",
      "The BCCI is the board of cricket for which country?"};
    
    String[] answers = {"Lima",
      "19",
      "bus",
      "Oscar",
      "cow",
      "3",
      "green",
      "shovel",
      "3",
      "20",
      "red",
      "backpack",
      "24",
      "Athena",
      "gold",
      "6",
      "Brazil",
      "Jamaica",
      "yes",
      "cricket",
      "Friedman",
      "17",
      "Bridgford",
      "hat",
      "stumped",
      "india"};
    int[] hardness = {4, 1, 1, 7, 2, 1, 2, 3, 3, 2, 1, 3, 9, 8, 7, 8, 6, 5, 10, 8, 9, 10, 10, 6, 7};
    Quiz torcher = new Quiz(questions, answers, hardness);
    
    System.out.println("Please enter the range of how hard you'd like your quiz to be: \nminimum hardness:");
    int min = scan.nextInt();
    System.out.println("maximum hardness:");
    int max = scan.nextInt();
    
    torcher.giveQuiz(min, max);
    
    System.out.println("Results: " + torcher.results());
  }
}