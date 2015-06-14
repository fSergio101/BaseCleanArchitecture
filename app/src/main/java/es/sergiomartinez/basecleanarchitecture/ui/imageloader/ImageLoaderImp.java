package es.sergiomartinez.basecleanarchitecture.ui.imageloader;

import android.widget.ImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import es.sergiomartinez.basecleanarchitecture.R;

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
