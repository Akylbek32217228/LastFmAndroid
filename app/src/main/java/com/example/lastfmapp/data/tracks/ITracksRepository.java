package com.example.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.example.core.CoreCallback;
import com.example.lastfmapp.model.Track;

import java.util.List;

public interface  ITracksRepository {
    @Nullable
    void getTrack(String uniqueId,String artistName, String trackName, TrackCallback callback);

    void getTopTracks(TracksCallback callback);

    void getArtistTopTracks(String artistName, TracksCallback callback);

    interface TracksCallback extends CoreCallback<List<Track>> {}

    interface TrackCallback extends CoreCallback<Track> {}

}
