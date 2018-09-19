package marine.josep.rxjavaexamples.presenter;


import marine.josep.rxjavaexamples.view.model.PeopleResultModel;

public interface Option1Presenter {

  void setView(Option1Presenter.View view);

  void loadData();

  interface View {
    void onLoadData(PeopleResultModel peopleResultModel);

    void showProgress();

    void hideProgress();
  }
}
