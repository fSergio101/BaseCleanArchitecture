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
import es.sergiomartinez.basecleanarchitecture.data.R;
import retrofit.RetrofitError;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class UnknownRequestException extends RequestException {

  public UnknownRequestException(RetrofitError cause, Context context, RequestExceptionType requestExceptionType){
    super();
    this.cause = cause;
    this.context = context;
    this.requestExceptionType = requestExceptionType;
  }

  @Override public int getErrorCode() {
    return requestExceptionType.getErrorId();
  }

  @Override public String getHumanReadableErrorMessage() {
    if (requestExceptionType == RequestExceptionType.HTTP_UNKNOWN_EXCEPTION) {
      return context.getString(R.string.request_http_unknown_fail);
    } else{
      return context.getString(R.string.request_unknoun_fail);
    }
  }
}
