package ca.core.usecases.base;

public interface UseCaseOut<R> {

    public void send(R response);
    
}
