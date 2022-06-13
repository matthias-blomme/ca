package ca.core.usecases.greetings.all;

import java.util.List;

import ca.core.domain.data.Greetings;
import ca.core.domain.models.Greeting;
import ca.core.usecases.Query;

public class GreetingsAll implements Query {

    public Greetings greetings;

    public GreetingsAll(Greetings greetings) {
        this.greetings = greetings;
    }

    @Override
    public List<Greeting> execute() {
        return greetings.all();
    }
    
}
