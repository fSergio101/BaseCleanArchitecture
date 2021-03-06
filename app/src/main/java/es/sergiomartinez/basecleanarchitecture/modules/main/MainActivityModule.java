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

package es.sergiomartinez.basecleanarchitecture.modules.main;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
@Module(
    library = true,
    complete = false,
    injects = { MainActivity.class })
public class MainActivityModule {

  private MainActivity activity;

  public MainActivityModule(MainActivity mainActivity) {
   this.activity = mainActivity;
  }

  @Provides @Singleton MainActivity provideMainActivity(){
    return activity;
  }
}
