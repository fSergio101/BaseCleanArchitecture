package es.sergiomartinez.basecleanarchitecture.ui.imageloader;

import android.widget.ImageView;

public interface ImageLoader {
    void load(String url, ImageView imageView, final ImageLoaderListener imageLoaderListener);
    void loadCircleImage(String url, ImageView imageView, final ImageLoaderListener imageLoaderListener);
}
