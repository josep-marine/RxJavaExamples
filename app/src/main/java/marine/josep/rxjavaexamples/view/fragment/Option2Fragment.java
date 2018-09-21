package marine.josep.rxjavaexamples.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import marine.josep.rxjavaexamples.R;
import marine.josep.rxjavaexamples.util.MonthPickerAdapter;
import marine.josep.rxjavaexamples.util.MonthPickerModel;
import marine.josep.rxjavaexamples.util.MonthPickerRecyclerView;
import marine.josep.rxjavaexamples.util.MonthPickerSwipeTouchListener;


public class Option2Fragment extends ExamplesFragment {

  private View view;
  private MonthPickerRecyclerView monthPickerRecyclerView;
  private MonthPickerAdapter monthPickerAdapter;
  private List<MonthPickerModel> monthPickerModels = new ArrayList<>();
  private LinearLayoutCompat graphicLayout;
  private TextView graphicLayoutText;

  //private TextView testText;

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
    setupMonthsPicker();
    setupGraphicLayer();
    return view;
  }

  private void bindViews(View view) {
    monthPickerRecyclerView = view.findViewById(R.id.months_picker);
    graphicLayout = view.findViewById(R.id.months_picker_graphic);
    graphicLayoutText = view.findViewById(R.id.months_picker_graphic_test);
  }

  private void setupGraphicLayer() {
    graphicLayout.setOnTouchListener(new MonthPickerSwipeTouchListener(monthPickerAdapter,monthPickerRecyclerView));
  }

  private void setupMonthsPicker() {

    final Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());

    monthPickerModels = MonthPickerModel.getMonths(calendar, 12);
    monthPickerAdapter = new MonthPickerAdapter(getContext(), monthPickerModels,monthPickerRecyclerView);
    monthPickerRecyclerView.addMonthPickerSelectListener(new MonthPickerRecyclerView.MonthPickerSelectListener() {
      @Override
      public void onMonthSelected(MonthPickerModel monthPickerModel) {
        graphicLayoutText.setText(getString(monthPickerModel.getDescId())+"\n"+monthPickerModel.toString());
      }
    });
    
    monthPickerAdapter.moveToMonth(calendar);

  }

}
