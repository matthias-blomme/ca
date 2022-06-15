package ca.infrastructure.factories;

import ca.adapters.cli.CliClient;
import ca.adapters.cli.Presenter;
import ca.core.usecases.base.UseCaseMediator;
import ca.core.usecases.base.UseCaseMediatorImpl;

public class ExecutableFactory {

    public static CliClient createCli() {

        Presenter presenter =  new Presenter();

        GreetingsFactory greetingsFactory = new GreetingsFactory();
        
        GreetingsUseCaseCliFactoryImpl greetingsUseCaseFactory = 
            new GreetingsUseCaseCliFactoryImpl(greetingsFactory, presenter);

        UseCaseMediator mediator = new UseCaseMediatorImpl(greetingsUseCaseFactory);

        return new CliClient(mediator, presenter);
    }

}
