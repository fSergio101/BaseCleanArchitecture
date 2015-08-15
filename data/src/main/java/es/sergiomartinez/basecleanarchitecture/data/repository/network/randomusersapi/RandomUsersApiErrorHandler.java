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

import android.content.Context;
import es.sergiomartinez.basecleanarchitecture.data.error.ApiNetworkErrorResponse;
import es.sergiomartinez.basecleanarchitecture.data.error.RequestErrorHandler;
import es.sergiomartinez.basecleanarchitecture.data.error.exceptions.RequestException;
import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class RandomUsersApiErrorHandler extends RequestErrorHandler implements ErrorHandler {

  private final static int FORCE_HUMAN_READABLE_CODE = 999;

  //the following arrays MUST be ordered otherWise Arrays.binarySearch won't Work
  static final int[] humanReadableErrorCodes = new int[]{ FORCE_HUMAN_READABLE_CODE };
  static final int[] humanNotReadableErrorCodes = new int[]{ };

  public RandomUsersApiErrorHandler(Context context){
    super(context);
  }

  @Override public RequestException handleError(RetrofitError cause) {
    return super.handleError(cause);
  }

  @Override protected ApiNetworkErrorResponse getApiNetworkResponseBody(RetrofitError cause) {

    RandomUsersApiErrorResponse randomUsersApiErrorResponse =
        (RandomUsersApiErrorResponse) cause.getBodyAs(RandomUsersApiErrorResponse.class);

    randomUsersApiErrorResponse.setHttpErrorCode(cause.getResponse().getStatus());

    //Not available list of human readable codes, default: ALL
    randomUsersApiErrorResponse.setHttpErrorCode(FORCE_HUMAN_READABLE_CODE);

    return randomUsersApiErrorResponse;
  }

  @Override protected int[] getHumanReadableErrorCodes() {
    return humanReadableErrorCodes;
  }

  @Override protected int[] getHumanNotReadableErrorCodes() {
    return humanNotReadableErrorCodes;
  }

}
