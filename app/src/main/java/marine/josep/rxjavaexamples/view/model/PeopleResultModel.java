package marine.josep.rxjavaexamples.view.model;

import java.util.ArrayList;
import java.util.List;

import marine.josep.rxjavaexamples.dataprovider.model.ApiPeopleModel;
import marine.josep.rxjavaexamples.dataprovider.model.ApiPeopleResultModel;

public class PeopleResultModel {

  private Integer count;
  private boolean moreData;
  private List<PeopleModel> results;

  public static PeopleResultModel map(ApiPeopleResultModel apiPeopleResultModel) {
    PeopleResultModel peopleResultModel = new PeopleResultModel();
    peopleResultModel.setCount(apiPeopleResultModel.getCount());
    peopleResultModel.setMoreData(apiPeopleResultModel.getNext() != null);
    List<PeopleModel> result = new ArrayList<>();
    if (apiPeopleResultModel.getResults() != null) {
      for (ApiPeopleModel apiPeopleModel : apiPeopleResultModel.getResults()) {
        result.add(PeopleModel.map(apiPeopleModel));
      }
    }
    peopleResultModel.setResults(result);
    return peopleResultModel;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public boolean isMoreData() {
    return moreData;
  }

  public void setMoreData(boolean moreData) {
    this.moreData = moreData;
  }

  public List<PeopleModel> getResults() {
    return results;
  }

  public void setResults(List<PeopleModel> results) {
    this.results = results;
  }
}
