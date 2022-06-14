package ca.core.usecases;

import java.util.function.Consumer;
import ca.core.domain.data.Greetings;

public abstract class GreetingsUseCase<R> implements Command {

    private Greetings greetings;
    private Consumer<R> responseConsumer;

    public GreetingsUseCase(Greetings greetings, Consumer<R> responseConsumer) {
        this.greetings = greetings;
        this.responseConsumer = responseConsumer;
    }

    public void execute() {
        responseConsumer.accept(executeUseCase());
    }

    protected abstract R executeUseCase();

    protected Greetings getGreetings() {
        return greetings;
    }
    
}
