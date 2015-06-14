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
