package org.pursuit.billandtedsexcellentapp.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.billandtedsexcellentapp.R;
import org.pursuit.billandtedsexcellentapp.fragment.FragmentInterface;
import org.pursuit.billandtedsexcellentapp.model.CharactersWrapper;

import java.util.List;

public class BTAdapter extends RecyclerView.Adapter<BTViewHolder> {

    private List<CharactersWrapper.CharacterModel> characterList;
    private FragmentInterface fragmentInterface;

    public BTAdapter(List<CharactersWrapper.CharacterModel> characterList, FragmentInterface fragmentInterface) {
        this.characterList = characterList;
        this.fragmentInterface = fragmentInterface;
    }

    @NonNull
    @Override
    public BTViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bt_item_view, viewGroup, false);
        return new BTViewHolder(view, fragmentInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull BTViewHolder btViewHolder, int i) {
        btViewHolder.onBind(characterList.get(i));
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }
}
