package es.sergiomartinez.basecleanarchitecture.data.repository.network.randomusersapi;

import com.google.gson.annotations.Expose;
import es.sergiomartinez.basecleanarchitecture.data.error.ApiNetworkErrorResponse;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class RandomUsersApiErrorResponse implements ApiNetworkErrorResponse{
  @Expose
  public String error;

  public int httpErrorCode;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public int getHttpErrorCode() {
    return httpErrorCode;
  }

  public void setHttpErrorCode(int httpErrorCode) {
    this.httpErrorCode = httpErrorCode;
  }

  @Override public int getErrorCode() {
    return httpErrorCode;
  }

  @Override public String getErrorMessage() {
    return error;
  }


}
