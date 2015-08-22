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

package es.sergiomartinez.basecleanarchitecture.ui.imageloader;

import android.widget.ImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import es.sergiomartinez.basecleanarchitecture.R;
import javax.inject.Inject;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public class ImageLoaderImp implements ImageLoader {

  private static final int placeholder = R.drawable.user;

  private Picasso picasso;

  public ImageLoaderImp(Picasso picasso) {
    this.picasso = picasso;
  }

  @Override
  public void load(String url, ImageView imageView, final ImageLoaderListener imageLoaderListener) {
    picasso.load(url).placeholder(placeholder).into(imageView, new Callback() {
      @Override public void onSuccess() {
        if (imageLoaderListener != null){
          imageLoaderListener.onImageLoadedSuccess();
        }
      }
      @Override public void onError() {
        imageLoaderListener.onImageLoadedFail();
      }
    });
  }

  @Override
  public void loadCircleImage(String url, ImageView imageView, final ImageLoaderListener imageLoaderListener) {
    picasso.load(url).placeholder(placeholder).transform(new CircleTransform()).into(imageView, new Callback() {
      @Override public void onSuccess() {
        if (imageLoaderListener != null){
          imageLoaderListener.onImageLoadedSuccess();
        }
      }
      @Override public void onError() {
        imageLoaderListener.onImageLoadedFail();
      }
    });
  }
}
