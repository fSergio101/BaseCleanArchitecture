package es.sergiomartinez.basecleanarchitecture.domain;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.Interactor;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class InteractorJobImp extends Job {

  private Interactor interactor;

  public InteractorJobImp(Params params, Interactor interactor) {
    super(params);
    this.interactor = interactor;
  }

  @Override public void onAdded() {
  }

  @Override public void onRun() throws Throwable {
    interactor.execute();
   }

  @Override protected void onCancel() {
  }

  @Override protected boolean shouldReRunOnThrowable(Throwable throwable) {
    return false;
  }
}
