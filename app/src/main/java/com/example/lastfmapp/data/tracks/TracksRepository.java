package com.example.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.example.core.Logger;
import com.example.lastfmapp.data.tracks.local.ITracksLocalStorage;
import com.example.lastfmapp.data.tracks.remote.ITracksRemoteStorage;
import com.example.lastfmapp.model.Track;

import java.util.HashMap;
import java.util.List;

public class TracksRepository implements ITracksRepository {
    @Nullable
    private ITracksLocalStorage local;
    @Nullable
    private ITracksRemoteStorage remote;

    private HashMap<String, Track> mCache = new HashMap<>();

    public TracksRepository(ITracksLocalStorage local, ITracksRemoteStorage remotes) {
        this.local = local;
        this.remote = remotes;
    }


    @Nullable
    @Override
    public Track getTrack(String uniqueId) {
        Track track = mCache.get(uniqueId);
        Logger.d("        " +  track.getUniqueId() + "         ");
        if ( track != null && local != null) {
            track = local.getTrack(uniqueId);
            Logger.d("getTrackRepository");
        }
        return track;
    }

    private void setCache(List<Track> tracks) {
        if (local != null) {
            local.setTracks(tracks);
        }

        for(Track track : tracks) {
            mCache.put(track.getUniqueId(), track);
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
    public void getArtistTopTracks(String artistName, TracksCallback callback) {
        //TODO: Fetch artist top tracks
    }


}
