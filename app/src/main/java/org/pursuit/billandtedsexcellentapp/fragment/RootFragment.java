package org.pursuit.billandtedsexcellentapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_root, container, false);

        FragmentTransaction fragmentTransaction = getFragmentManager()
                .beginTransaction();

        fragmentTransaction.replace(R.id.root_frame, HomeFragment.newInstance());
        fragmentTransaction.commit();
        return view;
    }

}
