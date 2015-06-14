package es.sergiomartinez.basecleanarchitecture.data.error;

import android.content.Context;
import android.util.Log;
import es.sergiomartinez.basecleanarchitecture.data.error.exceptions.BusinessRequestException;
import es.sergiomartinez.basecleanarchitecture.data.error.exceptions.InternalServerRequestException;
import es.sergiomartinez.basecleanarchitecture.data.error.exceptions.NetworkRequestException;
import es.sergiomartinez.basecleanarchitecture.data.error.exceptions.RequestException;
import es.sergiomartinez.basecleanarchitecture.data.error.exceptions.RequestExceptionType;
import es.sergiomartinez.basecleanarchitecture.data.error.exceptions.UnknownRequestException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public abstract class RequestErrorHandler {

  private static final String TAG = RequestErrorHandler.class.getSimpleName();

  protected Context context;

  public RequestErrorHandler(Context context) {
    this.context = context;
  }

  protected RequestException handleError(RetrofitError cause) {

    if (cause.getKind() == RetrofitError.Kind.NETWORK) {
      return new NetworkRequestException(cause, context);

    } else if (cause.getResponse().getStatus() >= HttpURLConnection.HTTP_INTERNAL_ERROR) {
      return new InternalServerRequestException(cause, context, RequestExceptionType.INTERNAL_SERVER_EXCEPTION);

    } else {

      if (cause.getResponse().getStatus() >= HttpURLConnection.HTTP_BAD_REQUEST
          && cause.getResponse().getStatus() < HttpURLConnection.HTTP_INTERNAL_ERROR) {
        return createBusinessException(cause);

      } else {
        return unknownException(cause);
      }
    }
  }

  private RequestException unknownException(RetrofitError cause) {

    if (cause.getKind() == RetrofitError.Kind.HTTP) {
      //Manage other kind of HTTP errors not supported by app logic
      return new UnknownRequestException(cause, context, RequestExceptionType.HTTP_UNKNOWN_EXCEPTION);

    } else if (cause.getKind() == RetrofitError.Kind.UNEXPECTED) {
       //Manage UNEXPECTED exception:
       //@see{http://square.github.io/retrofit/javadoc/retrofit/RetrofitError.Kind.html}
       //An internal error occurred while attempting to execute a request. It is best
       //practice to re-throw this exception so your application crashes.
      throw new RuntimeException(cause);

    } else {
      return new UnknownRequestException(cause, context, RequestExceptionType.REQUEST_UNKNOWN_EXCEPTION);
    }
  }

  private RequestException createBusinessException(RetrofitError cause) {
    ApiNetworkErrorResponse apiNetworkErrorResponse = parseApiNetworkErrorResponse(cause);
    RequestException requestException = createBusinessExceptionForApiNetWorkErrorResponse(
        apiNetworkErrorResponse, cause);
    return requestException;
  }

  private ApiNetworkErrorResponse parseApiNetworkErrorResponse(RetrofitError cause) {
    try {
      return getApiNetworkResponseBody(cause);
    } catch (RuntimeException e) {
      Log.e(TAG, "Parse error Response exception: " + e.getLocalizedMessage());
    }
      return new NetworkErrorResponse(0, null);
  }

  protected abstract ApiNetworkErrorResponse getApiNetworkResponseBody(RetrofitError cause);

  private RequestException createBusinessExceptionForApiNetWorkErrorResponse(
      ApiNetworkErrorResponse apiNetworkErrorResponse, RetrofitError cause) {

    if (apiNetworkErrorResponse.getErrorCode() == HttpURLConnection.HTTP_UNAUTHORIZED){
      return new BusinessRequestException(cause, context, RequestExceptionType.REQUEST_UNAUHT_EXCEPTION,
          apiNetworkErrorResponse);
    }else if (isHumanReadable(apiNetworkErrorResponse)){

      return new BusinessRequestException(cause, context,
          RequestExceptionType.BUSINESS_USER_READABLE_CHECKED_EXCEPTION, apiNetworkErrorResponse);

    }else if(isNotHumanReadable(apiNetworkErrorResponse)){

      return new BusinessRequestException(cause, context,
          RequestExceptionType.BUSINESS_USER_NOT_READABLE_CHECKED_EXCEPTION, apiNetworkErrorResponse);

    }else{
      if (apiNetworkErrorResponse.getErrorCode()>0 && apiNetworkErrorResponse.getErrorMessage()!=null){

        return new BusinessRequestException(cause, context,
            RequestExceptionType.BUSINESS_UNKNOWN_CHECKED_EXCEPTION, apiNetworkErrorResponse);

      }else{

        return new BusinessRequestException(cause, context,
            RequestExceptionType.BUSINESS_NOT_CHECKED_EXCEPTION, apiNetworkErrorResponse);

      }
    }
  }

  protected boolean isHumanReadable(ApiNetworkErrorResponse apiNetworkErrorResponse){
    return binarySearchOver(getHumanReadableErrorCodes(), apiNetworkErrorResponse.getErrorCode());
  }

  protected abstract int[] getHumanReadableErrorCodes();

  protected boolean isNotHumanReadable(ApiNetworkErrorResponse apiNetworkErrorResponse){
    return binarySearchOver(getHumanNotReadableErrorCodes(), apiNetworkErrorResponse.getErrorCode());
  }

  protected abstract int[] getHumanNotReadableErrorCodes();

  private boolean binarySearchOver(int[] orderedArray, int coincidence) {
    int a = Arrays.binarySearch(orderedArray, coincidence);

    if (a > 0){
      return true;
    }else{
      return false;
    }
  }

  protected boolean checkNotAuthError(Response response) {
    if (response.getStatus() == HttpURLConnection.HTTP_UNAUTHORIZED){
      return true;
    }else{
      return false;
    }
  }
}
