package pl.polsl.kg301743.dicethrower.model;

/**
 * Model class of MVC model responsible for throwing dice and returning results
 * @author Krystian Gagracz
 */
public class Model {
   /**
    * Method creating an instance of Dice class and throwing a dice
    * @param numberOfThrows defines how many times a dice should be thrown
    * @param diceSize defines a dice size
    * @return results of dice throws
    */
    public int[] throwDice(int numberOfThrows, int diceSize) {
        Dice dice = new Dice(diceSize);
        return dice.throwDice(numberOfThrows);
    }
}
