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

package es.sergiomartinez.basecleanarchitecture.modules.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import es.sergiomartinez.basecleanarchitecture.R;
import es.sergiomartinez.basecleanarchitecture.base.BaseUIActivity;
import es.sergiomartinez.basecleanarchitecture.presentation.detail.UserDetailPresenter;
import es.sergiomartinez.basecleanarchitecture.presentation.detail.UserDetailView;
import es.sergiomartinez.basecleanarchitecture.ui.imageloader.ImageLoader;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class UserDetailActivity extends BaseUIActivity implements UserDetailView {

  @Inject UserDetailPresenter userDetailPresenter;
  @Inject ImageLoader imageLoader;

  @InjectView(R.id.toolbar) Toolbar toolbar;
  @InjectView(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbar;
  @InjectView(R.id.backdrop) ImageView backdrop;
  @InjectView(R.id.phone) TextView phone;
  @InjectView(R.id.email) TextView email;
  @InjectView(R.id.location) TextView location;

  public static final String EXTRA_NAME = "name";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    loadUserDetail();
    setupActionBar();
    setupCollapsingBar();
    loadBackdrop();
  }

  private void loadUserDetail() {
    Intent intent = getIntent();
    if (intent.hasExtra(EXTRA_NAME)){
      userDetailPresenter.loadUser(intent.getStringExtra(EXTRA_NAME));
    }
    phone.setText(userDetailPresenter.getUserPhone());
    email.setText(userDetailPresenter.getUserEmail());
    location.setText(userDetailPresenter.getUserLocation());
  }

  private void setupCollapsingBar() {
    collapsingToolbar.setTitle(userDetailPresenter.getUserName());
  }

  private void setupActionBar() {
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        finish();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void loadBackdrop() {
    imageLoader.load(userDetailPresenter.getThumblUrl(), backdrop, null);
    imageLoader.load(userDetailPresenter.getUserPicUrl(), backdrop, null);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.sample_actions, menu);
    return true;
  }

  @Override protected List<Object> getModules() {
    return Arrays.<Object>asList(new UserDetailModule(this));
  }


}
