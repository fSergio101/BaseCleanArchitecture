/*
 *
 *  Copyright (C) 2015 Sergio Martinez Open Source Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

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
