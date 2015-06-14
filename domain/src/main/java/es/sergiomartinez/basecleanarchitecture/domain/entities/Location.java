package es.sergiomartinez.basecleanarchitecture.domain.entities;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class Location {

  public String street;
  public String county;
  public String state;
  public String zip;

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }
}
