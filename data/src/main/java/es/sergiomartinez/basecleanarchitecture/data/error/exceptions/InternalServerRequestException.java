package es.sergiomartinez.basecleanarchitecture.data.error.exceptions;

import android.content.Context;
import es.sergiomartinez.basecleanarchitecture.data.R;
import retrofit.RetrofitError;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class InternalServerRequestException extends RequestException {

  public InternalServerRequestException(RetrofitError cause, Context context, RequestExceptionType requestExceptionType){
    super();
    this.cause = cause;
    this.context = context;
    this.requestExceptionType = requestExceptionType;
  }

  @Override public int getErrorCode() {
    return requestExceptionType.getErrorId();
  }

  @Override public String getHumanReadableErrorMessage() {
    return context.getString(R.string.request_server_internal_error);
  }
}
