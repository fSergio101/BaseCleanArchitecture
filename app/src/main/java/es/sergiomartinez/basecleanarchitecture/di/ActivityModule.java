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

package es.sergiomartinez.basecleanarchitecture.di;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import dagger.Module;
import dagger.Provides;
import es.sergiomartinez.basecleanarchitecture.base.BaseInjectionActivity;
import es.sergiomartinez.basecleanarchitecture.base.BaseUIActivity;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
@Module(
    complete = false,
    library = true)
public class ActivityModule {

  private BaseUIActivity activity;

  public ActivityModule(BaseInjectionActivity activity) {
    this.activity = (BaseUIActivity) activity;
  }

  @Provides @Singleton @Named("activityContext") Context provideContext() {
    return activity;
  }

  @Provides @Singleton AppCompatActivity provideActivity() {
    return activity;
  }

  @Provides @Singleton FragmentManager provideFragmentManager() {
    return activity.getSupportFragmentManager();
  }

}
