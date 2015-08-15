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
import es.sergiomartinez.basecleanarchitecture.domain.entities.Location;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
@Mappable( with = Location.class )
public class PresentationLocation {

  @Expose @Mapped
  public String street;
  @Expose @Mapped
  public String county;
  @Expose @Mapped
  public String state;
  @Expose @Mapped
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
