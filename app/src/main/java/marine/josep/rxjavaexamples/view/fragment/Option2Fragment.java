package marine.josep.rxjavaexamples.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import marine.josep.rxjavaexamples.R;


public class Option2Fragment extends ExamplesFragment {

  public Option2Fragment() {
    // Required empty public constructor
  }

  public static Option2Fragment newInstance() {
    return new Option2Fragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_option2, container, false);
  }

}
