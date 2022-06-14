package ca.core.usecases.greetings.all;

import java.util.List;
import java.util.function.Consumer;

import ca.core.domain.data.Greetings;
import ca.core.domain.models.Greeting;
import ca.core.usecases.GreetingsUseCase;

public class GreetingsAll extends GreetingsUseCase<List<Greeting>> {

    public GreetingsAll(Greetings greetings, Consumer<List<Greeting>> responseConsumer) {
        super(greetings, responseConsumer);
    }

    @Override
    protected List<Greeting> executeUseCase() {
        return getGreetings().all();
    }
    
}
