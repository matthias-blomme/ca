package ca.adapters.cli;

import java.io.IOException;

import ca.core.domain.models.Greeting;
import ca.core.factories.GreetingsUseCaseFactory;

public class CliClient {

    private static final int CHOICE_ADD = 1;

    private Renderer renderer = new Renderer();
    private GreetingsUseCaseFactory useCaseFactory;
    private boolean isRunning = true;

    public CliClient(GreetingsUseCaseFactory useCaseFactory) {
        this.useCaseFactory = useCaseFactory;
    }

    public void init() throws IOException {
        cliLoop();
    }

    private void cliLoop() throws IOException {
        while(isRunning) {
            renderer.showMainScreen();
            handleChoice(renderer.askForChoice());
        }
    }

    private void handleChoice(int choice) throws IOException {
        switch (choice) {
            case CHOICE_ADD:
                handleGreetingsAdd();
                break;
            default:
                isRunning = false;
        }
    }

    private void handleGreetingsAdd() throws IOException {
        Greeting greeting = new Greeting(renderer.askForGreeting());
        useCaseFactory.createGreetingsAdd(greeting).execute();
    }

}
