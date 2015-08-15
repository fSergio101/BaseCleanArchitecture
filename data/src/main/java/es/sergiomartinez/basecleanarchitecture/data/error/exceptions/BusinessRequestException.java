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
import es.sergiomartinez.basecleanarchitecture.data.error.ApiNetworkErrorResponse;
import retrofit.RetrofitError;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class BusinessRequestException extends RequestException {

  private final ApiNetworkErrorResponse apiNetworkErrorResponse;

  public BusinessRequestException(RetrofitError cause, Context context,
      RequestExceptionType requestExceptionType, ApiNetworkErrorResponse apiNetworkErrorResponse){
    super();
    this.cause = cause;
    this.context = context;
    this.requestExceptionType = requestExceptionType;
    this.apiNetworkErrorResponse = apiNetworkErrorResponse;
  }

  @Override public int getErrorCode() {
    if (requestExceptionType == RequestExceptionType.BUSINESS_UNKNOWN_CHECKED_EXCEPTION){
      return requestExceptionType.getErrorId();
    }else{
      return apiNetworkErrorResponse.getErrorCode();
    }
  }

  @Override public String getHumanReadableErrorMessage() {
    if (requestExceptionType == RequestExceptionType.BUSINESS_USER_READABLE_CHECKED_EXCEPTION ||
        requestExceptionType == RequestExceptionType.BUSINESS_USER_NOT_READABLE_CHECKED_EXCEPTION ||
        requestExceptionType == RequestExceptionType.BUSINESS_UNKNOWN_CHECKED_EXCEPTION ||
        requestExceptionType == RequestExceptionType.BUSINESS_USER_READABLE_CHECKED_EXCEPTION_INVALID_PLATE) {
      return apiNetworkErrorResponse.getErrorMessage();
    } else {
      //this error case is most of times when parsing is not successful
      return context.getString(R.string.request_generic_fail);
    }
  }

}
