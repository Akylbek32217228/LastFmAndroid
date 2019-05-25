package com.example.lastfmapp.data.lyrics.remote;

import com.example.lastfmapp.data.lyrics.ILyricsRepository;

public interface ILyricsRemoteStorage {

    void getLyrics( String artist, String track, ILyricsRepository.LyricsCallback callback);

}
