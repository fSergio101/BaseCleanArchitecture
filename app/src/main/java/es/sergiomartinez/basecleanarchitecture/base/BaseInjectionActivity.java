package es.sergiomartinez.basecleanarchitecture.base;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import dagger.ObjectGraph;
import es.sergiomartinez.basecleanarchitecture.App;
import es.sergiomartinez.basecleanarchitecture.R;
import es.sergiomartinez.basecleanarchitecture.di.ActivityModule;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public abstract class BaseInjectionActivity  extends AppCompatActivity {

  protected static final String TAG = BaseInjectionActivity.class.getSimpleName();

  private ObjectGraph activityGraph;

  //@Inject LoggerManager loggerManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, getString(R.string.debug_info_oncreate));
    activityGraph = ((App) getApplication()).addScopedModules(combineModules());
    activityGraph.inject(this);
  }

  @Override
  protected void onResume() {
    super.onResume();
    //loggerManager.Log("");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(TAG, getString(R.string.debug_info_onpause));
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(TAG, getString(R.string.debug_info_onstop));
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(TAG, getString(R.string.debug_info_ondestroy));
    activityGraph = null;
  }

  //public ObjectGraph addScopedModules(Object... modules) {
  //  return activityGraph.plus(modules);
  //}

  protected Object[] combineModules(){
    List<Object> graph = new ArrayList<>();
    graph.addAll(getModules());
    graph.add(new ActivityModule(this));
    return graph.toArray();
  }

  public ObjectGraph getActivityGraph() {
    return activityGraph;
  }

  protected ObjectGraph addScopedModules(Object... modules) {
      ObjectGraph activityObjectGraph = getActivityGraph();
      return activityObjectGraph.plus(modules);
  }

  public void setActivityGraph(ObjectGraph activityGraph) {
    this.activityGraph = activityGraph;
  }

  protected abstract List<Object> getModules();

}
