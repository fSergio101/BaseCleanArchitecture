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
@Module(includes = ApiModule.class,
    complete = false,
    library = true)
public class RepositoryModule {

  // region Repositories

  @Provides @Singleton UsersRepository provideUsersRepository(
      UsersNetworkDataSource usersNetworkDataSource, UsersFileDataSource usersFileDataSource) {
      return new UsersRepositoryImp(usersNetworkDataSource, usersFileDataSource);
  }

  // endregion
}
