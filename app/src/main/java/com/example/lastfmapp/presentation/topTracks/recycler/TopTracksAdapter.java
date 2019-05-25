package com.example.lastfmapp.presentation.topTracks.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastfmapp.R;
import com.example.lastfmapp.model.Track;

import java.util.ArrayList;
import java.util.List;

public class TopTracksAdapter extends RecyclerView.Adapter<TopTracksViewHolder> {

    private TopTracksViewHolder.TopTrackListener mListener;
    private ArrayList<Track> mlist;


    public TopTracksAdapter( TopTracksViewHolder.TopTrackListener listener, ArrayList<Track> list) {
        mListener = listener;
        mlist = list;
    }

    @NonNull
    @Override
    public TopTracksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_tracks_viewholder, viewGroup, false);
        return new TopTracksViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TopTracksViewHolder topTracksViewHolder, int i) {
        topTracksViewHolder.trackName.setText(mlist.get(i).getName());
        topTracksViewHolder.artistName.setText(mlist.get(i).getArtist().getName());
    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setTracks(List<Track> tracks) {
        mlist.clear();
        mlist.addAll(tracks);
        notifyDataSetChanged();
    }
}
