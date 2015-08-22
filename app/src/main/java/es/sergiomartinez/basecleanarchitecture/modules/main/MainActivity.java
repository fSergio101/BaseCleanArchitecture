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

package es.sergiomartinez.basecleanarchitecture.modules.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import butterknife.InjectView;
import es.sergiomartinez.basecleanarchitecture.R;
import es.sergiomartinez.basecleanarchitecture.base.BaseUIActivity;
import es.sergiomartinez.basecleanarchitecture.di.ActivityModule;
import es.sergiomartinez.basecleanarchitecture.modules.home.HomeUserListFragment;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class MainActivity extends BaseUIActivity<MainActivityComponent> {

  @InjectView(R.id.toolbar) Toolbar toolbar;
  @InjectView(R.id.drawer_layout) DrawerLayout drawerLayout;
  @InjectView(R.id.nav_view) NavigationView navigationView;
  @InjectView(R.id.fab) FloatingActionButton fab;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.setContentView(R.layout.activity_main);

    setupActionBar();
    setupNavigationView();
    setupFabButton();
    setupHomeFragment();

  }

  @Override protected void initDI() {
    activityComponent = DaggerMainActivityComponent.builder().appComponent(getAppComponent())
        .activityModule(new ActivityModule(this))
        .mainActivityModule(new MainActivityModule(this)).build();
    activityComponent.injectActivity(this);
  }

  private void setupHomeFragment() {
    HomeUserListFragment homeUserListFragment = new HomeUserListFragment();
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.contentFrame, homeUserListFragment).commit();
  }

  private void setupFabButton() {
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        //TODO
      }
    });
    fab.setVisibility(View.GONE);
  }

  private void setupNavigationView() {
    if (navigationView != null) {
      navigationView.setNavigationItemSelectedListener(
          new NavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(MenuItem menuItem) {
              menuItem.setChecked(true);
              drawerLayout.closeDrawers();
              return true;
            }
          });
    }
  }

  private void setupActionBar() {
    setSupportActionBar(toolbar);

    final ActionBar ab = getSupportActionBar();
    ab.setHomeAsUpIndicator(R.drawable.ic_menu);
    ab.setDisplayHomeAsUpEnabled(true);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        drawerLayout.openDrawer(GravityCompat.START);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.sample_actions, menu);
    return true;
  }

  private void setupDrawerContent(NavigationView navigationView) {
    navigationView.setNavigationItemSelectedListener(
        new NavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(MenuItem menuItem) {
            menuItem.setChecked(true);
            drawerLayout.closeDrawers();
            return true;
          }
        });
  }
}
