package es.sergiomartinez.basecleanarchitecture.presentation.detail;

import com.google.gson.Gson;
import es.sergiomartinez.basecleanarchitecture.presentation.Presenter;
import es.sergiomartinez.basecleanarchitecture.presentation.model.PresentationUser;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class UserDetailPresenter extends Presenter{

  private final UserDetailView userDetailView;
  private final Gson gson;
  private PresentationUser presentationUser;

  public UserDetailPresenter(UserDetailView userDetailView, Gson gson) {
    this.userDetailView = userDetailView;
    this.gson = gson;
  }

  @Override public void onResume() {}

  @Override public void onPause() {}

  public void loadUser(String stringExtra) {
    presentationUser = gson.fromJson(stringExtra, PresentationUser.class);
  }

  public String getUserName() {
    return presentationUser.name.last + ", " + presentationUser.name.first;
  }

  public String getUserPhone() {
    return presentationUser.cell;
  }

  public String getUserEmail() {
    return presentationUser.email;
  }

  public String getUserLocation() {
    return presentationUser.location.street + ", " + presentationUser.location.zip+ ", " + presentationUser.location.county;
  }

  public String getThumblUrl() {
    return presentationUser.picture.getThumbnail();
  }

  public String getUserPicUrl() {
    return presentationUser.picture.getLarge();
  }
}
