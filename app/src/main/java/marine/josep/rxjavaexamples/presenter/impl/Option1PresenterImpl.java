package marine.josep.rxjavaexamples.presenter.impl;

import marine.josep.rxjavaexamples.model.dataprovider.Option1DataProvider;
import marine.josep.rxjavaexamples.presenter.Option1Presenter;

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
      view.showProgress();
      dataProvider.loadOption1Data();
      //TODO
    }
  }

}
