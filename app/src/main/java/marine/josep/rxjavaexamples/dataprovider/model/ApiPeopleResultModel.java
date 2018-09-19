package marine.josep.rxjavaexamples.dataprovider.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiPeopleResultModel {

  @SerializedName("count")
  private Integer count;
  @SerializedName("next")
  private String next;
  @SerializedName("previous")
  private Object previous;
  @SerializedName("results")
  private List<ApiPeopleModel> results;

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }

  public Object getPrevious() {
    return previous;
  }

  public void setPrevious(Object previous) {
    this.previous = previous;
  }

  public List<ApiPeopleModel> getResults() {
    return results;
  }

  public void setResults(List<ApiPeopleModel> results) {
    this.results = results;
  }
}
