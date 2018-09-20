package marine.josep.rxjavaexamples.view.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import marine.josep.rxjavaexamples.R;
import marine.josep.rxjavaexamples.util.MonthPickerAdapter;
import marine.josep.rxjavaexamples.util.MonthPickerViewHolder;
import marine.josep.rxjavaexamples.util.MonthsModel;
import marine.josep.rxjavaexamples.util.ScreenUtils;
import marine.josep.rxjavaexamples.util.SwipeTouchListener;


public class Option2Fragment extends ExamplesFragment {

  private View view;
  private RecyclerView monthPickerRecyclerView;
  private MonthPickerAdapter monthPickerAdapter;
  private List<MonthsModel> monthsModels = new ArrayList<>();
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

  private void setupGraphicLayer(){
    graphicLayout.setOnTouchListener(new SwipeTouchListener(new SwipeTouchListener.LeftRightListener() {
      @Override
      public void onSwipe(int direction) {
        int actualPosition = monthPickerAdapter.getSelectedPosition();
        if(direction == SwipeTouchListener.TO_LEFT){

          Log.d("TEST ", "TO_LEFT");

          if(actualPosition<monthsModels.size()){
            monthPickerRecyclerView.getLayoutManager().smoothScrollToPosition(monthPickerRecyclerView,null,++actualPosition);
          }
        }else if(direction == SwipeTouchListener.TO_RIGHT){

          Log.d("TEST ", "TO_RIGHT");

          if(actualPosition>0){
            monthPickerRecyclerView.getLayoutManager().smoothScrollToPosition(monthPickerRecyclerView,null,--actualPosition);
          }
        }
      }
    }));
  }

  private void setupMonthsPicker() {

    final Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());

    monthsModels = MonthsModel.getMonths(calendar, 13);

    monthPickerAdapter = new MonthPickerAdapter(getContext(), monthsModels, new MonthPickerAdapter.MonthPickerClickListener() {
      @Override
      public void onClick(View itemView) {
        int position = monthPickerRecyclerView.getChildLayoutPosition(itemView);
        monthPickerRecyclerView.smoothScrollToPosition(position);
      }
    });

    monthPickerRecyclerView.setAdapter(monthPickerAdapter);
    monthPickerRecyclerView.setHasFixedSize(true);
    monthPickerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

    //Snapper
    LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
    linearSnapHelper.attachToRecyclerView(monthPickerRecyclerView);

    //Padding
    DisplayMetrics displayMetrics = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    int width = displayMetrics.widthPixels;
    Resources r = getResources();
    float px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            40,
            r.getDisplayMetrics());

    int padding = width / 2 - Math.round(px);
    monthPickerRecyclerView.setPadding(padding, 0, padding, 0);

    //Selecter
    monthPickerRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override
      public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        if (newState == (RecyclerView.SCROLL_STATE_IDLE)) {

          int position = -1;

          for (int i = 0; i < recyclerView.getChildCount(); i++) {
            View child = recyclerView.getChildAt(i);
            if (ScreenUtils.viewIsCentered(recyclerView, child)) {
              position = recyclerView.getChildLayoutPosition(child);
              ((MonthPickerViewHolder) recyclerView.getChildViewHolder(child)).isCentered(true,position);
            }else{
              ((MonthPickerViewHolder) recyclerView.getChildViewHolder(child)).isCentered(false,position);
            }
          }

          if (position != -1) {
            graphicLayoutText.setText((getString(monthsModels.get(position).getDescId()) + "\n" + monthsModels.get(position).toString()));
          }
        }
      }

    });

  }

}
