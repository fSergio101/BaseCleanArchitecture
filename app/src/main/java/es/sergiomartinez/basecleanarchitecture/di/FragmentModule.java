package es.sergiomartinez.basecleanarchitecture.di;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module(library = true, complete = true)
public class FragmentModule {

  private Context context;

  public FragmentModule(Context context) {
    this.context = context;
  }

  @Named("FragmentActivityContext") @Provides Context provideFragmentActivityContext() {
    return context;
  }
}
