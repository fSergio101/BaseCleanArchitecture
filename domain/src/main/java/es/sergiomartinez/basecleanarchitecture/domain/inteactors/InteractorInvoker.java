package es.sergiomartinez.basecleanarchitecture.domain.inteactors;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public interface InteractorInvoker {
    void execute(Interactor interactor);
    void execute(Interactor interactor, InteractorPriority priority);
}
