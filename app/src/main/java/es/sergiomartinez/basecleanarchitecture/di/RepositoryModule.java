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

package es.sergiomartinez.basecleanarchitecture.di;

import dagger.Module;
import dagger.Provides;
import es.sergiomartinez.basecleanarchitecture.domain.repository.UsersRepository;
import es.sergiomartinez.basecleanarchitecture.repository.datasources.users.UsersFileDataSource;
import es.sergiomartinez.basecleanarchitecture.repository.datasources.users.UsersNetworkDataSource;
import es.sergiomartinez.basecleanarchitecture.repository.users.UsersRepositoryImp;
import javax.inject.Singleton;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
@Module(includes = ApiModule.class)
public class RepositoryModule {

  // region Repositories

  @Provides @Singleton UsersRepository provideUsersRepository(
      UsersNetworkDataSource usersNetworkDataSource, UsersFileDataSource usersFileDataSource) {
      return new UsersRepositoryImp(usersNetworkDataSource, usersFileDataSource);
  }

  // endregion
}
