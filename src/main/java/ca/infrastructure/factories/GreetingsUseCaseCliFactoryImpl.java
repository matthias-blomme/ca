package ca.infrastructure.factories;

import ca.adapters.cli.Presenter;
import ca.core.domain.data.Greetings;
import ca.core.domain.models.Greeting;
import ca.core.usecases.base.UseCaseIn;
import ca.core.usecases.commands.GreetingsAdd;
import ca.core.usecases.factories.UseCaseFactory;
import ca.core.usecases.queries.GreetingsAll;

public class GreetingsUseCaseCliFactoryImpl implements UseCaseFactory {

    private Greetings greetings;
    private Presenter presenter;

    public GreetingsUseCaseCliFactoryImpl(GreetingsFactory greetingsFactory, Presenter presenter) {
        this.presenter = presenter;
        this.greetings = greetingsFactory.createGreetingsFileBased();
    }

    @Override
    public UseCaseIn<Void> createGreetingsAll() {
        return new GreetingsAll(greetings, presenter::showAllGreetings);
    }

    @Override
    public UseCaseIn<Greeting> createGreetingsAdd() {
        return new GreetingsAdd(greetings);
    }
}
