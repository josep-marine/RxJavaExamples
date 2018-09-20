package marine.josep.rxjavaexamples.util;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

public class ScreenUtils {

  public static float getScreenHorizonatlCenter(Activity activity) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    int width = displayMetrics.widthPixels;
    return dpToPx(activity, width)/2;
  }

  public static float dpToPx(Activity activity, int dp) {
    return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            activity.getResources().getDisplayMetrics());
  }

  public static boolean viewIsCentered(View parent, View child) {
    float screenCenter = parent.getX() + parent.getWidth()*0.5f;
    float point1 = child.getX() + child.getWidth()*0.33f;
    float point2 = child.getX() + child.getWidth()*0.66f;
    return (point1 <= screenCenter) && (point2 >= screenCenter);
  }

}
