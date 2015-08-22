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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.InjectView;
import com.google.gson.Gson;
import es.sergiomartinez.basecleanarchitecture.R;
import es.sergiomartinez.basecleanarchitecture.base.BaseUIFragment;
import es.sergiomartinez.basecleanarchitecture.data.error.exceptions.RequestException;
import es.sergiomartinez.basecleanarchitecture.di.FragmentModule;
import es.sergiomartinez.basecleanarchitecture.modules.main.MainActivityComponent;
import es.sergiomartinez.basecleanarchitecture.presentation.home.HomeUserListPresenter;
import es.sergiomartinez.basecleanarchitecture.presentation.home.UserListView;
import es.sergiomartinez.basecleanarchitecture.presentation.model.PresentationUser;
import es.sergiomartinez.basecleanarchitecture.ui.imageloader.ImageLoader;
import java.util.ArrayList;
import javax.inject.Inject;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class HomeUserListFragment extends BaseUIFragment<HomeUserListFragmentComponent> implements UserListView{

  @Inject ImageLoader imageLoader;
  @Inject Gson gson;
  @Inject HomeUserListPresenter homeUserListPresenter;

  @InjectView(R.id.recyclerview) RecyclerView recyclerView;

  @Override protected void initFragmentData(View view, @Nullable Bundle savedInstanceState) {
    if (homeUserListPresenter!=null){
      setupRecyclerView(recyclerView);
      homeUserListPresenter.getUsers();
    }
  }

  private void setupRecyclerView(RecyclerView recyclerView) {
    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    UserListAdapter userListAdapter = new UserListAdapter(getActivity(),
        new ArrayList<PresentationUser>(),imageLoader, gson);
    homeUserListPresenter.setListEventListener(userListAdapter);
    recyclerView.setAdapter(userListAdapter);
  }

  @Override public void dismissLoader() {
    //TODO implement loader
  }

  @Override public void showLoader() {

  }

  @Override public void onResume() {
    super.onResume();
    homeUserListPresenter.onResume();
  }

  @Override public void onPause() {
    super.onPause();
    homeUserListPresenter.onPause();
  }

  //region dependency injection Methods
  @Override protected void initDIComponent() {
    fragmentComponent = (getParentComponent(MainActivityComponent.class)).plus(
        new FragmentModule(getActivity()), new UserListModule(this));
    fragmentComponent.injectFragment(this);
  }

  @Override public int getLayout() {
    return R.layout.fragment_user_list;
  }

  public interface Pluser{
    HomeUserListFragmentComponent plus(FragmentModule secondFragmentModule, UserListModule userListModule);
  }

  @Override public void showEror(Throwable error) {
    if (error instanceof RequestException) {
      Snackbar.make(null,((RequestException) error).getHumanReadableErrorMessage(),
          Snackbar.LENGTH_LONG).show();
    }

  }
}
