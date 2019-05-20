package com.example.lastfmapp.presentation.artist.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lastfmapp.R;

public class ArtistViewHolder extends RecyclerView.ViewHolder {

    TextView trackName;

    public ArtistViewHolder(@NonNull View itemView, final ArtistListener listener) {
        super(itemView);

        trackName = itemView.findViewById(R.id.activity_artist_track_name);
        trackName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTrackClick(getAdapterPosition());
            }
        });

    }

    public interface ArtistListener {

        void onTrackClick(int pos);

    }

}
