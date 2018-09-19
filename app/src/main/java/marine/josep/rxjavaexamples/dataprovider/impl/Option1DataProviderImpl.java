package marine.josep.rxjavaexamples.dataprovider.impl;


import com.android.volley.Request;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import marine.josep.rxjavaexamples.dataprovider.Option1DataProvider;
import marine.josep.rxjavaexamples.dataprovider.model.ApiPeopleResultModel;
import marine.josep.rxjavaexamples.util.RequestManager;
import marine.josep.rxjavaexamples.view.model.PeopleResultModel;

public class Option1DataProviderImpl implements Option1DataProvider {

  private RequestManager requestManager;

  public Option1DataProviderImpl(RequestManager requestManager) {
    this.requestManager = requestManager;
  }

  @Override
  public Observable<PeopleResultModel> loadPeople() {

    return Observable.create(new ObservableOnSubscribe<ApiPeopleResultModel>() {

      @Override
      public void subscribe(ObservableEmitter<ApiPeopleResultModel> emitter) throws Exception {

        try {

          String url = "https://swapi.co/api/people";

          RequestFuture<String> futureRequest = RequestFuture.newFuture();

          StringRequest stringRequest = new StringRequest(Request.Method.GET, url, futureRequest, futureRequest);

          requestManager.add(stringRequest);
          String jsonString = futureRequest.get();

          ApiPeopleResultModel apiPeopleResultModel = new Gson().fromJson(jsonString, ApiPeopleResultModel.class);

          emitter.onNext(apiPeopleResultModel);

        } catch (Exception e) {
          emitter.onError(e);
        } finally {
          emitter.onComplete();
        }
      }

    }).filter(new Predicate<ApiPeopleResultModel>() {

      @Override
      public boolean test(ApiPeopleResultModel apiPeopleResultModel) throws Exception {

        if (true) {
          return true;
        }
        return false;
      }
    }).map(new Function<ApiPeopleResultModel, PeopleResultModel>() {

      @Override
      public PeopleResultModel apply(ApiPeopleResultModel apiPeopleResultModel) throws Exception {
        return PeopleResultModel.map(apiPeopleResultModel);
      }

    });

  }

  private String simpleTransform(JSONObject jsonObject) {
    return "data";
  }

}
