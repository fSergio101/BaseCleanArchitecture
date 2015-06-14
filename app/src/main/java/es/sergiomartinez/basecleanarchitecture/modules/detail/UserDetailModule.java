package es.sergiomartinez.basecleanarchitecture.modules.detail;

import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import es.sergiomartinez.basecleanarchitecture.presentation.detail.UserDetailPresenter;
import es.sergiomartinez.basecleanarchitecture.presentation.detail.UserDetailView;
import javax.inject.Singleton;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
@Module(
    library = false,
    complete = false,
    injects = { UserDetailActivity.class })
public class UserDetailModule {

  UserDetailView userDetailView;

  public UserDetailModule(UserDetailView userDetailView) {
    this.userDetailView = userDetailView;
  }

  @Provides @Singleton UserDetailPresenter provideUserDetailPresenter(Gson gson){
   return new UserDetailPresenter(userDetailView, gson);
  }

}
