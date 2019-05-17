package com.example.lastfmapp.presentation.topArtists.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lastfmapp.R;

public class TopArtistsViewHolder extends RecyclerView.ViewHolder {

    TextView nameArtist;

    public TopArtistsViewHolder(@NonNull View itemView,final TopArtistsListener listener) {
        super(itemView);

        nameArtist = itemView.findViewById(R.id.text_top_artists_name);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onArtistClick(getAdapterPosition());
            }
        });
    }


    public interface TopArtistsListener {
        void onArtistClick(int pos);
        void onShareClick(int pos);
        void onBookMarkClick(int pos);
    }


}
