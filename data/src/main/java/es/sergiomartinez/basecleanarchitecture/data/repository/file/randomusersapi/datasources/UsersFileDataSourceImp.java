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

package es.sergiomartinez.basecleanarchitecture.data.repository.file.randomusersapi.datasources;

import android.content.Context;
import com.google.gson.Gson;
import com.mobandme.android.transformer.Transformer;
import es.sergiomartinez.basecleanarchitecture.data.datamodel.entities.ApiResult;
import es.sergiomartinez.basecleanarchitecture.data.datamodel.response.GetUsersResponse;
import es.sergiomartinez.basecleanarchitecture.data.repository.file.utils.ReadFileUtils;
import es.sergiomartinez.basecleanarchitecture.domain.entities.User;
import es.sergiomartinez.basecleanarchitecture.repository.datasources.users.UsersFileDataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class UsersFileDataSourceImp implements UsersFileDataSource {
  private static final String TAG = UsersFileDataSourceImp.class.getSimpleName();

  private final static String MOCK_USERS = "mocks/users.json";
  private final static String MOCK_USER = "mocks/user.json";

  private Transformer userTransformer;
  private Context context;
  private Gson gson;

  public UsersFileDataSourceImp(Transformer userTransformer, Context context, Gson gson) {
    this.userTransformer = userTransformer;
    this.context = context;
    this.gson = gson;
  }

  @Override public List<User> getUsers(){

    String jsonString = ReadFileUtils.readDataFromAssets(MOCK_USERS, context);
    GetUsersResponse getUsersResponse = gson.fromJson(jsonString, GetUsersResponse.class);

    List<ApiResult> results = getUsersResponse.getResults();

    List<User> userList = new ArrayList<>();

    for (ApiResult result:results){
      userList.add(userTransformer.transform(result.getUser(), User.class));
    }

    return userList;
  }

}
