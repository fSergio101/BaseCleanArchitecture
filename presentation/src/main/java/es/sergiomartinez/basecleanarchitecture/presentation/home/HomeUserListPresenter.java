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

package es.sergiomartinez.basecleanarchitecture.presentation.home;

import com.mobandme.android.transformer.Transformer;
import es.sergiomartinez.basecleanarchitecture.domain.abstractions.Bus;
import es.sergiomartinez.basecleanarchitecture.domain.entities.User;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.InteractorInvoker;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.users.GetUsersEvent;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.users.GetUsersInteractor;
import es.sergiomartinez.basecleanarchitecture.presentation.Presenter;
import es.sergiomartinez.basecleanarchitecture.presentation.model.PresentationUser;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class HomeUserListPresenter extends Presenter{

  private final Bus bus;
  private final InteractorInvoker interactorInvoker;
  private final GetUsersInteractor getUsersInteractor;
  private final Transformer userTransformer;
  private final UserListView userListView;
  private ListEventListener listEventListener;

  public HomeUserListPresenter(Bus bus, InteractorInvoker interactorInvoker,
      GetUsersInteractor getUsersInteractor, Transformer userTransformer, UserListView userListView) {
    this.bus = bus;
    this.interactorInvoker = interactorInvoker;
    this.getUsersInteractor = getUsersInteractor;
    this.userTransformer = userTransformer;
    this.userListView = userListView;
  }

  @Override public void onResume() {
    bus.register(this);
  }

  @Override public void onPause() {
    bus.unregister(this);
  }

  public void onEvent(GetUsersEvent getUsersEvent) {
    userListView.dismissLoader();
    if (getUsersEvent.getError() == null) {
      List<PresentationUser> userList = new ArrayList<>();
      for (User user:getUsersEvent.getUserList()){
        userList.add(userTransformer.transform(user, PresentationUser.class));
      }
      listEventListener.addUsers(userList);
    } else {
        userListView.showEror(getUsersEvent.getError());
    }
  }


  public void setListEventListener(ListEventListener listEventListener) {
    this.listEventListener = listEventListener;
  }

  public void getUsers() {
    userListView.showLoader();
    interactorInvoker.execute(getUsersInteractor);
  }
}
