package marine.josep.rxjavaexamples.dataprovider;

import io.reactivex.Observable;
import marine.josep.rxjavaexamples.view.model.PeopleResultModel;

public interface Option1DataProvider {

  Observable<PeopleResultModel> loadPeople();

}
