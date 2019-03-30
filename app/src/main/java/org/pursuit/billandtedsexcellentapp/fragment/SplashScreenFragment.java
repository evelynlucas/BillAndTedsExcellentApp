package org.pursuit.billandtedsexcellentapp.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.billandtedsexcellentapp.MainActivity;
import org.pursuit.billandtedsexcellentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashScreenFragment extends Fragment {

    private FragmentInterface fragmentInterface;
    private static int SCREEN_TIME = 3000;


    public SplashScreenFragment() {
        // Required empty public constructor
    }

    public static SplashScreenFragment newInstance() {
        return new SplashScreenFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
            + " must implement FragmentInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInterface = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentInterface.moveToHomeFragment();
            }
        }, SCREEN_TIME);

    }
}