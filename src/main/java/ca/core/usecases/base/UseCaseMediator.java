package ca.core.usecases.base;

import ca.core.domain.models.Greeting;

public interface UseCaseMediator {

    public void addGreeting(Greeting greeting);
    public void getAllGreetings();
    
}
