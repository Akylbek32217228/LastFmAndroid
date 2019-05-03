package com.example.lastfmapp.data.tracks.remote;

import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.model.TrackEntity;

import java.util.ArrayList;

public class RemoteTracksStorage implements ITracksRemotes {
    @Override
    public void getTracks(ITracksRepository.TracksCallback callback) {
        //TODO: Network call
        ArrayList<TrackEntity> trackEntities = new ArrayList<>();

        trackEntities.add(new TrackEntity(1, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(2, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(3, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(4, "name", "artist", "image"));
        trackEntities.add(new TrackEntity(5, "name", "artist", "image"));

        callback.onSucces(trackEntities);
    }
}
