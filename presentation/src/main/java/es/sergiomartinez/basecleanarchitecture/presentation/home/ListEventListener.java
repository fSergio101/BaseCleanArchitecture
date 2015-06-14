package es.sergiomartinez.basecleanarchitecture.presentation.home;

import es.sergiomartinez.basecleanarchitecture.presentation.model.PresentationUser;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public interface ListEventListener {
  void addUsers(List<PresentationUser> userList);
}
