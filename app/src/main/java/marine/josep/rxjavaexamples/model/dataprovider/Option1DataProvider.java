package marine.josep.rxjavaexamples.model.dataprovider;

import io.reactivex.Observable;
import marine.josep.rxjavaexamples.model.Option1Model;

public interface Option1DataProvider {

  Observable<Option1Model> loadOption1Data();

}
