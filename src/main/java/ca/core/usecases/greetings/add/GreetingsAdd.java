package ca.core.usecases.greetings.add;

import ca.core.domain.models.Greeting;
import ca.core.domain.repositories.Greetings;
import ca.core.usecases.Command;

public class GreetingsAdd implements Command {

    private Greetings greetings;
    private Greeting greeting;

    public GreetingsAdd(Greetings greetings, Greeting greeting) {
        this.greetings = greetings;
        this.greeting = greeting;
    }
 
    public void execute() {
        greetings.add(greeting);
    }
}
