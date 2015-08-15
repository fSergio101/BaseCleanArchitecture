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
import java.net.SocketTimeoutException;
import retrofit.RetrofitError;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class NetworkRequestException extends RequestException {

  public NetworkRequestException(RetrofitError cause, Context context){
    super();
    this.cause = cause;
    this.context = context;

    if (cause.getCause() instanceof SocketTimeoutException) {
      requestExceptionType = RequestExceptionType.REQUEST_TIMEOUT_EXCEPTION;
    } else {
      requestExceptionType = RequestExceptionType.REQUEST_NO_NETWORK_EXCEPTION;
    }
  }

  @Override public int getErrorCode() {
    return getExceptionType().getErrorId();
  }

  @Override public String getHumanReadableErrorMessage() {
    if (requestExceptionType == RequestExceptionType.REQUEST_NO_NETWORK_EXCEPTION) {
      return context.getString(R.string.no_network_error);
    } else{
      return context.getString(R.string.network_timeout_error);
    }
  }
}
