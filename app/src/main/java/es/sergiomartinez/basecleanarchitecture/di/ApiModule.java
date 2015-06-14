package es.sergiomartinez.basecleanarchitecture.di;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobandme.android.transformer.Transformer;
import dagger.Module;
import dagger.Provides;
import es.sergiomartinez.basecleanarchitecture.BuildConfig;
import es.sergiomartinez.basecleanarchitecture.anotations.RetrofitLog;
import es.sergiomartinez.basecleanarchitecture.data.repository.file.randomusersapi.datasources.UsersFileDataSourceImp;
import es.sergiomartinez.basecleanarchitecture.data.repository.network.randomusersapi.RandomUsersApiErrorHandler;
import es.sergiomartinez.basecleanarchitecture.data.repository.network.randomusersapi.RandomUsersApiRequestInterceptor;
import es.sergiomartinez.basecleanarchitecture.data.repository.network.randomusersapi.RandomUsersApiService;
import es.sergiomartinez.basecleanarchitecture.data.repository.network.randomusersapi.datasources.UsersNetworkDataSourceImp;
import es.sergiomartinez.basecleanarchitecture.repository.datasources.users.UsersFileDataSource;
import es.sergiomartinez.basecleanarchitecture.repository.datasources.users.UsersNetworkDataSource;
import javax.inject.Named;
import javax.inject.Singleton;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
@Module(
    includes = ApiTransformersModule.class,
    complete = false,
    library = true)
public class ApiModule {

  // region common

  @Provides @Singleton Gson newGson() {
    return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
  }

  @Provides @Singleton GsonConverter newGsonConverter(Gson gson) {
    return new GsonConverter(gson);
  }

  // endregion

  // region RandomUsers api

  @Named("RandomUsersApiService")
  @Provides @Singleton RandomUsersApiService provideRandomUsersApiService(
      @Named("RandomUsersApiEndpoint") Endpoint endPoint, @RetrofitLog boolean logTraces,
      RandomUsersApiRequestInterceptor randomUsersApiRequestInterceptor, GsonConverter gsonConverter,
      RandomUsersApiErrorHandler randomUsersApiErrorHandler) {

    return new RestAdapter.Builder().setEndpoint(endPoint)
        .setLogLevel(logTraces ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
        .setConverter(gsonConverter)
        .setClient(new OkClient())
        .setErrorHandler(randomUsersApiErrorHandler)
        .setRequestInterceptor(randomUsersApiRequestInterceptor).build().create(
            RandomUsersApiService.class);

  }

  @Provides @Singleton RandomUsersApiErrorHandler provideRandomUsersApiErrorHandler(Gson gson, @Named("applicationContext")
  Context context) {
    return new RandomUsersApiErrorHandler(context);
  }

  @Provides @Singleton UsersNetworkDataSource provideUsersNetworkDataSource(
      @Named("RandomUsersApiService") RandomUsersApiService randomUsersApiService,
      @Named("ApiUserTransformer") Transformer userTransformer) {
    return new UsersNetworkDataSourceImp(randomUsersApiService, userTransformer);
  }

  @Provides @Singleton UsersFileDataSource provideUsersFileDataSource(
      @Named("ApiUserTransformer") Transformer userTransformer,
      @Named("applicationContext") Context context, Gson gson) {

    if (!BuildConfig.LOAD_FROM_FILE) {
      return null;
    }

    return new UsersFileDataSourceImp(userTransformer, context, gson);
  }

 //endregion
}
