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
      case MotionEvent.ACTION_MOVE:
        sendXMovement(Math.round(x1 - motionEvent.getX()));
        x1 = motionEvent.getX();
        return true;
      case MotionEvent.ACTION_UP:
        finishMovement();
        return true;

    }
    return false;
  }

  private void sendXMovement(int distance) {
    monthPickerRecyclerView.moveScroll(distance);
  }

  private void finishMovement() {
    monthPickerRecyclerView.finishMovement();
  }

  private void toLeft() {
    int actualPosition = monthPickerAdapter.getSelectedPosition();
    if (actualPosition < monthPickerAdapter.getItemCount()) {
      monthPickerRecyclerView.moveToMonth(++actualPosition);
    }
  }

  private void toRight() {
    int actualPosition = monthPickerAdapter.getSelectedPosition();
    if (actualPosition > 0) {
      monthPickerRecyclerView.moveToMonth(--actualPosition);
    }
  }

}
