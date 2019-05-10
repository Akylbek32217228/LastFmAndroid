package com.example.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.example.core.mvp.CoreCallback;
import com.example.lastfmapp.model.TrackEntity;

import java.util.List;

public interface  ITracksRepository {
    @Nullable
    TrackEntity getTrack(int id, String track, String artist, TracksCallback callback);

    void getTracks(TracksCallback callback);

    interface TracksCallback extends CoreCallback<List<TrackEntity>> {}

    interface TrackCallback extends CoreCallback<TrackEntity> {}

}
