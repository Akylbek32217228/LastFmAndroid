package com.example.lastfmapp.data.lyrics;

import android.support.annotation.Nullable;

import com.example.lastfmapp.data.lyrics.remote.ILyricsRemoteStorage;

public class LyricsRepository implements ILyricsRepository {
    @Nullable
    private ILyricsRemoteStorage remoteStorage;

    public LyricsRepository( @Nullable ILyricsRemoteStorage remoteStorage) {
        this.remoteStorage = remoteStorage;
    }

    @Override
    public void getLyrics(final ILyricsRepository.LyricsCallback callback , String artist, String track) {

        if ( remoteStorage != null) {
            remoteStorage.getLyrics(new LyricsCallback() {
                @Override
                public void onSucces(String result) {
                    callback.onSucces(result);
                }

                @Override
                public void onFailure(String message) {
                    callback.onFailure(message);
                }
            },artist,track);
        }
    }


}
