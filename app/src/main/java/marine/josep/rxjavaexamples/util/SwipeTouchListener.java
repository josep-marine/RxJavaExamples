package marine.josep.rxjavaexamples.util;

import android.view.MotionEvent;
import android.view.View;

public class SwipeTouchListener implements View.OnTouchListener {

  public static final int TO_LEFT = 1;
  public static final int TO_RIGHT = 2;
  private float x1 = 0;
  private float x2 = 0;

  private LeftRightListener leftRightListener;

  public SwipeTouchListener(LeftRightListener leftRightListener) {
    this.leftRightListener = leftRightListener;
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
          leftRightListener.onSwipe(TO_LEFT);
        } else if (x2 > x1) {
          leftRightListener.onSwipe(TO_RIGHT);
        }
        return true;
    }
    return false;
  }

  public interface LeftRightListener {
    void onSwipe(int direction);
  }
}
