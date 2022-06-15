package ca.infrastructure.factories;

import ca.adapters.cli.CliClient;
import ca.adapters.cli.Presenter;

public class ExecutableFactory {

    public static CliClient createCli() {

        Presenter presenter =  new Presenter();

        GreetingsFactory greetingsFactory = new GreetingsFactory();
        
        GreetingsUseCaseCliFactoryImpl greetingsUseCaseFactory = 
            new GreetingsUseCaseCliFactoryImpl(greetingsFactory, presenter);

        return new CliClient(greetingsUseCaseFactory, presenter);
    }

}
