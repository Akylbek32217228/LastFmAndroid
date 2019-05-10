package com.example.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.example.core.Logger;
import com.example.lastfmapp.data.tracks.local.ITracksLocalStorage;
import com.example.lastfmapp.data.tracks.remote.ITracksRemoteStorage;
import com.example.lastfmapp.model.TrackEntity;

import java.util.List;

public class TracksRepository implements ITracksRepository {
    @Nullable
    private ITracksLocalStorage local;
    @Nullable
    private ITracksRemoteStorage remote;


    public TracksRepository(ITracksLocalStorage local, ITracksRemoteStorage remotes) {
        this.local = local;
        this.remote = remotes;
    }

    /*@Nullable
    @Override
    public TrackEntity getTrack(int id, String track, String artist, final TrackCallback callback) {
        if (local != null) {
            local.getTrack(callback);
        }

        return null;
    }*/


    @Nullable
    @Override
    public TrackEntity getTrack(int id, String track, String artist, TracksCallback callback) {
        return null;
    }

    @Override
    public void getTracks(final TracksCallback callback) {
        Logger.d("getTracksTracksRepository");
        if (local != null) {
            local.getTracks(callback);
        }

        if (remote != null) {
            remote.getTracks(new TracksCallback() {
                @Override
                public void onSucces(List<TrackEntity> tracks) {
                    Logger.d("onSuccesTrackRepository");
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



}
