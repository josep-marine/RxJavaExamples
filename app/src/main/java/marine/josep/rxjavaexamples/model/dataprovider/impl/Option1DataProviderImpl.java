package marine.josep.rxjavaexamples.model.dataprovider.impl;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import marine.josep.rxjavaexamples.model.ApiOption1Model;
import marine.josep.rxjavaexamples.model.Option1Model;
import marine.josep.rxjavaexamples.model.dataprovider.Option1DataProvider;

public class Option1DataProviderImpl implements Option1DataProvider {

  @Override
  public Observable<Option1Model> loadOption1Data() {

    return Observable.create(new ObservableOnSubscribe<ApiOption1Model>() {

      @Override
      public void subscribe(ObservableEmitter<ApiOption1Model> emitter) throws Exception {

        try {

          ApiOption1Model apiOption1Model = new ApiOption1Model();
          apiOption1Model.setRawData("data");
          Thread.sleep(5000);

          emitter.onNext(apiOption1Model);

        } catch (Exception e) {
          emitter.onError(e);
        } finally {
          emitter.onComplete();
        }
      }

    }).filter(new Predicate<ApiOption1Model>() {

      @Override
      public boolean test(ApiOption1Model apiOption1Model) throws Exception {

        if(apiOption1Model.getRawData()!=null && apiOption1Model.getRawData().equalsIgnoreCase("data")){
          return true;
        }
        return false;
      }
    }).map(new Function<ApiOption1Model, Option1Model>() {

      @Override
      public Option1Model apply(ApiOption1Model apiOption1Model) throws Exception {

        Option1Model option1Model = new Option1Model();
        option1Model.setData(apiOption1Model.getRawData());

        return option1Model;
      }
      
    });

  }

}
