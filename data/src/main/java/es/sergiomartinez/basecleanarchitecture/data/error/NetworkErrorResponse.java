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

package es.sergiomartinez.basecleanarchitecture.data.error;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class NetworkErrorResponse implements ApiNetworkErrorResponse {

  public int status;
  public String message;

  public NetworkErrorResponse(int status, String message) {
    this.status = status;
    this.message = message;
  }

  @Override public int getErrorCode() {
    return Integer.valueOf(status);
  }

  @Override public String getErrorMessage() {
    return message;
  }
}
