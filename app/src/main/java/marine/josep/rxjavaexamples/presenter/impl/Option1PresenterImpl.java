package marine.josep.rxjavaexamples.presenter.impl;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import marine.josep.rxjavaexamples.view.model.PeopleModel;
import marine.josep.rxjavaexamples.dataprovider.Option1DataProvider;
import marine.josep.rxjavaexamples.presenter.Option1Presenter;
import marine.josep.rxjavaexamples.view.model.PeopleResultModel;

public class Option1PresenterImpl implements Option1Presenter {

  private Option1Presenter.View view;

  private Option1DataProvider dataProvider;

  public Option1PresenterImpl(Option1DataProvider dataProvider) {
    this.dataProvider = dataProvider;
  }

  @Override
  public void setView(View view) {
    this.view = view;
  }

  @Override
  public void loadData() {

    if (view != null) {

      dataProvider.loadPeople()
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribeWith(new DisposableObserver<PeopleResultModel>() {

        @Override
        public void onNext(PeopleResultModel peopleResultModel) {
          view.onLoadData(peopleResultModel);
          view.hideProgress();
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
      });
      view.showProgress();
    }
  }

}
