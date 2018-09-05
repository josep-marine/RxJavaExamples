package marine.josep.rxjavaexamples.dagger;

import dagger.Module;
import dagger.Provides;
import marine.josep.rxjavaexamples.util.RequestManager;

/**
 * Created by T15804 on 05/09/2018.
 */

@Module
public class UtilModule {

  @Provides
  static RequestManager provideRequestManager() {
    return new RequestManager();
  }
}
