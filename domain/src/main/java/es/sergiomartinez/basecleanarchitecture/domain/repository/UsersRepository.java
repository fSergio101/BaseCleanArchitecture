package es.sergiomartinez.basecleanarchitecture.domain.repository;

import es.sergiomartinez.basecleanarchitecture.domain.entities.User;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public interface UsersRepository {
  List<User> getUsers() throws Exception;
}
