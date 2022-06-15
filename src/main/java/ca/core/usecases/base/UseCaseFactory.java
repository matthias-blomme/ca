package ca.core.usecases.base;

import ca.core.domain.models.Greeting;

public interface UseCaseFactory {

    UseCaseIn<Greeting> createGreetingsAdd();

    UseCaseIn<Void> createGreetingsAll();

}
