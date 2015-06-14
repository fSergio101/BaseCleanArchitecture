package es.sergiomartinez.basecleanarchitecture.data.datamodel.entities;

import com.google.gson.annotations.Expose;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class ApiResult {

  @Expose
  private ApiUser user;
  @Expose
  private String seed;

  public ApiUser getUser() {
    return user;
  }

  public void setUser(ApiUser user) {
    this.user = user;
  }

  public String getSeed() {
    return seed;
  }

  public void setSeed(String seed) {
    this.seed = seed;
  }

}
