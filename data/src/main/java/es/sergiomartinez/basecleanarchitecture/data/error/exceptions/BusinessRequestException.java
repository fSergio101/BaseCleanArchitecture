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
