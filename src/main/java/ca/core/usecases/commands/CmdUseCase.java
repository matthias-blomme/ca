package ca.core.usecases.commands;

import ca.core.usecases.base.UseCaseIn;

public abstract class CmdUseCase<I, D> implements UseCaseIn<I> {

    private I input;
    private D domain;

    public CmdUseCase(D domain) {
        this.domain = domain;
    }

    @Override 
    public void process(I input) {
        this.input = input;
        this.process();
    }

    @Override
    public void process() {
        this.execute();
    }

    protected D getDomain() {
        return domain;
    }

    protected I getInput() {
        return input;
    }

    abstract protected void execute();

}
