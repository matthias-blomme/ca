package ca.core.usecases.factories;

import ca.core.domain.models.Greeting;
import ca.core.usecases.base.UseCaseIn;

public interface UseCaseFactory {

    UseCaseIn<Greeting> createGreetingsAdd();

    UseCaseIn<Void> createGreetingsAll();

}
