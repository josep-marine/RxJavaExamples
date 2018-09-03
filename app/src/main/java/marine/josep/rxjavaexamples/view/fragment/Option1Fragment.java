package marine.josep.rxjavaexamples.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import marine.josep.rxjavaexamples.R;


public class Option1Fragment extends Fragment {

  public Option1Fragment() {
    // Required empty public constructor
  }

  public static Option1Fragment newInstance() {
    return new Option1Fragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_option1, container, false);
  }

}
