package ca.infrastructure.factories;

import ca.adapters.cli.Presenter;
import ca.core.domain.data.Greetings;
import ca.core.domain.models.Greeting;
import ca.core.factories.GreetingsUseCaseFactory;
import ca.core.usecases.Command;
import ca.core.usecases.greetings.add.GreetingsAdd;
import ca.core.usecases.greetings.all.GreetingsAll;

public class GreetingsUseCaseCliFactoryImpl implements GreetingsUseCaseFactory {

    private Greetings greetings;
    private Presenter presenter;

    public GreetingsUseCaseCliFactoryImpl(GreetingsFactory greetingsFactory, Presenter presenter) {
        this.presenter = presenter;
        this.greetings = greetingsFactory.createGreetingsFileBased();
    }

    @Override
    public Command createGreetingsAdd(Greeting greeting) {
        return new GreetingsAdd(greetings, greeting);
    }

    @Override
    public Command createGreetingsAll() {
        return new GreetingsAll(greetings, presenter::showAllGreetings);
    }
    
}
