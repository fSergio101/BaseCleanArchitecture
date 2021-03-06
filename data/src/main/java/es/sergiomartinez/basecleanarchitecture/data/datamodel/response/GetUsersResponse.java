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

package es.sergiomartinez.basecleanarchitecture.data.datamodel.response;

import com.google.gson.annotations.Expose;
import es.sergiomartinez.basecleanarchitecture.data.datamodel.entities.ApiResult;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class GetUsersResponse {

  @Expose
  private List<ApiResult> results = new ArrayList<>();

  public List<ApiResult> getResults() {
    return results;
  }

  public void setResults(List<ApiResult> results) {
    this.results = results;
  }

}
