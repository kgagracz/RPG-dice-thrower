package pl.polsl.kg301743.dicethrower.controller;

import java.util.Scanner;
import pl.polsl.kg301743.dicethrower.model.Model;
import pl.polsl.kg301743.dicethrower.view.View;

/**
 * Controller class getting throw type from user by command line or GUI
 * @author Krystian Gagracz kg301743@student.pl
 */
public class Controller {    
   private View view; 
   private Model model;
   
   /**
    * Controller constructor including dependency injection
    * @param view an instance of View class
    * @param model an instance of Model class
    */
    public Controller(View view, Model model) {
        this.model = model;
        this.view = view;
    }
    
    /**
    * Method creating scanner instance and taking input from user  
    */
    private String getThrowTypeByConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj typ rzutu (np. 4K7, 1K10)");
        return scanner.next();
    }
    
    /**
    * Method checking if given string is in throw type format and displays validation fail massage
    * @param input string to check for correctness
    * @return boolean 
    */
    public boolean validateUserInput(String input){ // nie jestem pewien czy to dobre miejsce na ta metodę
        if(!input.toUpperCase().contains("K")) {
            System.out.println("Niepoprawny format typu rzutu (brak litery 'K').");
            return false;
        }
        if(input.charAt(0) != (int)input.charAt(0)) {
            System.out.println("Niepoprawny format typu rzutu (pierwszy znak nie jest cyfra).");
            return false;
        }
        return true;
    }
    
    /**
    * Method controlling data input - if args provided function will return them, otherwise it will run {@link Controller#getThrowTypeByConsole() getThrowTypeByConsole}
    * @param args arguments list from main class method
    * @return string representing throw type provided by user 
    */
    public String getThrowTypeFromUser(String[] args) {
        String throwType = "";
        if(args.length == 0) {
            throwType = getThrowTypeByConsole();
        } else {
            throwType = args[0];
        }
        return throwType.toUpperCase();
    }
    
    /**
     * Method responsible for calling throwDice method of model instance with given params
     * @param numberOfThrows defines how many times an dice should be thrown
     * @param diceSize defines size of a dice beeing thrown
     * @return result of {@link Model#throwDice(int, int) throwDice} method
     */
    public int[] throwDice(int numberOfThrows, int diceSize) {
        return this.model.throwDice(numberOfThrows, diceSize);
    }
    
    /**
     * Method calling {@link View#writeAllResults(int[]) writeAllResults} method
     * @param results results of {@link Controller#throwDice(int, int) throwDice} method
     */
    public void showResults(int[] results) {
        view.writeAllResults(results);
    }
}