package com.example.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.example.core.Logger;
import com.example.lastfmapp.data.tracks.local.ITracksLocalStorage;
import com.example.lastfmapp.data.tracks.remote.ITracksRemoteStorage;
import com.example.lastfmapp.model.Track;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TracksRepository implements ITracksRepository {
    @Nullable
    private ITracksLocalStorage local;
    @Nullable
    private ITracksRemoteStorage remote;

    //private HashMap<String, Track> mCache = new HashMap<>();

    public TracksRepository(ITracksLocalStorage local, ITracksRemoteStorage remotes) {
        this.local = local;
        this.remote = remotes;
    }


    @Nullable
    @Override
    public void getTrack(String uniqueId, String artistName, String trackName, final ITracksRepository.TrackCallback callback) {
        Track track = null;
        if (local != null) {
            track = local.getTrack(uniqueId);
            if ( track != null) {
                callback.onSucces(track);
            }
        }
        if (track == null && remote != null ) {
            remote.getTrack(artistName, trackName,new TrackCallback() {
                @Override
                public void onSucces(Track result) {
                    callback.onSucces(result);
                }

                @Override
                public void onFailure(String message) {
                    callback.onFailure(message);
                }
            });
        }

    }

    private void setCache(List<Track> tracks) {
        if (local != null) {
            local.setTracks(tracks);
        }
    }

    @Override
    public void getTopTracks(final TracksCallback callback) {
        if (local != null) {
            local.getTracks(callback);
        }

        if (remote != null) {
            remote.getTracks(new TracksCallback() {
                @Override
                public void onSucces(List<Track> tracks) {
                    setCache(tracks);

                    callback.onSucces(tracks);
                }

                @Override
                public void onFailure(String message) {
                    callback.onFailure(message);
                }
            });
        }
    }

    @Override
    public void getArtistTopTracks(final String artistName, final TracksCallback callback) {

        if ( remote != null) {
            remote.getArtistTopTracks(artistName, new TracksCallback() {
                @Override
                public void onSucces(List<Track> result) {
                    callback.onSucces(result);
                }

                @Override
                public void onFailure(String message) {
                    callback.onFailure(message);
                }
            });
        }

    }


}
