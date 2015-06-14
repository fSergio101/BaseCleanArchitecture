package es.sergiomartinez.basecleanarchitecture.data.repository.network.randomusersapi.datasources;

import com.mobandme.android.transformer.Transformer;
import es.sergiomartinez.basecleanarchitecture.data.datamodel.entities.ApiResult;
import es.sergiomartinez.basecleanarchitecture.data.datamodel.response.GetUsersResponse;
import es.sergiomartinez.basecleanarchitecture.data.repository.network.randomusersapi.RandomUsersApiService;
import es.sergiomartinez.basecleanarchitecture.domain.entities.User;
import es.sergiomartinez.basecleanarchitecture.repository.datasources.users.UsersNetworkDataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class UsersNetworkDataSourceImp implements UsersNetworkDataSource {
  private static final String TAG = UsersNetworkDataSourceImp.class.getSimpleName();

  private final Transformer userTransformer;
  private final RandomUsersApiService randomUsersApiService;

  public UsersNetworkDataSourceImp(RandomUsersApiService randomUsersApiService,
      Transformer userTransformer) {
    this.userTransformer = userTransformer;
    this.randomUsersApiService = randomUsersApiService;
  }

  @Override public List<User> getUsers() throws Exception{

    GetUsersResponse getUsersResponse = randomUsersApiService.getUserList(20);

    List<ApiResult> results = getUsersResponse.getResults();

    List<User> userList = new ArrayList<>();

    for (ApiResult result:results){
      userList.add(userTransformer.transform(result.getUser(), User.class));
    }

    return userList;
  }

}
