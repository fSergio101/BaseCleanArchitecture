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

package es.sergiomartinez.basecleanarchitecture.modules.home;

import com.mobandme.android.transformer.Transformer;
import dagger.Module;
import dagger.Provides;
import es.sergiomartinez.basecleanarchitecture.data.datamodel.entities.ApiUser;
import es.sergiomartinez.basecleanarchitecture.domain.abstractions.Bus;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.InteractorInvoker;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.users.GetUsersInteractor;
import es.sergiomartinez.basecleanarchitecture.presentation.home.HomeUserListPresenter;
import es.sergiomartinez.basecleanarchitecture.presentation.home.UserListView;
import es.sergiomartinez.basecleanarchitecture.presentation.model.PresentationUser;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
@Module
public class UserListModule {

  UserListView userListView;

  public UserListModule(UserListView userListView) {
    this.userListView = userListView;
  }

  @Provides @Singleton @Named("PresentationUserTransformer")
  Transformer providePresentationUserTransformer() {
    return new Transformer.Builder().build(PresentationUser.class);
  }

  @Provides @Singleton HomeUserListPresenter provideUserDetailPresenter(Bus bus,
      InteractorInvoker interactorInvoker, GetUsersInteractor getUsersInteractor,
      @Named("PresentationUserTransformer") Transformer userTransformer){
    return new HomeUserListPresenter(bus, interactorInvoker, getUsersInteractor, userTransformer, userListView);
  }
}
