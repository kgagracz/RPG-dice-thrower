package pl.polsl.kg301743.dicethrower.view;

/**
 * Class representing application view
 * @author Krystian Gagracz kg301743@student.pl 
 */
public class View {
    /**
     * Method displaying all thrown numbers
     * @param input array of thrown numbers (int)
     */
    public void writeAllResults(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Rzut " + (i+1) + ": " + input[i]);
        }
    }
    /**
     * Method displaying message informing about input validation result
     * @param message info about result of validation
     */
    public void wirteValidationMessage(String message) {
        System.out.println(message);
    }
}
