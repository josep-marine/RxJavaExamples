package marine.josep.rxjavaexamples.view.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import marine.josep.rxjavaexamples.R;
import marine.josep.rxjavaexamples.view.fragment.Option1Fragment;
import marine.josep.rxjavaexamples.view.fragment.Option2Fragment;
import marine.josep.rxjavaexamples.view.fragment.Option3Fragment;

public class MainActivity extends AppCompatActivity {

  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
          = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
        case R.id.navigation_home:
          loadFragment(Option1Fragment.newInstance());
          return true;
        case R.id.navigation_dashboard:
          loadFragment(Option2Fragment.newInstance());
          return true;
        case R.id.navigation_notifications:
          loadFragment(Option3Fragment.newInstance());
          return true;
      }
      return false;
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    loadFragment(Option1Fragment.newInstance());
  }

  private void loadFragment(Fragment fragment) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.fragment_container, fragment);
    fragmentTransaction.commitNowAllowingStateLoss();
  }

}
