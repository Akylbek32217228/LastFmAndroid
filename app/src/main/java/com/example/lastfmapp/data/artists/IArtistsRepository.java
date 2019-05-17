package com.example.lastfmapp.data.artists;

import android.support.annotation.Nullable;

import com.example.lastfmapp.model.Artist;

import java.util.List;

public interface IArtistsRepository {

    @Nullable
    Artist getArtist(int id);

    void getArtists(ArtistsCallback callback);

    interface ArtistsCallback {
        void onSucces(List<Artist> artists);

        void onFailure(String message);
    }

}
