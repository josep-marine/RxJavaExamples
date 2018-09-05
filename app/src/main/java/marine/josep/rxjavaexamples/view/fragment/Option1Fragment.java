package marine.josep.rxjavaexamples.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import javax.inject.Inject;

import marine.josep.rxjavaexamples.R;
import marine.josep.rxjavaexamples.view.model.Option1Model;
import marine.josep.rxjavaexamples.presenter.Option1Presenter;

public class Option1Fragment extends ExamplesFragment implements Option1Presenter.View {


  @Inject
  Option1Presenter presenter;

  private View view;
  private ProgressBar progressBar;

  public Option1Fragment() {
    // Required empty public constructor
  }

  public static Option1Fragment newInstance() {
    return new Option1Fragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    getDaggerComponent().inject(this);
    super.onCreate(savedInstanceState);
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_option1, container, false);
    presenter.setView(this);
    bindViews(view);
    presenter.loadData();
    return view;
  }

  @Override
  public void onLoadData(Option1Model option1Model) {

  }

  private void bindViews(View view) {
    progressBar = (ProgressBar) view.findViewById(R.id.fragment_option1_progress_bar);
  }

  @Override
  public void showProgress() {
    if (view != null) {
      progressBar.setVisibility(View.VISIBLE);
    }
  }

  @Override
  public void hideProgress() {
    if (view != null) {
      progressBar.setVisibility(View.GONE);
    }
  }

}
