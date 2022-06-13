package ca.core.domain.models;

public class Greeting {
    private static String ID;
    public String message;

    public Greeting(String message) {
        this("NOT PERSISTED", message);
    }

    public Greeting(String id, String message) {
        this.ID = id;
        this.message = message;
    }
}
