package pl.polsl.kg301743.dicethrower.view;

import java.util.List;

/**
 * Class representing application view
 * @author Krystian Gagracz kg301743@student.pl
 * @version 1.0.0
 */
public class View {
    /**
     * Method displaying all thrown numbers
     * @param input array of thrown numbers (int)
     */
    public void writeAllResults(List<Integer> input) {
        input.forEach(result -> System.out.println("Rzut " + (input.indexOf(result)+1) + ": " + result));
    }
    /**
     * Method displaying message informing about input validation result
     * @param message info about result of validation
     */
    public void wirteValidationMessage(String message) {
        System.out.println(message);
    }
    
    /**
     * Method displaying message in console
     * @param message string to display
     */
    public void wirteMessage(String message) {
        System.out.println(message);
    }
}
