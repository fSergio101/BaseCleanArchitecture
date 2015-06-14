package es.sergiomartinez.basecleanarchitecture.data.repository.network.randomusersapi;

import es.sergiomartinez.basecleanarchitecture.data.datamodel.response.GetUsersResponse;
import es.sergiomartinez.basecleanarchitecture.data.error.exceptions.RequestException;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public interface RandomUsersApiService {

  @GET("/")
  GetUsersResponse getUserList(@Query("results") int numberOfUsers) throws RequestException;
}
