package org.pursuit.billandtedsexcellentapp.fragment;

import android.widget.LinearLayout;

public interface FragmentInterface {

    void moveToFirstFragment();
    void moveToHomeFragment();
    void moveToDetailFragment(String name, String bio, String quote, String image, String url);
    void moveToDetailFragmentWithinHomeFragment(String name, String bio, String quote, String image, String url);
    void showVisibilityDetailFragment();
}
