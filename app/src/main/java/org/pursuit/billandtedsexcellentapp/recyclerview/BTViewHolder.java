package org.pursuit.billandtedsexcellentapp.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.billandtedsexcellentapp.R;
import org.pursuit.billandtedsexcellentapp.fragment.FragmentInterface;
import org.pursuit.billandtedsexcellentapp.model.CharactersWrapper;

public class BTViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTextView;
    private ImageView characterImageView;
    private FragmentInterface fragmentInterface;

    public BTViewHolder(@NonNull View itemView, FragmentInterface fragmentInterface) {
        super(itemView);
        this.fragmentInterface = fragmentInterface;
        nameTextView = itemView.findViewById(R.id.bt_itemview_textview);
        characterImageView = itemView.findViewById(R.id.bt_itemview_imageview);
    }

    public void onBind(final CharactersWrapper.CharacterModel characterModel) {
        nameTextView.setText(characterModel.getName());
        Picasso.get()
                .load(characterModel.getImage())
                .centerCrop()
                .resize(200, 200)
                .into(characterImageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.moveToDetailFragment(characterModel.getName(),
                        characterModel.getBio(),
                        characterModel.getQuote(),
                        characterModel.getImage(),
                        characterModel.getUrl());
            }
        });
    }
}
