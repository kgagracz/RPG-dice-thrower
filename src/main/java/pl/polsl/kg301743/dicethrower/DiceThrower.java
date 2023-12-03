package pl.polsl.kg301743.dicethrower;

import pl.polsl.kg301743.dicethrower.controller.Controller;
import pl.polsl.kg301743.dicethrower.model.Dice;

//[x] podział na pakiety klas wg szablonu  model-widok-kontroler (MVC),
//[x] odbiór parametrów wywołania programu do aplikacji z linii poleceń,
//[x] w przypadku braku parametrów w linii wywołania, aplikacja powinna zapewnić interakcję z użytkownikiem w celu pobrania danych z użyciem strumieni systemowych bądź GUI,
//pełne, planowane do zaimplementowania API modelu,
//[x] wyświetlanie jakiegokolwiek sensownego wyniku,
//[x] oraz inne elementy wskazane przez osobę prowadzącą zajęcia,
//poprawne przygotowanie całości prototypu w postaci zarchiwizowanego katalogu projektu dla środowiska NetBeans IDE 18.

/**
 *
 * @author Krystian Gagracz kg301743@student.pl
 * @version 1.0.0
 */
public class DiceThrower {
    
    public static void main(String[] args) {
        Controller controller = new Controller();
       
        String throwType = controller.getThrowTypeFromUser(args);
        if(!controller.validateUserInput(throwType)) {
            return;
        }
        
        int numberOfThrows = Integer.parseInt(throwType.split("K")[0]);
        int diceSize = Integer.parseInt(throwType.split("K")[1]);
        Dice dice = new Dice(diceSize);
        int[] results = dice.throwDice(numberOfThrows);
        for (int i = 0; i < results.length; i++) {
            System.out.println("Wyrzucono: " + results[i]);
        }
    }
}
