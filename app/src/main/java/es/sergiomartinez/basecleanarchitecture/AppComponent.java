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
import android.content.Context;
import dagger.Component;
import es.sergiomartinez.basecleanarchitecture.di.AppModule;
import es.sergiomartinez.basecleanarchitecture.domain.abstractions.Bus;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.InteractorInvoker;
import javax.inject.Singleton;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 22/8/15.
 */
@Singleton @Component(modules = AppModule.class)
public interface AppComponent {
  Application provideApplication();
  Context provideApplicationContext();
  InteractorInvoker provideInteractorInvoker();
  Bus provideEventbus();
}
