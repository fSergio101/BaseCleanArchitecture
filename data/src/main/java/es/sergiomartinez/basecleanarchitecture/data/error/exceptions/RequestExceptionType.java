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

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public enum RequestExceptionType {

  BUSINESS_USER_READABLE_CHECKED_EXCEPTION(0),
  BUSINESS_USER_NOT_READABLE_CHECKED_EXCEPTION(0),
  BUSINESS_UNKNOWN_CHECKED_EXCEPTION(0),
  INTERNAL_SERVER_EXCEPTION(-1),
  BUSINESS_NOT_CHECKED_EXCEPTION(-2),
  REQUEST_TIMEOUT_EXCEPTION(-3),
  REQUEST_NO_NETWORK_EXCEPTION(-4),
  HTTP_UNKNOWN_EXCEPTION(-5),
  REQUEST_UNKNOWN_EXCEPTION(-6),
  REQUEST_UNAUHT_EXCEPTION(-7),
  BUSINESS_USER_READABLE_CHECKED_EXCEPTION_INVALID_PLATE(0);


  private int errorId;

  RequestExceptionType(int errorId) {
    this.errorId = errorId;
  }

  public int getErrorId() {
    return errorId;
  }
}
