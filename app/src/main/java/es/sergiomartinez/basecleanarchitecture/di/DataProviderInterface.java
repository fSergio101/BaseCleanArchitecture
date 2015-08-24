package es.sergiomartinez.basecleanarchitecture.di;

import es.sergiomartinez.basecleanarchitecture.domain.abstractions.Bus;
import es.sergiomartinez.basecleanarchitecture.domain.inteactors.InteractorInvoker;
import es.sergiomartinez.basecleanarchitecture.ui.imageloader.ImageLoader;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 24/8/15.
 */
public interface DataProviderInterface {
  InteractorInvoker provideInteractorInvoker();
  Bus provideEventbus();
  ImageLoader provideImageLoader();
}
