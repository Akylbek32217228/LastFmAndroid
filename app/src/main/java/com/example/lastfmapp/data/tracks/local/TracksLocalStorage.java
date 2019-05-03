package com.example.lastfmapp.data.tracks.local;

import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.model.TrackEntity;

import java.util.ArrayList;
import java.util.List;

public class TracksLocalStorage implements ITracksLocalStorage {
    @Override
    public void getTracks(ITracksRepository.TracksCallback callback) {
        //TODO: Fetch from database
        ArrayList<TrackEntity> trackEntities = new ArrayList<>();

        trackEntities.add(new TrackEntity(1, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(2, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(3, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(4, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(5, "name", "artist", "image"));

        callback.onSucces(trackEntities);
    }

    @Override
    public void setTracks(List<TrackEntity> tracks) {
        //TODO: Save to DB
    }
}
