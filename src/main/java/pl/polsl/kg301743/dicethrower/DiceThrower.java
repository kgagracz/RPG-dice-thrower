package pl.polsl.kg301743.dicethrower;

import java.util.List;
import pl.polsl.kg301743.dicethrower.controller.Controller;
import pl.polsl.kg301743.dicethrower.model.Model;
import pl.polsl.kg301743.dicethrower.view.View;

/**
 * RPG DiceThrower is a simple Java program, that will return you an array of 
 * random number of numbers from given range in RPG friendly format (3K10, 2K5) 
 * @author Krystian Gagracz kg301743@student.pl
 * @version 1.0.0
 */
public class DiceThrower {
    /**
     * Main method in program, creating instances of MVC classes and runing their methods
     * Args will be passed as dice configuration. Only first arg will be used.
     * @param args main arguments 
     */
    public static void main(String[] args) {
        //create instances of MVC model classes
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
       
        //checking if input from user is valid
        String throwType = controller.readThrowTypeFromUser(args);
        if(!controller.validateUserInput(throwType)) {
            return;
        }
        
        //throwing dice 
        int numberOfThrows = Integer.parseInt(throwType.split("K")[0]);
        int diceSize = Integer.parseInt(throwType.split("K")[1]);
        List<Integer> results = controller.throwDice(numberOfThrows, diceSize);
        //displaying results
        view.writeAllResults(results);
    }
}
