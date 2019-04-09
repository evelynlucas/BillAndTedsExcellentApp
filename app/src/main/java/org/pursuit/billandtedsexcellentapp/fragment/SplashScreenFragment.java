package org.pursuit.billandtedsexcellentapp.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import org.pursuit.billandtedsexcellentapp.MainActivity;
import org.pursuit.billandtedsexcellentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashScreenFragment extends Fragment {

    private FragmentInterface fragmentInterface;
    private CountDownTimer countDownTimer;
    private static int SCREEN_TIME = 3000;
    private FrameLayout frameLayout;
    private ImageView logo;


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
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        frameLayout = view.findViewById(R.id.splash_screen_frame);
        logo = view.findViewById(R.id.wyld_stallyns_logo);
        logo.setTranslationX(-1000f);
        logo.setTranslationY(-1000f);

        logo.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
        logo.animate()
                .translationXBy(1000f)
                .translationYBy(1000f)
                .rotationBy(3600)
                .setDuration(2000);
        logo.animate().scaleX(1f).scaleY(1f).setDuration(2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fragmentInterface.moveFromSplashScreenFragment();
                frameLayout.setVisibility(View.INVISIBLE);

            }
        }, SCREEN_TIME);

//        countDownTimer = new CountDownTimer(3000,1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//            }
//
//            @Override
//            public void onFinish() {
//                fragmentInterface.moveFromSplashScreenFragment();
//            }
//        };
//        countDownTimer.start();

    }
}
