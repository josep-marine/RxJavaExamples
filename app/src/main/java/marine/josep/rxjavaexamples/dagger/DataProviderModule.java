package marine.josep.rxjavaexamples.dagger;

import dagger.Module;
import dagger.Provides;
import marine.josep.rxjavaexamples.dataprovider.Option1DataProvider;
import marine.josep.rxjavaexamples.dataprovider.impl.Option1DataProviderImpl;
import marine.josep.rxjavaexamples.util.RequestManager;

@Module
public class DataProviderModule {

  @Provides
  static Option1DataProvider provideOption1DataProvider(RequestManager requestManager) {
    return new Option1DataProviderImpl(requestManager);
  }

}
