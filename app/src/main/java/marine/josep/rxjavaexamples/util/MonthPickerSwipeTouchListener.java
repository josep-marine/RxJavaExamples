package marine.josep.rxjavaexamples.util;

import android.view.MotionEvent;
import android.view.View;

public class MonthPickerSwipeTouchListener implements View.OnTouchListener {

  private float x1 = 0;
  private float x2 = 0;

  private MonthPickerAdapter monthPickerAdapter;
  private MonthPickerRecyclerView monthPickerRecyclerView;

  public MonthPickerSwipeTouchListener(MonthPickerAdapter monthPickerAdapter, MonthPickerRecyclerView monthPickerRecyclerView) {
    this.monthPickerAdapter = monthPickerAdapter;
    this.monthPickerRecyclerView = monthPickerRecyclerView;
  }

  @Override
  public boolean onTouch(View view, MotionEvent motionEvent) {

    switch (motionEvent.getAction()) {
      case MotionEvent.ACTION_DOWN:
        x1 = motionEvent.getX();
        return true;
      case MotionEvent.ACTION_UP:
        x2 = motionEvent.getX();
        if (x1 > x2) {
          toLeft();
        } else if (x2 > x1) {
          toRight();
        }
        return true;
    }
    return false;
  }

  private void toLeft(){
    int actualPosition = monthPickerAdapter.getSelectedPosition();
    if(actualPosition<monthPickerAdapter.getItemCount()){
      monthPickerRecyclerView.moveToMonth(++actualPosition);
    }
  }

  private void toRight(){
    int actualPosition = monthPickerAdapter.getSelectedPosition();
    if(actualPosition>0){
      monthPickerRecyclerView.moveToMonth(--actualPosition);
    }
  }

}
