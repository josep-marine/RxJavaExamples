package marine.josep.rxjavaexamples.util;


import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import marine.josep.rxjavaexamples.R;

public class MonthPickerViewHolder extends RecyclerView.ViewHolder {

  private TextView monthName;
  private MonthPickerAdapter.CenteredItemListener centeredItemListener;

  public MonthPickerViewHolder(View itemView,MonthPickerAdapter.CenteredItemListener centeredItemListener) {
    super(itemView);
    this.centeredItemListener = centeredItemListener;
    monthName = itemView.findViewById(R.id.month_picker_item_name);
  }

  public void bindView(Context context, final MonthsModel monthsModel) {
    monthName.setText(context.getString(monthsModel.getDescId()));
  }

  public void isCentered(boolean isCentered,int position){
    centeredItemListener.isCentered(isCentered,position);
    if(isCentered){
      monthName.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
      monthName.setTypeface(null, Typeface.BOLD);
    }else{
      monthName.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
      monthName.setTypeface(null, Typeface.NORMAL);
    }
  }

}
