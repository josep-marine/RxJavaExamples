package marine.josep.rxjavaexamples.view.fragment;

import android.support.v4.app.Fragment;

import marine.josep.rxjavaexamples.dagger.DaggerExamplesComponent;
import marine.josep.rxjavaexamples.dagger.ExamplesComponent;


public class ExamplesFragment extends Fragment {

  protected static ExamplesComponent examplesSubomponent;

  protected ExamplesComponent getDaggerComponent(){
    if(examplesSubomponent ==null){
      examplesSubomponent = DaggerExamplesComponent.builder().build();
    }
    return examplesSubomponent;
  }


}
