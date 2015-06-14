package es.sergiomartinez.basecleanarchitecture.domain;

import android.os.Handler;
import android.os.Looper;
import de.greenrobot.event.EventBus;
import es.sergiomartinez.basecleanarchitecture.domain.abstractions.Bus;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class BusImp extends EventBus implements Bus {

  private static final Handler handler = new Handler(Looper.getMainLooper());

  @Override public void post(final Object event) {
    handler.post(new Runnable() {
      @Override public void run() {
        BusImp.super.post(event);
      }
    });
  }

  @Override public void postInmediate(final Object event) {
    handler.postAtFrontOfQueue(new Runnable() {
      @Override public void run() {
        BusImp.super.post(event);
      }
    });
  }
}
