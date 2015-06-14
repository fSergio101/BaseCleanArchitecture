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
