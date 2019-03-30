package org.pursuit.billandtedsexcellentapp.fragment;

public interface FragmentInterface {

    void moveToFirstFragment();
    void moveToHomeFragment();
    void moveToDetailFragment(String name, String bio, String quote, String image, String url);
}
