package org.pursuit.billandtedsexcellentapp.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.billandtedsexcellentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RootFragment extends Fragment {


    public RootFragment() {
        // Required empty public constructor
    }

    public static RootFragment newInstance() {
        return new RootFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_root, container, false);

        FragmentTransaction fragmentTransaction = getFragmentManager()
                .beginTransaction();

        fragmentTransaction.replace(R.id.root_frame, SplashScreenFragment.newInstance());
        fragmentTransaction.commit();
        return view;
    }

}
