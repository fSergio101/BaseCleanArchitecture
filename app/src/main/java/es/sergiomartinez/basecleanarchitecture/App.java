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
import dagger.ObjectGraph;
import es.sergiomartinez.basecleanarchitecture.di.AppModule;
import java.util.Arrays;
import java.util.List;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class App extends Application{

  private ObjectGraph objectGraph;

  @Override public void onCreate() {
    super.onCreate();
    objectGraph = ObjectGraph.create(getModules().toArray());
    objectGraph.inject(this);
    init();
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

  private List<Object> getModules() {
    return Arrays.<Object>asList(new AppModule(this));
  }

  public ObjectGraph getMainGraph() {
    return objectGraph;
  }

  public ObjectGraph addScopedModules(Object... modules) {
    return objectGraph.plus(modules);
  }

}
