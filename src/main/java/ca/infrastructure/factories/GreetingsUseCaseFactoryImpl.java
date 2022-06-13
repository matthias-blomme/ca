package ca.infrastructure.factories;

import ca.core.domain.models.Greeting;
import ca.core.domain.repositories.Greetings;
import ca.core.factories.GreetingsUseCaseFactory;
import ca.core.usecases.Command;
import ca.core.usecases.Query;
import ca.core.usecases.greetings.add.GreetingsAdd;
import ca.core.usecases.greetings.all.GreetingsAll;

public class GreetingsUseCaseFactoryImpl implements GreetingsUseCaseFactory {

    private Greetings greetings;

    public GreetingsUseCaseFactoryImpl(GreetingsFactory greetingsFactory) {
        this.greetings = greetingsFactory.createGreetingsFileBased();
    }

    @Override
    public Command createGreetingsAdd(Greeting greeting) {
        return new GreetingsAdd(greetings, greeting);
    }

    @Override
    public Query createGreetingsAll() {
        return new GreetingsAll(greetings);
    }
    
}
