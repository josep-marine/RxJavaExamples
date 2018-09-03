package marine.josep.rxjavaexamples.dagger;


import dagger.Component;
import marine.josep.rxjavaexamples.view.fragment.Option1Fragment;

@Component(modules = {PresenterModule.class, DataProviderModule.class})
public interface ExamplesComponent {

  void inject(Option1Fragment option1Fragment);

}
