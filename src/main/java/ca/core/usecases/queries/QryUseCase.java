package ca.core.usecases.queries;

import ca.core.usecases.base.UseCaseOut;
import ca.core.usecases.commands.CmdUseCase;

public abstract class QryUseCase<I, R, D> extends CmdUseCase<I, D> {

    private UseCaseOut<R> out;

    public QryUseCase(D domain, UseCaseOut<R> out) {
        super(domain);
        this.out = out;
    }

    public UseCaseOut<R> getOut() {
        return out;
    }

}
