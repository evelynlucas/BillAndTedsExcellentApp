package org.pursuit.billandtedsexcellentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.pursuit.billandtedsexcellentapp.fragment.DetailFragment;
import org.pursuit.billandtedsexcellentapp.fragment.FragmentInterface;
import org.pursuit.billandtedsexcellentapp.fragment.HomeFragment;
import org.pursuit.billandtedsexcellentapp.fragment.QuestionFragment;
import org.pursuit.billandtedsexcellentapp.fragment.RootFragment;
import org.pursuit.billandtedsexcellentapp.fragment.SplashScreenFragment;

public class MainActivity extends AppCompatActivity implements FragmentInterface {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_container,RootFragment.newInstance())
//                .commit();
        ViewPager viewPager = findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());

        adapter.addFragment(HomeFragment.newInstance(), "Home");
        adapter.addFragment(QuestionFragment.newInstance(), "Quiz");
        adapter.addFragment(QuestionFragment.newInstance(), "Fake");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
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
    public void moveFromSplashScreenFragment() {

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());

        adapter.addFragment(HomeFragment.newInstance(), "Home");
        adapter.addFragment(QuestionFragment.newInstance(), "Quiz");
        adapter.addFragment(QuestionFragment.newInstance(), "Fake");

//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void moveToRootFragment() {
        RootFragment rootFragment = RootFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, rootFragment)
                .commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.github_repo:
                String gitHubLink = getString(R.string.github_url);
                goToUrl(gitHubLink);
                return true;
            case R.id.linkedin:
                String linkedInLink = getString(R.string.linkedin_url);
                goToUrl(linkedInLink);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToUrl(String url) {
        Uri website = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, website);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, getString(R.string.no_browser_available_text), Toast.LENGTH_SHORT).show();
        }
    }
}
