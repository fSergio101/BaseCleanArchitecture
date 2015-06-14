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
