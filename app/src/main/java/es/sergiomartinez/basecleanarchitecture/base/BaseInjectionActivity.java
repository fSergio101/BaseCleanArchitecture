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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import es.sergiomartinez.basecleanarchitecture.App;
import es.sergiomartinez.basecleanarchitecture.AppComponent;
import es.sergiomartinez.basecleanarchitecture.R;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public abstract class BaseInjectionActivity<T> extends AppCompatActivity{

  protected static final String TAG = BaseInjectionActivity.class.getSimpleName();

  protected T activityComponent;

  //@Inject LoggerManager loggerManager;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, getString(R.string.debug_info_oncreate));
    initDI();
    Log.d(TAG, activityComponent.toString());
  }

  protected abstract void initDI();

  abstract public void onActivityDestroyed();

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
    activityComponent = null;
  }

  public AppComponent getAppComponent() {
    AppComponent appComponent = ((App) getApplication()).getAppComponent();
    return appComponent;
  }

  public Object getActivityComponent() {

    if (activityComponent == null){
      this.finish();
      this.recreate();
    }
    return activityComponent;
  }

}
