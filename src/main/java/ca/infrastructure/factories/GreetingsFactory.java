package ca.infrastructure.factories;

import ca.adapters.db.GreetingsFileBased;
import ca.core.domain.repositories.Greetings;

public class GreetingsFactory {

    Greetings createGreetingsFileBased() {
        return new GreetingsFileBased();
    }

}
