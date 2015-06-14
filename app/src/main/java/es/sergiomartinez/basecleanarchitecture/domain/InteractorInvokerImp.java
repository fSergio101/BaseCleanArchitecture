package es.sergiomartinez.basecleanarchitecture.domain;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.Params;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.Interactor;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.InteractorInvoker;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.InteractorPriority;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class InteractorInvokerImp implements InteractorInvoker {

  private JobManager jobManager;

  public InteractorInvokerImp(JobManager jobManager) {
    this.jobManager = jobManager;
  }

  @Override public void execute(Interactor interactor) {
    execute(interactor, InteractorPriority.MEDIUM);
  }

  @Override public void execute(Interactor interactor, InteractorPriority priority) {
    jobManager.addJob(interactorToJob(interactor, priority));
  }

  private Job interactorToJob(Interactor interactor, InteractorPriority priority) {
    Params params = new Params(priority.getPriorityValue());
    return new InteractorJobImp(params, interactor);
  }
}
