package ca.infrastructure.factories;

import ca.adapters.cli.CliClient;

public class ExecutableFactory {

    public static CliClient createCli() {
        
        return new CliClient(new GreetingsUseCaseFactoryImpl(new GreetingsFactory()));
    }

}
