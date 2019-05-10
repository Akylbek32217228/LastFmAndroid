package com.example.lastfmapp.presentation.name.TopArtists.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastfmapp.R;
import com.example.lastfmapp.model.ArtistEntity;

import java.util.ArrayList;
import java.util.List;

public class  TopArtistsAdapter extends RecyclerView.Adapter<TopArtistsViewHolder> {

    private ArrayList<ArtistEntity> artistList;

    public TopArtistsAdapter(ArrayList<ArtistEntity> artistList) {
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public TopArtistsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_artists_viewholder, viewGroup,false);

        return new TopArtistsViewHolder(v, new TopArtistsViewHolder.TopArtistsListener() {
            @Override
            public void onArtistClick(int pos) {

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
    public void onBindViewHolder(@NonNull TopArtistsViewHolder topArtistsViewHolder, int i) {
        topArtistsViewHolder.nameArtist.setText(artistList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

    public void setArtists(List<ArtistEntity> artists) {
        artistList.clear();
        artistList.addAll(artists);
        notifyDataSetChanged();
    }
}
