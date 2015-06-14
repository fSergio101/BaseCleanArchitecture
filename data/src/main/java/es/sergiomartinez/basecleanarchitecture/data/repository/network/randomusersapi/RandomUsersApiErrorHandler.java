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
