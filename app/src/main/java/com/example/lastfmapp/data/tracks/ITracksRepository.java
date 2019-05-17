package com.example.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.example.core.mvp.CoreCallback;
import com.example.lastfmapp.model.Track;

import java.util.List;

public interface  ITracksRepository {
    @Nullable
    Track getTrack(String uniqueId);

    void getTopTracks(TracksCallback callback);

    void getArtistTopTracks(String artistName, TracksCallback callback);

    interface TracksCallback extends CoreCallback<List<Track>> {}

}
