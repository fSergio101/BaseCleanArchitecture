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
