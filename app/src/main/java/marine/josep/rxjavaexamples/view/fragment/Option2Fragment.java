package marine.josep.rxjavaexamples.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import marine.josep.rxjavaexamples.R;
import marine.josep.rxjavaexamples.util.MonthsModel;


public class Option2Fragment extends ExamplesFragment {

  private View view;

  private TextView testText;

  public Option2Fragment() {
    // Required empty public constructor
  }


  public static Option2Fragment newInstance() {
    return new Option2Fragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_option2, container, false);
    bindViews(view);
    loadMonth();
    return view;
  }

  private void bindViews(View view) {
    testText = view.findViewById(R.id.fragment_option2_text_test);
  }

  private void loadMonth(){

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());

    List<MonthsModel> monthsModels = MonthsModel.getMonths(calendar,13);
    StringBuilder testToShow = new StringBuilder();
    for(MonthsModel monthsModel: monthsModels){
      testToShow.append(getString(monthsModel.getDescId()));
      testToShow.append(": ");
      testToShow.append(monthsModel.toString());
      testToShow.append("\n");
    }
    testText.setText(testToShow);
  }

}
