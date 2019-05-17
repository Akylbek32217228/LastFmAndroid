package com.example.lastfmapp;

import android.app.Application;

import com.example.lastfmapp.data.artists.ArtistsRepository;
import com.example.lastfmapp.data.artists.IArtistsRepository;
import com.example.lastfmapp.data.artists.local.ArtistsLocalStorage;
import com.example.lastfmapp.data.artists.remote.ArtistsRemoteStorage;
import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.data.tracks.TracksRepository;
import com.example.lastfmapp.data.tracks.local.TracksLocalStorage;
import com.example.lastfmapp.data.tracks.remote.TracksRemoteStorage;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {

    public static ITracksRepository tracksRepository;
    public static IArtistsRepository artistsRepository;



    @Override
    public void onCreate() {
        super.onCreate();

        initRealm();
        artistsRepository = new ArtistsRepository(new ArtistsLocalStorage(), new ArtistsRemoteStorage());
        tracksRepository = new TracksRepository(new TracksLocalStorage(), new TracksRemoteStorage());
    }

    private void initRealm() {
        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name("lastfm.realm")
                .schemaVersion(1)
                .build();

        Realm.setDefaultConfiguration(configuration);
    }
}
