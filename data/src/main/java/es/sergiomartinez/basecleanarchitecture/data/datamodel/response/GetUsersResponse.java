package es.sergiomartinez.basecleanarchitecture.data.datamodel.response;

import com.google.gson.annotations.Expose;
import es.sergiomartinez.basecleanarchitecture.data.datamodel.entities.ApiResult;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class GetUsersResponse {

  @Expose
  private List<ApiResult> results = new ArrayList<>();

  public List<ApiResult> getResults() {
    return results;
  }

  public void setResults(List<ApiResult> results) {
    this.results = results;
  }

}
