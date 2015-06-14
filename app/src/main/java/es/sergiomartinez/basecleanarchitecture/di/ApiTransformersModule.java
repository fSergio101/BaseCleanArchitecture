package es.sergiomartinez.basecleanarchitecture.di;

import com.mobandme.android.transformer.Transformer;
import dagger.Module;
import dagger.Provides;
import es.sergiomartinez.basecleanarchitecture.data.datamodel.entities.ApiUser;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 13/6/15.
 */
@Module(
    complete = true,
    library = true)
public class ApiTransformersModule {
  @Provides @Singleton @Named("ApiUserTransformer") Transformer provideApiUserTransformer() {
    return new Transformer.Builder().build(ApiUser.class);
  }
}
