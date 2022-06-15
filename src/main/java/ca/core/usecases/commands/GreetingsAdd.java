package ca.core.usecases.commands;

import ca.core.domain.data.Greetings;
import ca.core.domain.models.Greeting;

public class GreetingsAdd extends CmdUseCase<Greeting, Greetings> {

    public GreetingsAdd(Greetings greetings) {
        super(greetings);
    }
 
    public void execute() {
        Greeting greeting = getInput();
        this.getDomain().add(greeting);
    }
}
