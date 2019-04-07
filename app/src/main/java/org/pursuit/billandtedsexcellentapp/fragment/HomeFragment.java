package org.pursuit.billandtedsexcellentapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.billandtedsexcellentapp.R;
import org.pursuit.billandtedsexcellentapp.model.CharactersWrapper;
import org.pursuit.billandtedsexcellentapp.network.APIService;
import org.pursuit.billandtedsexcellentapp.network.RetrofitSingleton;
import org.pursuit.billandtedsexcellentapp.recyclerview.BTAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeFragmentInterface {

    private FragmentInterface fragmentInterface;
    private static final String TAG = "EvelynActivity";
    private RecyclerView recyclerView;
    private View detailLayout;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final HomeFragmentInterface homeFragmentInterface = this;
        recyclerView = view.findViewById(R.id.recycler_view);
        detailLayout = view.findViewById(R.id.detail_fragment_replacement_layout);
        RetrofitSingleton.getInstance()
                .create(APIService.class)
                .getCharacters()
                .enqueue(new Callback<CharactersWrapper>() {
                    @Override
                    public void onResponse(Call<CharactersWrapper> call, Response<CharactersWrapper> response) {
                        Log.d(TAG, response.body().getCharacters().get(3).getName());
                        CharactersWrapper charactersWrapper = response.body();
                        List<CharactersWrapper.CharacterModel> characterModelList = charactersWrapper.getCharacters();
                        BTAdapter adapter = new BTAdapter(characterModelList, homeFragmentInterface);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());

                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(linearLayoutManager);
                    }

                    @Override
                    public void onFailure(Call<CharactersWrapper> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.toString());
                    }
                });
    }

    @Override
    public void changeVisibility(CharactersWrapper.CharacterModel characterModel) {
        ((TextView)detailLayout.findViewById(R.id.detail_name_textview)).setText(characterModel.getName());
        ((TextView)detailLayout.findViewById(R.id.detail_bio_textview)).setText(characterModel.getBio());
        ((TextView)detailLayout.findViewById(R.id.detail_quote_textview)).setText(characterModel.getQuote());
        ((TextView)detailLayout.findViewById(R.id.detail_url_textview)).setText(characterModel.getUrl());

        ImageView imageView = detailLayout.findViewById(R.id.detail_imageview);
        Picasso.get()
                .load(characterModel.getImage())
                .into(imageView);

        Button button = detailLayout.findViewById(R.id.back_to_recyclerview_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailLayout.setVisibility(View.INVISIBLE);
            }
        });

        detailLayout.setVisibility(View.VISIBLE);
    }
}
