package marine.josep.rxjavaexamples.model.dataprovider.impl;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import marine.josep.rxjavaexamples.model.Option1Model;
import marine.josep.rxjavaexamples.model.dataprovider.Option1DataProvider;

public class Option1DataProviderImpl implements Option1DataProvider {

  @Override
  public Observable<Option1Model> loadOption1Data() {

    Observable<Option1Model>  observable =  Observable.create(new ObservableOnSubscribe<Option1Model>() {

      @Override
      public void subscribe(ObservableEmitter<Option1Model> emitter) throws Exception {
        emitter.onNext(new Option1Model());
      }
    });

    observable.subscribeOn(Schedulers.io());
    observable.observeOn(AndroidSchedulers.mainThread());
    return observable;

  }


}
