package es.sergiomartinez.basecleanarchitecture.domain.entities;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class Picture {

  public String large;
  public String medium;
  public String thumbnail;

  public String getLarge() {
    return large;
  }

  public void setLarge(String large) {
    this.large = large;
  }

  public String getMedium() {
    return medium;
  }

  public void setMedium(String medium) {
    this.medium = medium;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }
}
