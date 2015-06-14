package es.sergiomartinez.basecleanarchitecture;

import android.app.Application;
import dagger.ObjectGraph;
import es.sergiomartinez.basecleanarchitecture.di.AppModule;
import java.util.Arrays;
import java.util.List;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
public class App extends Application{

  private ObjectGraph objectGraph;

  @Override public void onCreate() {
    super.onCreate();
    objectGraph = ObjectGraph.create(getModules().toArray());
    objectGraph.inject(this);
    init();
  }

  private void init() {
    initCalligraphyLib();
  }

  private void initCalligraphyLib() {
    CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
            .setFontAttrId(R.attr.fontPath)
            .build()
    );
  }

  private List<Object> getModules() {
    return Arrays.<Object>asList(new AppModule(this));
  }

  public ObjectGraph getMainGraph() {
    return objectGraph;
  }

  public ObjectGraph addScopedModules(Object... modules) {
    return objectGraph.plus(modules);
  }

}
