package es.sergiomartinez.basecleanarchitecture.domain.inteactors.users;

import es.sergiomartinez.basecleanarchitecture.domain.entities.User;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.BaseEvent;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class GetUsersEvent extends BaseEvent{

  List<User> userList;

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }
}
