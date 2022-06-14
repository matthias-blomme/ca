package ca.core.factories;

import ca.core.domain.models.Greeting;
import ca.core.usecases.Command;

public interface GreetingsUseCaseFactory {

    public Command createGreetingsAdd(Greeting greeting);
    public Command createGreetingsAll();
    
}
