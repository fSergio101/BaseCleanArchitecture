package es.sergiomartinez.basecleanarchitecture.domain.abstractions;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 14/6/15.
 */
public interface Bus {
  void post(Object object);

  void postInmediate(Object object);

  void register(Object object);

  void unregister(Object object);
}
