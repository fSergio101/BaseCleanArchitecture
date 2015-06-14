package es.sergiomartinez.basecleanarchitecture.di;

import dagger.Module;
import dagger.Provides;
import es.sergiomartinez.basecleanarchitecture.domain.abstractions.Bus;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.users.GetUsersInteractor;
import es.sergiomartinez.basecleanarchitecture.domain.repository.UsersRepository;
import javax.inject.Singleton;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
@Module(
    complete = false,
    library = true, includes = RepositoryModule.class) public class InteractorsModule {

  @Provides @Singleton GetUsersInteractor provideGetUserInteractor(Bus bus,
      UsersRepository repository) {
    return new GetUsersInteractor(bus, repository);
  }

}
