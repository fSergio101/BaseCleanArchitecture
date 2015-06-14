package es.sergiomartinez.basecleanarchitecture.domain.entities;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class Name {

  public String title;
  public String first;
  public String last;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public String getLast() {
    return last;
  }

  public void setLast(String last) {
    this.last = last;
  }
}
