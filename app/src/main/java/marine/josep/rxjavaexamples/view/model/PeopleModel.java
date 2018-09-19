package marine.josep.rxjavaexamples.view.model;

import marine.josep.rxjavaexamples.dataprovider.model.ApiPeopleModel;

public class PeopleModel {

  private String name;
  private String birthYear;
  private String homeworld;

  public static PeopleModel map(ApiPeopleModel apiPeopleModel){
    PeopleModel peopleModel = new PeopleModel();
    peopleModel.setBirthYear(apiPeopleModel.getBirthYear());
    peopleModel.setHomeworld(apiPeopleModel.getHomeworld());
    peopleModel.setName(apiPeopleModel.getName());
    return peopleModel;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public String getHomeworld() {
    return homeworld;
  }

  public void setHomeworld(String homeworld) {
    this.homeworld = homeworld;
  }
}
