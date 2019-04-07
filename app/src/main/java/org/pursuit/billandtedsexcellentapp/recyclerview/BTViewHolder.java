package org.pursuit.billandtedsexcellentapp.recyclerview;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.billandtedsexcellentapp.R;
import org.pursuit.billandtedsexcellentapp.fragment.DetailFragment;
import org.pursuit.billandtedsexcellentapp.fragment.FragmentInterface;
import org.pursuit.billandtedsexcellentapp.fragment.HomeFragment;
import org.pursuit.billandtedsexcellentapp.fragment.HomeFragmentInterface;
import org.pursuit.billandtedsexcellentapp.model.CharactersWrapper;

public class BTViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTextView;
    private ImageView characterImageView;
    private HomeFragmentInterface fragmentInterface;

    public BTViewHolder(@NonNull View itemView, HomeFragmentInterface fragmentInterface) {
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
                fragmentInterface.changeVisibility(characterModel);
            }
        });
    }
}
