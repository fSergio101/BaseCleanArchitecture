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
