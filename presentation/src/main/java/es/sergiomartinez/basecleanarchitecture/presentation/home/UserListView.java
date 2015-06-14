package es.sergiomartinez.basecleanarchitecture.presentation.home;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public interface UserListView {

  void dismissLoader();
  void showLoader();
  void showEror(Throwable error);

}
