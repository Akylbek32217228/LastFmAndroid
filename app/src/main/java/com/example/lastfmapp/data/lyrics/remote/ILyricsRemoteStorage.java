package com.example.lastfmapp.data.lyrics.remote;

import com.example.lastfmapp.data.lyrics.ILyricsRepository;

public interface ILyricsRemoteStorage {

    void getLyrics(ILyricsRepository.LyricsCallback callback, String artist, String track);

}
