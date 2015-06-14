package es.sergiomartinez.basecleanarchitecture.data.error;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public interface ApiNetworkErrorResponse {
  int getErrorCode();
  String getErrorMessage();
}
