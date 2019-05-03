package com.example.lastfmapp.data.tracks;

import android.support.annotation.Nullable;

import com.example.lastfmapp.model.TrackEntity;

import java.util.List;

public interface ITracksRepository {
    @Nullable
    TrackEntity getTrack(int id);

    void getTracks(TracksCallback callback);

    public interface TracksCallback {
        void onSucces(List<TrackEntity> tracks);

        void onFailure(String message);
    }

}
