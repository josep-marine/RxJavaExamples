package marine.josep.rxjavaexamples.util;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import marine.josep.rxjavaexamples.R;

public class MonthPickerViewHolder extends RecyclerView.ViewHolder {

  private View itemView;
  private TextView monthName;

  public MonthPickerViewHolder(View itemView) {
    super(itemView);
    this.itemView = itemView;
    monthName = itemView.findViewById(R.id.month_picker_item_name);
  }

  public void bindView(Context context, final MonthsModel monthsModel) {
    monthName.setText(context.getString(monthsModel.getDescId()));
  }


}
