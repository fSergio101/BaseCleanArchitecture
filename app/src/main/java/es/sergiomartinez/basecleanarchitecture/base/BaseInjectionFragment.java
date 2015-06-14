package es.sergiomartinez.basecleanarchitecture.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dagger.ObjectGraph;
import es.sergiomartinez.basecleanarchitecture.R;
import es.sergiomartinez.basecleanarchitecture.di.FragmentModule;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public abstract class BaseInjectionFragment extends Fragment {

  protected static final String TAG = BaseInjectionFragment.class.getSimpleName();

  private ObjectGraph fragmentGraph;
  private BaseInjectionActivity activity;

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    this.activity = (BaseInjectionActivity) activity;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, getString(R.string.debug_info_oncreate));
    fragmentGraph = activity.addScopedModules(combineModules());
    fragmentGraph.inject(this);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
  Bundle savedInstanceState) {
    Log.d(TAG, getString(R.string.debug_info_oncreateview));
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    Log.d(TAG, getString(R.string.debug_info_onactivitycreated));
  }

  @Override
  public void onResume() {
    super.onResume();
    Log.d(TAG, getString(R.string.debug_info_onresume));
  }

  @Override
  public void onPause() {
    super.onPause();
    Log.d(TAG, getString(R.string.debug_info_onpause));
  }

  @Override
  public void onStop() {
    super.onStop();
    Log.d(TAG, getString(R.string.debug_info_onstop));
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.d(TAG, getString(R.string.debug_info_ondestroy));
    fragmentGraph = null;
  }

  private Object[] combineModules(){
    List<Object> graph = new ArrayList<>();
    graph.add(new FragmentModule(activity));
    graph.addAll(getModules());
    return graph.toArray();
  }

  protected abstract List<Object> getModules();
}
