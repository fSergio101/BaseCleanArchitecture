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

package es.sergiomartinez.basecleanarchitecture.data.repository.network.randomusersapi;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;
import retrofit.RequestInterceptor;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class RandomUsersApiRequestInterceptor implements RequestInterceptor {

  private static final String CONTENT_TYPE_HEADER =  "content-type";
  private static final String CONTENT_TYPE_CONTENT = "application/json; charset=UTF-8";

  private Context context;

  @Inject
  public RandomUsersApiRequestInterceptor(Application app){
    this.context = app.getApplicationContext();
  }

  @Override public void intercept(RequestFacade request) {

    request.addHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE_CONTENT);

  }

}
