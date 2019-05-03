package com.example.lastfmapp.data.artists;

import android.support.annotation.Nullable;

import com.example.lastfmapp.data.artists.local.IArtistsLocalStorage;
import com.example.lastfmapp.data.artists.remote.IArtistsRemoteStorage;
import com.example.lastfmapp.model.ArtistEntity;

import java.util.List;

public class ArtistsRepository implements IArtistsRepository {
    @Nullable
    private IArtistsLocalStorage local;
    @Nullable
    private IArtistsRemoteStorage remote;

    public ArtistsRepository(@Nullable IArtistsLocalStorage local, @Nullable IArtistsRemoteStorage remote) {
        this.local = local;
        this.remote = remote;
    }


    @Nullable
    @Override
    public ArtistEntity getArtist(int id) {
        return null;
    }

    @Override
    public void getArtists(final ArtistsCallback callback) {
        local.getArtists(callback);
        remote.getArtists(new ArtistsCallback() {
            @Override
            public void onSucces(List<ArtistEntity> artists) {
                local.setArtists(artists);
                callback.onSucces(artists);
            }

            @Override
            public void onFailure(String message) {
                callback.onFailure(message);
            }
        });
    }
}
