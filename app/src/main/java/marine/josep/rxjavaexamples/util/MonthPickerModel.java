package marine.josep.rxjavaexamples.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import marine.josep.rxjavaexamples.R;

public class MonthPickerModel {

  private int month;
  private int year;
  private int descId;

  private MonthPickerModel(int month, int year, int descId) {
    this.descId = descId;
    this.month = month;
    this.year = year;
  }

  private static int[][] natutalMonths = {
          {1, R.string.month_1},
          {2, R.string.month_2},
          {3, R.string.month_3},
          {4, R.string.month_4},
          {5, R.string.month_5},
          {6, R.string.month_6},
          {7, R.string.month_7},
          {8, R.string.month_8},
          {9, R.string.month_9},
          {10, R.string.month_10},
          {11, R.string.month_11},
          {12, R.string.month_12},
  };

  public static List<MonthPickerModel> getMonths(Calendar startDate, int numberOfMonths) {
    int startMonth = startDate.get(Calendar.MONTH);
    int startYear = startDate.get(Calendar.YEAR);
    List<MonthPickerModel> monthPickerModels = new ArrayList<>();
    while (monthPickerModels.size() < numberOfMonths) {
      MonthPickerModel monthPickerModel = new MonthPickerModel(natutalMonths[startMonth - 1][0], startYear, natutalMonths[startMonth - 1][1]);
      monthPickerModel.year = startYear;
      monthPickerModels.add(monthPickerModel);
      if (startMonth > 1) {
        startMonth = --startMonth;
      } else {
        startYear--;
        startMonth = 12;
      }
    }
    Collections.reverse(monthPickerModels);
    return monthPickerModels;
  }

  public int getMonth() {
    return month;
  }

  public int getDescId() {
    return descId;
  }

  public int getYear() {
    return year;
  }

  @Override
  public String toString() {
    return month + "/" + year;
  }
}
