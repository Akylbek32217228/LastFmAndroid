package com.example.lastfmapp.presentation.name.topTracks.recycler;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.core.Logger;
import com.example.lastfmapp.R;
import com.example.lastfmapp.model.TrackEntity;
import com.example.lastfmapp.presentation.name.Track.TrackActivity;
import com.example.lastfmapp.presentation.name.main.MainActivity;
import com.example.lastfmapp.presentation.name.topTracks.TopTracksFragment;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

public class TopTracksAdapter extends RecyclerView.Adapter<TopTracksViewHolder> {

    private TopTracksViewHolder.TopTrackListener mListener;
    private ArrayList<TrackEntity> mlist;
    TrackEntity track;


    public TopTracksAdapter( ArrayList<TrackEntity> list) {
        Logger.d("TopTracksAdapter");
        mlist = list;
    }

    @NonNull
    @Override
    public TopTracksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_tracks_viewholder, viewGroup, false);
        return new TopTracksViewHolder(view, new TopTracksViewHolder.TopTrackListener() {
            @Override
            public void onTrackClick(int pos, String track, String artist) {
                Logger.d("fdfdfddfdfdfd");
                Intent intent = new Intent(view.getContext(), TrackActivity.class);

                intent.putExtra("key_track",track);
                intent.putExtra("key_artist",artist);
                view.getContext().startActivity(intent);
            }

            @Override
            public void onShareClick(int pos) {

            }

            @Override
            public void onBookMarkClick(int pos) {

            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull TopTracksViewHolder topTracksViewHolder, int i) {
        Logger.d("bind");
        track = mlist.get(i);
        topTracksViewHolder.onBind(track);
        Logger.d("bind2");
    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setTracks(List<TrackEntity> tracks) {
        mlist.clear();
        mlist .addAll(tracks);
        notifyDataSetChanged();
    }
}
