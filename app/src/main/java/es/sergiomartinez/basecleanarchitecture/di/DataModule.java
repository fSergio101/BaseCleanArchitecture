package es.sergiomartinez.basecleanarchitecture.di;

import android.app.Application;
import com.path.android.jobqueue.JobManager;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import es.sergiomartinez.basecleanarchitecture.BuildConfig;
import es.sergiomartinez.basecleanarchitecture.anotations.PicassoLog;
import es.sergiomartinez.basecleanarchitecture.anotations.RetrofitLog;
import es.sergiomartinez.basecleanarchitecture.domain.BusImp;
import es.sergiomartinez.basecleanarchitecture.domain.InteractorInvokerImp;
import es.sergiomartinez.basecleanarchitecture.domain.abstractions.Bus;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.InteractorInvoker;
import es.sergiomartinez.basecleanarchitecture.ui.imageloader.ImageLoader;
import es.sergiomartinez.basecleanarchitecture.ui.imageloader.ImageLoaderImp;
import javax.inject.Named;
import javax.inject.Singleton;
import retrofit.Endpoint;
import retrofit.Endpoints;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
@Module(complete = false, library = true)
public class DataModule {

  @Provides @Singleton @RetrofitLog boolean provideRetrofitLog() {
    return BuildConfig.RETROFIT_LOG;
  }

  @Provides @Singleton @PicassoLog boolean providePiccasoLog() {
    return BuildConfig.PICASSO_LOG;
  }

  @Provides @Singleton @Named("RandomUsersApiEndpoint") Endpoint provideRandomUsersApiEndpoint() {
    return Endpoints.newFixedEndpoint(BuildConfig.API_URL);
  }

  @Provides @Singleton Bus provideEventbus() {
    return new BusImp();
  }

  @Provides @Singleton JobManager provideJobManager(Application app) {
    return new JobManager(app);
  }

  @Provides @Singleton InteractorInvoker provideInteractorInvoker(JobManager jobManager, Bus bus) {
    return new InteractorInvokerImp(jobManager);
  }

  @Provides @Singleton Picasso providePicasso(Application app, @PicassoLog boolean picassoLog) {
    Picasso picasso = Picasso.with(app);
    picasso.setLoggingEnabled(picassoLog);
    return picasso;
  }

  @Provides @Singleton ImageLoader provideImageLoader(Picasso picasso) {
    return new ImageLoaderImp(picasso);
  }

}
