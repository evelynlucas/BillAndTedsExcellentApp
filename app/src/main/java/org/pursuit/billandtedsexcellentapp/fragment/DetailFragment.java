package org.pursuit.billandtedsexcellentapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.billandtedsexcellentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private FragmentInterface fragmentInterface;
    private static final String TAG = "EvelynActivity";
    private static final String NAME_KEY = "name_key";
    private static final String BIO_KEY = "bio_key";
    private static final String QUOTE_KEY = "quote_key";
    private static final String IMAGE_KEY = "image_key";
    private static final String URL_KEY = "url_key";

    private String nameString;
    private String bioString;
    private String quoteString;
    private String imageString;
    private String urlString;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String name, String bio, String quote, String image, String url) {
        final Bundle args = new Bundle();
        DetailFragment fragment = new DetailFragment();
        args.putString(NAME_KEY, name);
        args.putString(BIO_KEY, bio);
        args.putString(QUOTE_KEY, quote);
        args.putString(IMAGE_KEY, image);
        args.putString(URL_KEY, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nameString = getArguments().getString(NAME_KEY);
            bioString = getArguments().getString(BIO_KEY);
            quoteString = getArguments().getString(QUOTE_KEY);
            imageString = getArguments().getString(IMAGE_KEY);
            urlString = getArguments().getString(URL_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
