package com.example.lastfmapp.presentation.topTracks.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lastfmapp.R;

public class TopTracksViewHolder extends RecyclerView.ViewHolder {

    TextView trackName;
    TextView artistName;

    public TopTracksViewHolder(@NonNull View itemView, final TopTrackListener listener) {
        super(itemView);
        trackName = itemView.findViewById(R.id.top_tracks_name);
        artistName = itemView.findViewById(R.id.top_trackartist_name);

        trackName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTrackClick(getAdapterPosition());
            }
        });

        artistName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onArtistClick(getAdapterPosition());
            }
        });

    }

    public interface TopTrackListener {
        void onTrackClick(int pos);
        void onArtistClick(int pos);
    }


}
