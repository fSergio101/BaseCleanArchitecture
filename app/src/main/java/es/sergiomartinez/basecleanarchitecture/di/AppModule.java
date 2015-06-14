package es.sergiomartinez.basecleanarchitecture.di;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import es.sergiomartinez.basecleanarchitecture.App;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
@Module(
    library = true,
    injects = {
        App.class
    },
    includes = {
        InteractorsModule.class, DataModule.class
    }) public class AppModule {

  private App app;

  public AppModule(App app) {
    this.app = app;
  }

  @Provides @Singleton public Application provideApplication() {
    return app;
  }

  @Provides @Singleton @Named("applicationContext") public Context provideAapplicationContext() {
    return app.getApplicationContext();
  }
}