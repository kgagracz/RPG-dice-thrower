package model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *  Class testing Dice class
 * @author Krystian Gagracz
 */
public class DiceTest {
    private Dice dice;

    //Test of throwDice method, of class Dice with proper args. Results size should be equal to number of throws
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
    public void testThrowTimesProperData(int throwTimes) {
        int diceSize = 6;
        dice = new Dice(diceSize);
        List<Integer> result = dice.throwDice(throwTimes);
        assertEquals(throwTimes, result.size(), "Dice size must be equal to results size");
    }
    
    //Test of throwDice method, of class Dice with inproper args. Method should return an empty list
    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    public void testThrowTimesInproperData(int throwTimes) {
        int diceSize = 6;
        dice = new Dice(diceSize);
        List<Integer> result = dice.throwDice(throwTimes);
        assertEquals(0, result.size(), "throwDice method should return empty list when diceSize < 0");
    }
    
    //Test of throwDice method, of class Dice with proper args, all results 
    //should be smaller than dice size.
    @ParameterizedTest 
    @ValueSource(ints = {1, 2, 30})
    public void testThrowDiceResultsProperData(int diceSize) {
        int throwTimes = 3;
        dice = new Dice(diceSize);
        List<Integer> results = dice.throwDice(throwTimes);
        //Every throw result must be smaller than a dice size
        results.forEach(result -> assertFalse(result > diceSize, "Result can't be greater than dice size"));
    }
}
