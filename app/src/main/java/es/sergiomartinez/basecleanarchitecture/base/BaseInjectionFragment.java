/*
 *
 *  Copyright (C) 2015 Sergio Martinez Open Source Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

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
