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

package es.sergiomartinez.basecleanarchitecture.data.datamodel.entities;

import com.google.gson.annotations.Expose;
import com.mobandme.android.transformer.compiler.Mappable;
import com.mobandme.android.transformer.compiler.Mapped;
import es.sergiomartinez.basecleanarchitecture.domain.entities.User;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
@Mappable( with = User.class )
public class ApiUser {

  @Expose @Mapped
  public String gender;
  @Expose @Mapped
  public ApiName name;
  @Expose @Mapped
  public ApiLocation location;
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
  public ApiPicture picture;
  @Expose @Mapped
  public String nationality;

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public ApiName getName() {
    return name;
  }

  public void setName(ApiName name) {
    this.name = name;
  }

  public ApiLocation getLocation() {
    return location;
  }

  public void setLocation(ApiLocation location) {
    this.location = location;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getSha256() {
    return sha256;
  }

  public void setSha256(String sha256) {
    this.sha256 = sha256;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCell() {
    return cell;
  }

  public void setCell(String cell) {
    this.cell = cell;
  }

  public ApiPicture getPicture() {
    return picture;
  }

  public void setPicture(ApiPicture picture) {
    this.picture = picture;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }
}
