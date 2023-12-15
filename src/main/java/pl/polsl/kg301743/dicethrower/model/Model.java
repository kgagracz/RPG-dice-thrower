package pl.polsl.kg301743.dicethrower.model;

import java.util.List;

/**
 * Model class of MVC model responsible for throwing dice and returning results
 *
 * @author Krystian Gagracz 
 * @version 1.0.0
 */
public class Model {

    /**
     * Method creating an instance of Dice class and throwing a dice
     *
     * @param numberOfThrows defines how many times a dice should be thrown
     * @param diceSize defines a dice size
     * @throws HandledException instance whend inputs are incorrece (diceSize < 1 and numberOfThrows < 0 )
     * @return results of dice throws
     */
    public List<Integer> throwDice(int numberOfThrows, int diceSize) throws HandledException {
        if (diceSize < 1) {
            throw new HandledException(HandledException.ErrorCode.BAD_INPUT, "Rozmiar kosci nie moze byc mniejszy niz 1");
        }
        if (numberOfThrows < 0) {
            throw new HandledException(HandledException.ErrorCode.BAD_INPUT, "Ilosc rzutow nie moze byc mniejsza niz 0");
        }

        Dice dice = new Dice(diceSize);
        List<Integer> resultsList = dice.throwDice(numberOfThrows);

        return resultsList;
    }
}
