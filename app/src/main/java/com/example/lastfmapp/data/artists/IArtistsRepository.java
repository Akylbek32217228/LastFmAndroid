package com.example.lastfmapp.data.artists;

import android.support.annotation.Nullable;

import com.example.lastfmapp.model.ArtistEntity;
import com.example.lastfmapp.model.TrackEntity;

import java.util.List;

public interface IArtistsRepository {

    @Nullable
    ArtistEntity getArtist(int id);

    void getArtists(ArtistsCallback callback);

    interface ArtistsCallback {
        void onSucces(List<ArtistEntity> artists);

        void onFailure(String message);
    }

}
