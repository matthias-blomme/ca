package ca.adapters.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

import ca.core.domain.data.Greetings;
import ca.core.domain.models.Greeting;

public class GreetingsFileBased implements Greetings {

    private static final String DEFAULT_PATH_TO_FILE = "./data/products.txt";

    public GreetingsFileBased() {
        ensureFileAndDirExists();
    }
    
    @Override
    public List<Greeting> all() {
        try (Scanner in = new Scanner(new FileInputStream(DEFAULT_PATH_TO_FILE))) {
            List<Greeting> greetings = new ArrayList<>();
            while (in.hasNextLine()) {
                Greeting greeting = parseGreeting(in.nextLine());
                greetings.add(greeting);
            }
            return greetings;
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Failed to perform the action.");
        }
    }

    @Override
    public void add(Greeting greeting) {
        String id = UUID.randomUUID().toString();
        try (PrintStream out = new PrintStream(new FileOutputStream(DEFAULT_PATH_TO_FILE, true))) {
            greeting = new Greeting(id, greeting.message);
            out.printf(Locale.US, "%s;%s\n", id, greeting.message);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Failed to perform the action.");
        }
    }

    private void ensureFileAndDirExists() {
        File file = new File(DEFAULT_PATH_TO_FILE);
        File root = file.getParentFile();
        if (!root.exists() && !root.mkdirs()) 
            throw new RuntimeException("Failed to perform the action.");
        else {
            try {
                if (!file.exists() && !file.createNewFile())
                    throw new RuntimeException("Failed to perform the action.");
            } catch (IOException e) {
                throw new RuntimeException("Failed to perform the action.");
            }
        }
    }

    private Greeting parseGreeting(String line) {
        String[] parts = line.split(";");
        return new Greeting(
                parts[0],
                parts[1]
        );
    }

    @Override
    public Greeting byId(String id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
