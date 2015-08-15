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
