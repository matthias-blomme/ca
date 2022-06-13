package ca.adapters.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Renderer {

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
        System.out.println("| Please, provide a greeting.   |");
        System.out.println("|-------------------------------|");
        BufferedReader bufferedReader =  
            new BufferedReader(new InputStreamReader(System.in));
                return bufferedReader.readLine();  
    }

    private void clearScreen() throws IOException {
        final String clear = System.getProperty("os.name")
            .contains("Windows") ? "cls" : "clear";

        Runtime.getRuntime().exec(clear);
    }
}
