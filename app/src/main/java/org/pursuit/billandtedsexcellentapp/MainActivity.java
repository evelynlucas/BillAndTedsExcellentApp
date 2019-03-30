package org.pursuit.billandtedsexcellentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.pursuit.billandtedsexcellentapp.fragment.FragmentInterface;
import org.pursuit.billandtedsexcellentapp.fragment.HomeFragment;
import org.pursuit.billandtedsexcellentapp.fragment.SplashScreenFragment;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveToFirstFragment();
    }

    @Override
    public void moveToFirstFragment() {
        SplashScreenFragment splashScreenFragment = SplashScreenFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, splashScreenFragment)
                .commit();

    }

    @Override
    public void moveToHomeFragment() {
        HomeFragment homeFragment = HomeFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, homeFragment)
                .commit();
    }

    @Override
    public void moveToDetailFragment() {

    }
}
