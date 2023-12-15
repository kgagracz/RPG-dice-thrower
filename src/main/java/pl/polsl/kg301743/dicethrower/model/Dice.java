package pl.polsl.kg301743.dicethrower.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class representing a dice with given size (in this case it is a MVC Model)
 *
 * @author Krystian Gagracz kg301743@student.pl
 * @version 1.1.0
 */
public class Dice {

    /**
     * Defines dice size
     */
    final private int maxNumber;

    /**
     * Contructor of Dice class
     *
     * @param diceSize representing shape of dice (max number possible to throw)
     */
    public Dice(int diceSize) {
        maxNumber = diceSize;
    }

    /**
     * Method returns random number from 1 to dice size
     * @param throwTimes number of throws
     * @return List of thrown numbers
     */
    public List<Integer> throwDice(int throwTimes) {
        return throwTimes < 0 ? List.of() :
                IntStream.range(0, throwTimes)
                        .mapToObj(i -> ThreadLocalRandom.current().nextInt(1, maxNumber + 1))
                        .collect(Collectors.toList());
    }
}
