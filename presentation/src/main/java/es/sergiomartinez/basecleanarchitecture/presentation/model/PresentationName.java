package es.sergiomartinez.basecleanarchitecture.presentation.model;

import com.google.gson.annotations.Expose;
import com.mobandme.android.transformer.compiler.Mappable;
import com.mobandme.android.transformer.compiler.Mapped;
import es.sergiomartinez.basecleanarchitecture.domain.entities.Name;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
@Mappable(with = Name.class)
public class PresentationName {

  @Expose @Mapped
  public String title;
  @Expose @Mapped
  public String first;
  @Expose @Mapped
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
