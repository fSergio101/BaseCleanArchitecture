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

import android.content.Intent;
import android.os.Bundle;
import butterknife.ButterKnife;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public abstract class BaseUIActivity<T> extends BaseInjectionActivity<T> {

  @Override public void setContentView(int layoutResID) {
      super.setContentView(layoutResID);
      ButterKnife.inject(this);
  }

  /**
   * Navigate to targetClass activity with empty Bundle params
   */
  public void navigate(Class<?> targetClass) {
    navigate(targetClass, new Bundle());
  }

  /**
   * Navigate to targetClass activity with params Bundle params
   */
  public void navigate(Class<?> targetClass, Bundle params) {
    Intent i = new Intent(this, targetClass);
    if (params != null && !params.isEmpty()) {
      i.putExtras(params);
    }
    startActivity(i);
  }

  /**
   * Navigate to targetClass activity with params Bundle params
   */
  public void navigate(Class<?> targetClass, int flag) {
    Intent i = new Intent(this, targetClass);
    i.setFlags(flag);
    startActivity(i);
  }


  @Override public void onActivityDestroyed() {
    navigate(this.getClass());
    this.finish();
  }


}
