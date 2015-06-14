package es.sergiomartinez.basecleanarchitecture.domain.inteactors;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class BaseEvent {

    private Throwable error;

    public Throwable getError() {
      return error;
    }

    public void setError(Throwable error) {
      this.error = error;
    }

}
