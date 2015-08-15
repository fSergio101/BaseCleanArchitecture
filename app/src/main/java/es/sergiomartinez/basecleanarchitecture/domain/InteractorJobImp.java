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

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.Interactor;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class InteractorJobImp extends Job {

  private Interactor interactor;

  public InteractorJobImp(Params params, Interactor interactor) {
    super(params);
    this.interactor = interactor;
  }

  @Override public void onAdded() {
  }

  @Override public void onRun() throws Throwable {
    interactor.execute();
   }

  @Override protected void onCancel() {
  }

  @Override protected boolean shouldReRunOnThrowable(Throwable throwable) {
    return false;
  }
}
