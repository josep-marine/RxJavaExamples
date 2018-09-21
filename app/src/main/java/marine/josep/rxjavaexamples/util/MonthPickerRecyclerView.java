package marine.josep.rxjavaexamples.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;


public class MonthPickerRecyclerView extends RecyclerView {

  private static final int PADDING = 40;

  private Context context;

  private MonthPickerSelectListener monthPickerSelectListener;

  public MonthPickerRecyclerView(Context context) {
    super(context);
    this.context = context;
    setupMonthPickerRecyclerView();
  }

  public MonthPickerRecyclerView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    this.context = context;
    setupMonthPickerRecyclerView();
  }

  public MonthPickerRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    this.context = context;
    setupMonthPickerRecyclerView();
  }

  private static boolean viewIsCentered(View parent, View child) {
    float screenCenter = parent.getX() + parent.getWidth() * 0.5f;
    float point1 = child.getX();
    float point2 = child.getX() + child.getWidth();
    return (point1 <= screenCenter) && (point2 >= screenCenter);
  }

  private void setupMonthPickerRecyclerView() {

    this.setHasFixedSize(true);

    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    int width = displayMetrics.widthPixels;
    int padding = width / 2 - Math.round(dpToPx(PADDING));
    this.setPadding(padding, 0, padding, 0);

    //Snapper
    LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
    linearSnapHelper.attachToRecyclerView(this);

    //Selecter
    this.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override
      public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        if (newState == (RecyclerView.SCROLL_STATE_IDLE)) {

          int position = centerToMiddleItem(recyclerView);

          if (position != -1) {
            if (monthPickerSelectListener != null) {
              monthPickerSelectListener.onMonthSelected(getMonth(position));
            }
          }
        }
      }

    });
  }

  public int centerToMiddleItem(RecyclerView recyclerView) {
    int position = -1;
    for (int i = 0; i < recyclerView.getChildCount(); i++) {
      View child = recyclerView.getChildAt(i);
      if (viewIsCentered(recyclerView, child)) {
        position = recyclerView.getChildLayoutPosition(child);
        ((MonthPickerViewHolder) recyclerView.getChildViewHolder(child)).isCentered(true, position);
      } else {
        ((MonthPickerViewHolder) recyclerView.getChildViewHolder(child)).isCentered(false, position);
      }
    }
    return position;
  }

  private float dpToPx(int dp) {
    Resources r = getResources();
    float px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            r.getDisplayMetrics());
    return px;
  }

  public void moveToMonth(int position) {
    this.getLayoutManager().smoothScrollToPosition(this, null, position);
  }

  public void finishMovement() {
    int position = centerToMiddleItem(this);
    if (position != -1) {
      if (monthPickerSelectListener != null) {
        monthPickerSelectListener.onMonthSelected(getMonth(position));
      }
      this.smoothScrollToPosition(position);
    }
  }

  public void moveScroll(int distance) {
    this.scrollBy(distance, 0);
  }

  public void addMonthPickerSelectListener(MonthPickerSelectListener monthPickerSelectListener) {
    this.monthPickerSelectListener = monthPickerSelectListener;
  }

  private MonthPickerModel getMonth(int position) {
    if (getAdapter() != null && getAdapter() instanceof MonthPickerAdapter) {
      return ((MonthPickerAdapter) getAdapter()).getMonth(position);
    }
    return null;
  }

  public interface MonthPickerSelectListener {
    void onMonthSelected(MonthPickerModel monthPickerModel);
  }

}
