package ca.core.factories;

import ca.core.domain.models.Greeting;
import ca.core.usecases.Command;
import ca.core.usecases.Query;

public interface GreetingsUseCaseFactory {

    public Command createGreetingsAdd(Greeting greeting);
    public Query createGreetingsAll();
    
}
