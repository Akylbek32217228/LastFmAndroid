package com.example.lastfmapp.presentation.artist.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastfmapp.R;
import com.example.lastfmapp.model.Track;

import java.util.ArrayList;
import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistViewHolder> {

    private ArrayList<Track> mList;
    private ArtistViewHolder.ArtistListener listener;

    public ArtistAdapter(ArrayList<Track> mList, ArtistViewHolder.ArtistListener listener) {
        this.mList = mList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_artist_tracks, viewGroup, false);
        return new ArtistViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistViewHolder artistViewHolder, int i) {
        artistViewHolder.trackName.setText(mList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setArtistTracks(List<Track> tracks) {
        mList.clear();
        mList.addAll(tracks);
        notifyDataSetChanged();
    }
}
