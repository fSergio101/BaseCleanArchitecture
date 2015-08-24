package es.sergiomartinez.basecleanarchitecture.di;

import es.sergiomartinez.basecleanarchitecture.domain.repository.UsersRepository;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 25/8/15.
 */
public interface RepositoryProviderInterface {
  UsersRepository provideUsersRepository();
}
