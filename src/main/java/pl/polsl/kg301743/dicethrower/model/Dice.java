package pl.polsl.kg301743.dicethrower.model;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Class representing a dice with given size (in this case it is a MVC Model)
 * @author Krystian Gagracz kg301743@student.pl
 */
public class Dice {
    /**Defines dice size*/
    final private int maxNumber;
    
    /**Contructor of Dice class
     *@param diceSize representing shape of dice (max number possible to throw)
     */
    public Dice(int diceSize) {
        maxNumber = diceSize;
    }
    
    /**
     * Method returns random number from 1 to dice size
     * @param throwTimes number of throws
     * @return array of thrown numbers
     */
    public int[] throwDice(int throwTimes) {
        int[] result = new int[throwTimes];
        for (int i = 0; i < throwTimes; i++) {
            int min = 1;
            result[i] = ThreadLocalRandom.current().nextInt(min, maxNumber + 1);
        }
        return result;
    }
}
