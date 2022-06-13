package ca.infrastructure.factories;

import ca.adapters.db.GreetingsFileBased;
import ca.core.domain.data.Greetings;

public class GreetingsFactory {

    Greetings createGreetingsFileBased() {
        return new GreetingsFileBased();
    }

}
