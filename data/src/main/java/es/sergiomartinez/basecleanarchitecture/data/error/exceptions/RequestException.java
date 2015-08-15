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

package es.sergiomartinez.basecleanarchitecture.data.error.exceptions;

import android.content.Context;
import retrofit.RetrofitError;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public abstract class RequestException extends Exception {

  protected RetrofitError cause;
  protected Context context;
  protected RequestExceptionType requestExceptionType;
  protected int retryId;

  public RequestExceptionType getExceptionType(){
    return requestExceptionType;
  }

  public int getHttpStatus(){
   return cause.getResponse().getStatus();
  }

  public String getHttpMessage(){
    return cause.getResponse().getReason();
  }

  public abstract int getErrorCode();

  public abstract String getHumanReadableErrorMessage();

  public RetrofitError getRetrofitCause() {
    return cause;
  }

  public int getRetryId() {
    return retryId;
  }

  public void setRetryId(int retryId) {
    this.retryId = retryId;
  }
}
