package ca.core.usecases.base;

public interface UseCaseIn<I> {

    public void process(I input);

    public void process();
    
}
