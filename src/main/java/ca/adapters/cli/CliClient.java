package ca.adapters.cli;

import java.io.IOException;
import ca.core.domain.models.Greeting;
import ca.core.usecases.base.UseCaseMediator;

public class CliClient {

    private static final int CHOICE_ADD = 1;

    private static final int CHOICE_ALL = 2;

    private Presenter renderer;
    private UseCaseMediator useCaseMediator;
    private boolean isRunning = true;

    public CliClient(UseCaseMediator useCaseMediator, Presenter renderer) {
        this.useCaseMediator = useCaseMediator;
        this.renderer = renderer;
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
            case CHOICE_ALL:
                handleGreetingsAll();
            default:
                isRunning = false;
        }
    }

    private void handleGreetingsAdd() throws IOException {
        Greeting greeting = new Greeting(renderer.askForGreeting());
        useCaseMediator.addGreeting(greeting);
    }

    private void handleGreetingsAll() {
        useCaseMediator.getAllGreetings();
    }

}
