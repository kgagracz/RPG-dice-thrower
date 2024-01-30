package model;

import java.util.List;
import model.HandledException.ErrorCode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Class testing Model class
 *
 * @author Krystian Gagracz
 */
public class ModelTest {

    private Model model;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 30})
    //testing throwDice method with proper input parameters
    public void testThrowDiceSizeProperData(int diceSize) {
        int throwTimes = 5;
        int expSize = throwTimes;
        model = new Model();
        try {
            List<Integer> result = model.throwDice(throwTimes, diceSize);
            assertEquals(expSize, result.size(), "Thrown more times than provided by user");
            result.forEach(singleResult -> assertTrue(singleResult <= diceSize));
        } catch (HandledException e) {
            fail("Exception occured");
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -2, -30})
    //testing throwDice method with inproper input parameters
    public void testThrowDiceSizeInproperData(int diceSize) {
        String expectedMessage = "Rozmiar kosci nie moze byc mniejszy niz 1";
        ErrorCode expectedCode = HandledException.ErrorCode.BAD_INPUT;

        HandledException exception = assertThrows(HandledException.class, () -> {
            model = new Model();
            model.throwDice(10, diceSize);
        });
        assertEquals(expectedMessage, exception.getMessage(), "Message diffrent than expected");
        assertEquals(expectedCode, exception.getCode(), "Code diffrent than expected");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    //testing throwDice method with inproper input parameters
    public void testThrowDiceThrowTimes(int throwTimes) {
        model = new Model();
        String expectedMessage = "Ilosc rzutow nie moze byc mniejsza niz 0";
        ErrorCode expectedCode = HandledException.ErrorCode.BAD_INPUT;

        HandledException exception = assertThrows(HandledException.class, () -> {
            model.throwDice(throwTimes, 10);
        });
        assertEquals(expectedMessage, exception.getMessage(), "Message diffrent than expected");
        assertEquals(expectedCode, exception.getCode(), "Code diffrent than expected");
    }

}
