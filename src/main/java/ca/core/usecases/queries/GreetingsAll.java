package ca.core.usecases.queries;

import java.util.List;

import ca.core.domain.data.Greetings;
import ca.core.domain.models.Greeting;
import ca.core.usecases.base.UseCaseOut;

public class GreetingsAll extends QryUseCase<Void, List<Greeting>, Greetings> {

    public GreetingsAll(Greetings greetings, UseCaseOut<List<Greeting>> out) {
        super(greetings, out);
    }

    @Override
    public void execute() {
        var result = getDomain().all();
        getOut().send(result);
    }
    
}
