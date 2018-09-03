package marine.josep.rxjavaexamples.dagger;

import dagger.Module;
import dagger.Provides;
import marine.josep.rxjavaexamples.model.dataprovider.Option1DataProvider;
import marine.josep.rxjavaexamples.model.dataprovider.impl.Option1DataProviderImpl;

@Module
public class DataProviderModule {

  @Provides
  static Option1DataProvider provideOption1DataProvider() {
    return new Option1DataProviderImpl();
  }

}
