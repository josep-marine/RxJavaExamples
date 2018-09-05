package marine.josep.rxjavaexamples.dataprovider.impl;


import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import marine.josep.rxjavaexamples.dataprovider.model.ApiOption1Model;
import marine.josep.rxjavaexamples.util.RequestManager;
import marine.josep.rxjavaexamples.view.model.Option1Model;
import marine.josep.rxjavaexamples.dataprovider.Option1DataProvider;

public class Option1DataProviderImpl implements Option1DataProvider {

  private RequestManager requestManager;

  public Option1DataProviderImpl(RequestManager requestManager) {
    this.requestManager = requestManager;
  }

  @Override
  public Observable<Option1Model> loadOption1Data() {

    return Observable.create(new ObservableOnSubscribe<ApiOption1Model>() {

      @Override
      public void subscribe(final ObservableEmitter<ApiOption1Model> emitter) throws Exception {

        try {

          String url ="https://jsonplaceholder.typicode.com/posts";

          StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                  new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                      Log.e("Test:", response);

                      ApiOption1Model apiOption1Model = new ApiOption1Model();
                      apiOption1Model.setRawData("data");

                      emitter.onNext(apiOption1Model);

                    }
                  },
                  new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                      Log.e("Test:", error.toString());

                    }
                  });

          requestManager.add(stringRequest);

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
