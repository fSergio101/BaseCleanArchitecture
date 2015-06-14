package es.sergiomartinez.basecleanarchitecture.data.repository.network.randomusersapi;

import android.app.Application;
import android.content.Context;
import javax.inject.Inject;
import retrofit.RequestInterceptor;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class RandomUsersApiRequestInterceptor implements RequestInterceptor {

  private static final String CONTENT_TYPE_HEADER =  "content-type";
  private static final String CONTENT_TYPE_CONTENT = "application/json; charset=UTF-8";

  private Context context;

  @Inject
  public RandomUsersApiRequestInterceptor(Application app){
    this.context = app.getApplicationContext();
  }

  @Override public void intercept(RequestFacade request) {

    request.addHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE_CONTENT);

  }

}
