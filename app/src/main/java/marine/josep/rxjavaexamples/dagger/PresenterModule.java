package marine.josep.rxjavaexamples.dagger;


import dagger.Module;
import dagger.Provides;
import marine.josep.rxjavaexamples.dataprovider.Option1DataProvider;
import marine.josep.rxjavaexamples.presenter.Option1Presenter;
import marine.josep.rxjavaexamples.presenter.impl.Option1PresenterImpl;

@Module
public class PresenterModule {

  @Provides
  static Option1Presenter provideOption1Presenter(Option1DataProvider option1DataProvider) {
    return new Option1PresenterImpl(option1DataProvider);
  }
}
