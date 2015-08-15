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

package es.sergiomartinez.basecleanarchitecture.domain;

import android.os.Handler;
import android.os.Looper;
import de.greenrobot.event.EventBus;
import es.sergiomartinez.basecleanarchitecture.domain.abstractions.Bus;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class BusImp extends EventBus implements Bus {

  private static final Handler handler = new Handler(Looper.getMainLooper());

  @Override public void post(final Object event) {
    handler.post(new Runnable() {
      @Override public void run() {
        BusImp.super.post(event);
      }
    });
  }

  @Override public void postInmediate(final Object event) {
    handler.postAtFrontOfQueue(new Runnable() {
      @Override public void run() {
        BusImp.super.post(event);
      }
    });
  }
}
