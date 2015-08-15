/*
 *
 *  Copyright (C) 2015 Sergio Martinez Open Source Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

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
