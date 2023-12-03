package pl.polsl.kg301743.dicethrower.controller;

import java.util.Scanner;

/**
 * Controller class getting throw type from user by command line or GUI
 * @author SuperStudent-PL
 */
public class Controller {    
    private String getThrowTypeByConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj typ rzutu (np. 4K7, 1K10)");
        return scanner.next();
    }
    
    public boolean validateUserInput(String input){ // nie jestem pewien czy to dobre miejsce na ta metodę
        if(!input.contains("K")) {
            System.out.println("Niepoprawny format typu rzutu (brak litery 'K').");
            return false;
        }
        if(input.charAt(0) != (int)input.charAt(0)) {
            System.out.println("Niepoprawny format typu rzutu (pierwszy znak nie jest cyfra).");
            return false;
        }
        return true;
    }
    
    public String getThrowTypeFromUser(String[] args) {
        String throwType = "";
        if(args.length == 0) {
            throwType = getThrowTypeByConsole();
        } else {
            throwType = args[0];
        }
        return throwType;
    }
}
