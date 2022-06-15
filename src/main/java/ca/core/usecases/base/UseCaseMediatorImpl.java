package ca.core.usecases.base;

import ca.core.domain.models.Greeting;

public class UseCaseMediatorImpl implements UseCaseMediator {

    private UseCaseFactory factory;

    public UseCaseMediatorImpl(UseCaseFactory factory) {
        this.factory = factory;
    }

    @Override
    public void addGreeting(Greeting greeting) {
        UseCaseIn<Greeting> useCase = factory.createGreetingsAdd();
        useCase.process(greeting);
    }

    @Override
    public void getAllGreetings() {
        UseCaseIn<Void> useCase = factory.createGreetingsAll();
        useCase.process();
    }
    
}
