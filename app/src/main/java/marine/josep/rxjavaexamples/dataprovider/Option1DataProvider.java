package marine.josep.rxjavaexamples.dataprovider;

import io.reactivex.Observable;
import marine.josep.rxjavaexamples.view.model.Option1Model;

public interface Option1DataProvider {

  Observable<Option1Model> loadOption1Data();

}
