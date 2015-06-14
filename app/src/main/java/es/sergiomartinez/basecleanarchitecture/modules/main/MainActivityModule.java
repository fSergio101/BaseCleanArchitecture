package es.sergiomartinez.basecleanarchitecture.modules.main;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
@Module(
    library = true,
    complete = false,
    injects = { MainActivity.class })
public class MainActivityModule {

  private MainActivity activity;

  public MainActivityModule(MainActivity mainActivity) {
   this.activity = mainActivity;
  }

  @Provides @Singleton MainActivity provideMainActivity(){
    return activity;
  }
}
