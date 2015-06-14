package es.sergiomartinez.basecleanarchitecture.di;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import dagger.Module;
import dagger.Provides;
import es.sergiomartinez.basecleanarchitecture.base.BaseInjectionActivity;
import es.sergiomartinez.basecleanarchitecture.base.BaseUIActivity;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
@Module(
    complete = false,
    library = true)
public class ActivityModule {

  private BaseUIActivity activity;

  public ActivityModule(BaseInjectionActivity activity) {
    this.activity = (BaseUIActivity) activity;
  }

  @Provides @Singleton @Named("activityContext") Context provideContext() {
    return activity;
  }

  @Provides @Singleton AppCompatActivity provideActivity() {
    return activity;
  }

  @Provides @Singleton FragmentManager provideFragmentManager() {
    return activity.getSupportFragmentManager();
  }

}
