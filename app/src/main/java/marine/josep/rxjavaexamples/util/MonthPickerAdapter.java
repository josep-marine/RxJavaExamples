package marine.josep.rxjavaexamples.util;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import marine.josep.rxjavaexamples.R;

public class MonthPickerAdapter extends RecyclerView.Adapter<MonthPickerViewHolder> {

  private List<MonthsModel> monthsModelList = new ArrayList<>();
  private MonthPickerClickListener monthPickerClickListener;
  private Context context;
  private int selectedPosition;

  public MonthPickerAdapter(Context context, List<MonthsModel> monthsModelList, MonthPickerClickListener monthPickerClickListener) {
    this.monthsModelList.addAll(monthsModelList);
    this.monthPickerClickListener = monthPickerClickListener;
    this.context = context;
  }

  @Override
  public MonthPickerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.month_picker_item, parent, false);
    itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        monthPickerClickListener.onClick(itemView);
      }
    });
    return new MonthPickerViewHolder(itemView, new CenteredItemListener() {
      @Override
      public void isCentered(boolean isCentered, int position) {
        if(isCentered){
          selectedPosition = position;
        }
      }
    });
  }

  @Override
  public void onBindViewHolder(MonthPickerViewHolder holder, int position) {
    holder.bindView(context, monthsModelList.get(position));
  }

  public interface MonthPickerClickListener {
    void onClick(View itemView);
  }

  @Override
  public int getItemCount() {
    return monthsModelList.size();
  }

  public int getSelectedPosition() {
    return selectedPosition;
  }

  public interface CenteredItemListener{
    void isCentered(boolean isCentered, int position);
  }

}
