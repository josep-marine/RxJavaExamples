package marine.josep.rxjavaexamples.presenter;


import marine.josep.rxjavaexamples.view.model.Option1Model;

public interface Option1Presenter {

  void setView(Option1Presenter.View view);

  void loadData();

  interface View {
    void onLoadData(Option1Model option1Model);

    void showProgress();

    void hideProgress();
  }
}
