package com.example.lastfmapp.presentation.name.topTracks.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.core.Logger;
import com.example.lastfmapp.R;
import com.example.lastfmapp.model.TrackEntity;

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
                listener.onTrackClick(getAdapterPosition(), trackName.toString(), artistName.toString());
            }
        });

    }

    public interface TopTrackListener {
        void onTrackClick(int pos,String track, String artist );
        void onShareClick(int pos);
        void onBookMarkClick(int pos);

    }

    public void onBind(TrackEntity track) {
        if ( trackName != null) {
            trackName.setText(track.getName());
            artistName.setText(track.getArtist().getName());
        } else {
            Logger.d("null");
        }
    }

}
