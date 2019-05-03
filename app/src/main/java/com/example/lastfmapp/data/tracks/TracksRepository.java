package com.example.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.example.lastfmapp.data.tracks.local.ITracksLocalStorage;
import com.example.lastfmapp.data.tracks.remote.ITracksRemotes;
import com.example.lastfmapp.model.TrackEntity;

import java.util.ArrayList;
import java.util.List;

public class TracksRepository implements ITracksRepository {
    @Nullable
    private ITracksLocalStorage local;
    @Nullable
    private ITracksRemotes remotes;


    public TracksRepository(ITracksLocalStorage local, ITracksRemotes remotes) {
        this.local = local;
        this.remotes = remotes;
    }

    @Nullable
    @Override
    public TrackEntity getTrack(int id) {
        return null;
    }

    @Override
    public void getTracks(final TracksCallback callback) {


        local.getTracks(callback);
        remotes.getTracks(new TracksCallback() {

            @Override
            public void onSucces(List<TrackEntity> tracks) {
                local.setTracks(tracks);
                callback.onSucces(tracks);
            }

            @Override
            public void onFailure(String message) {
                callback.onFailure(message);
            }
        });
    }
}
