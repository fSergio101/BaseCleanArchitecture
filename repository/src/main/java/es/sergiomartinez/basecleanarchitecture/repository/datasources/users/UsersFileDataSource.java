package es.sergiomartinez.basecleanarchitecture.repository.datasources.users;

import es.sergiomartinez.basecleanarchitecture.domain.entities.User;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public interface UsersFileDataSource {
  List<User> getUsers();
}

