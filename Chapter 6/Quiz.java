//****************************************************************************************
//
// @author: Hamza Shahzad ||| Quiz.java
// Uses the Question class to make 25 questions
//
//*****************************************************************************************
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Quiz{
  
  private ArrayList<Question> test = new ArrayList<Question>();
  private static Scanner scan = new Scanner(System.in);
  private int numRight;
  private DecimalFormat fmt = new DecimalFormat("0.##");
  private int noQuestions = 25;
  
  public Quiz(String[] questions, String[] answers, int[] complexity){
    
    for(int i = 0; i < noQuestions; i++){
      test.add(new Question(questions[i], answers[i]));
      test.get(i).setComplexity(complexity[i]);
    }
  }
  
  public void add(String q, String a){
    test.add(new Question(q,a));
    noQuestions++;
  }
  public void add(String q, String a, int c){
    add(q, a);
    test.get(noQuestions - 1).setComplexity(c);
  }
  
  public void giveQuiz(){//define a results class after
    for(int i = 0; i < test.size(); i++){
      System.out.println(test.get(i).getQuestion());
      String response = scan.next();
      
      if(test.get(i).answerCorrect(response))
        numRight++;
    }
  }
  
  public void giveQuiz(int min, int max){
    noQuestions = 0;
    for(int i = 0; i < test.size(); i++){
      
      if(test.get(i).getComplexity() >= min && test.get(i).getComplexity() <= max){
        System.out.println(test.get(i).getQuestion());
        String response = scan.next();
      
      if(test.get(i).answerCorrect(response))
        numRight++;
      noQuestions++;
      }
    
    }
  }
  public String results(){
    double answer = ((double)numRight / noQuestions) * 100;
    return fmt.format(answer);
    
  }

}
