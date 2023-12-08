package pl.polsl.kg301743.dicethrower.model;

import pl.polsl.kg301743.dicethrower.controller.HandledException;

/**
 * Model class of MVC model responsible for throwing dice and returning results
 * @author Krystian Gagracz
 */
public class Model {
   /**
    * Method creating an instance of Dice class and throwing a dice
    * @param numberOfThrows defines how many times a dice should be thrown
    * @param diceSize defines a dice size
    * @throws HandledException instance
    * @return results of dice throws
    */
    public int[] throwDice(int numberOfThrows, int diceSize) throws HandledException {
        if(diceSize < 1) {
            throw new HandledException("BAD_INPUT", "Rozmiar kosci nie moze byc mniejszy niz 1");
        }
        if(numberOfThrows < 0) {
            throw new HandledException("BAD_INPUT", "Ilosc rzutow nie moze byc mniejsza niz 0");
        }
        Dice dice = new Dice(diceSize);
        return dice.throwDice(numberOfThrows);
    }
}
