package es.sergiomartinez.basecleanarchitecture.domain.inteactors.users;

import es.sergiomartinez.basecleanarchitecture.domain.abstractions.Bus;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.Interactor;
import es.sergiomartinez.basecleanarchitecture.domain.repository.UsersRepository;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class GetUsersInteractor implements Interactor {

  private final Bus bus;
  private final UsersRepository usersRepository;

  public GetUsersInteractor(Bus bus, UsersRepository usersRepository) {
    this.bus = bus;
    this.usersRepository = usersRepository;
  }

  @Override public void execute() throws Throwable {
    GetUsersEvent event = new GetUsersEvent();
    try {
      event.setUserList(usersRepository.getUsers());
    } catch (Exception e) {
      event.setError(e);
    }
    bus.post(event);
  }

}
