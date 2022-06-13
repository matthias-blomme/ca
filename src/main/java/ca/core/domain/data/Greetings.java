package ca.core.domain.data;

import java.util.List;

import ca.core.domain.models.Greeting;

public interface Greetings {

    public Greeting byId(String id);
    public List<Greeting> all();
    public void add(Greeting greeting);
    
}
