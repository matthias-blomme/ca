package ca.adapters.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import ca.core.domain.models.Greeting;

public class Presenter {

    public void showMainScreen() throws IOException {
        clearScreen();
        System.out.println("| Greetings 1.0            |");
        System.out.println("| Choices:                 |");
        System.out.println("|        1. Add            |");
        System.out.println("|        2. All            |");
        System.out.println("|        3. Exit           |");
        System.out.println("|--------------------------|");
    }

    public int askForChoice() throws IOException {
        System.out.println("| Enter choice:            |");
        Scanner s = new Scanner(System.in);
            return s.nextInt();
    }

    public String askForGreeting() throws IOException {
        clearScreen();
        System.out.println("| Please, provide a greeting.   |");
        System.out.println("|-------------------------------|");
        BufferedReader bufferedReader =  
            new BufferedReader(new InputStreamReader(System.in));
                return bufferedReader.readLine();  
    }

    private void clearScreen() {
        final String clear = System.getProperty("os.name")
            .contains("Windows") ? "cls" : "clear";

        try {
            Runtime.getRuntime().exec(clear);
        } catch (IOException e) {
            // Just log
        }
    }

    public void showAllGreetings(List<Greeting> greetings)  {
        clearScreen();
        System.out.println("| All greetings:            |");
        System.out.println("|---------------------------|");
        greetings.forEach(g -> {
            System.out.println(String.format(" - %s", g.message));
        });
        System.out.println("|---------------------------|");
    }

}
