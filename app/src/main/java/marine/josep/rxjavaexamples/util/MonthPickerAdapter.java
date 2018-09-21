package marine.josep.rxjavaexamples.util;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import marine.josep.rxjavaexamples.R;

public class MonthPickerAdapter extends RecyclerView.Adapter<MonthPickerViewHolder> {

  private List<MonthPickerModel> monthPickerModelList = new ArrayList<>();
  private MonthPickerRecyclerView monthPickerRecyclerView;
  private Context context;
  private int selectedPosition;

  public MonthPickerAdapter(Context context,
                            List<MonthPickerModel> monthPickerModelList,
                            MonthPickerRecyclerView monthPickerRecyclerView) {

    this.monthPickerModelList.addAll(monthPickerModelList);
    this.monthPickerRecyclerView = monthPickerRecyclerView;
    this.context = context;
    setupMonthPickerRecyclerView();
  }

  private void setupMonthPickerRecyclerView(){
    monthPickerRecyclerView.setAdapter(this);
    monthPickerRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
  }

  @Override
  public MonthPickerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.month_picker_item, parent, false);
    itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        int position = monthPickerRecyclerView.getChildLayoutPosition(itemView);
        monthPickerRecyclerView.moveToMonth(position);
      }
    });
    return new MonthPickerViewHolder(itemView, new CenteredItemListener() {
      @Override
      public void isCentered(boolean isCentered, int position) {
        if (isCentered) {
          selectedPosition = position;
        }
      }
    });
  }

  public void moveToMonth(Calendar calendar){
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int position = monthPickerModelList.size()-1;
    for(int i=0;i<monthPickerModelList.size();i++){
      if(monthPickerModelList.get(i).getMonth()==month && monthPickerModelList.get(i).getYear()==year){
        position = i;
      }
    }
    monthPickerRecyclerView.moveToMonth(position);
  }

  @Override
  public void onBindViewHolder(MonthPickerViewHolder holder, int position) {
    holder.bindView(context, monthPickerModelList.get(position));
  }

  @Override
  public int getItemCount() {
    return monthPickerModelList.size();
  }

  public int getSelectedPosition() {
    return selectedPosition;
  }

  public MonthPickerModel getMonth(int position){
    if(monthPickerModelList!=null && monthPickerModelList.size()>position){
      return monthPickerModelList.get(position);
    }
    return null;
  }

  public interface CenteredItemListener {
    void isCentered(boolean isCentered, int position);
  }

}
