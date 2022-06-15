package ca.adapters.cli;

import java.io.IOException;
import ca.core.domain.models.Greeting;
import ca.core.usecases.factories.UseCaseFactory;

public class CliClient {

    private static final int CHOICE_ADD = 1;
    private static final int CHOICE_ALL = 2;
    private Presenter presenter;
    private UseCaseFactory useCaseFactory;
    private boolean isRunning = true;

    public CliClient(UseCaseFactory useCaseFactory, Presenter presenter) {
        this.useCaseFactory = useCaseFactory;
        this.presenter = presenter;
    }

    public void init() throws IOException {
        cliLoop();
    }

    private void cliLoop() throws IOException {
        while(isRunning) {
            presenter.showMainScreen();
            handleChoice(presenter.askForChoice());
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
        Greeting greeting = new Greeting(presenter.askForGreeting());
        useCaseFactory.createGreetingsAdd().process(greeting);
    }

    private void handleGreetingsAll() {
        useCaseFactory.createGreetingsAll().process();
    }

}