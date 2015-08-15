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

package es.sergiomartinez.basecleanarchitecture.repository.users;

import es.sergiomartinez.basecleanarchitecture.domain.entities.User;
import es.sergiomartinez.basecleanarchitecture.domain.repository.UsersRepository;
import es.sergiomartinez.basecleanarchitecture.repository.datasources.users.UsersFileDataSource;
import es.sergiomartinez.basecleanarchitecture.repository.datasources.users.UsersNetworkDataSource;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class UsersRepositoryImp implements UsersRepository {

  final UsersNetworkDataSource usersNetworkDataSource;
  final UsersFileDataSource usersFileDataSource;

  public UsersRepositoryImp(UsersNetworkDataSource usersNetworkDataSource,
      UsersFileDataSource usersFileDataSource) {
    this.usersFileDataSource = usersFileDataSource;
    this.usersNetworkDataSource = usersNetworkDataSource;
  }

  @Override public List<User> getUsers() throws Exception {

    try{
      return usersNetworkDataSource.getUsers();
    }catch (Exception e){
      if (usersFileDataSource != null){
        return usersFileDataSource.getUsers();
      }else{
        throw e;
      }
    }
  }

}
