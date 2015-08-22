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

package es.sergiomartinez.basecleanarchitecture;

import android.app.Application;
import es.sergiomartinez.basecleanarchitecture.di.AppModule;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class App extends Application{

  private AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();

    initDI();
    init();
  }

  private void initDI() {
    appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    appComponent.inject(this);
  }

  private void init() {
    initCalligraphyLib();
  }

  private void initCalligraphyLib() {
    CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
            .setFontAttrId(R.attr.fontPath)
            .build()
    );
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }

}
