package es.sergiomartinez.basecleanarchitecture.presentation.model;

import com.google.gson.annotations.Expose;
import com.mobandme.android.transformer.compiler.Mappable;
import com.mobandme.android.transformer.compiler.Mapped;
import es.sergiomartinez.basecleanarchitecture.domain.entities.User;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
@Mappable( with = User.class )
public class PresentationUser{

  @Expose @Mapped
  public String gender;
  @Expose @Mapped
  public PresentationName name;
  @Expose @Mapped
  public PresentationLocation location;
  @Expose @Mapped
  public String sha256;
  @Expose @Mapped
  public String email;
  @Expose @Mapped
  public String username;
  @Expose @Mapped
  public String phone;
  @Expose @Mapped
  public String cell;
  @Expose @Mapped
  public PresentationPicture picture;
  @Expose @Mapped
  public String nationality;


}
