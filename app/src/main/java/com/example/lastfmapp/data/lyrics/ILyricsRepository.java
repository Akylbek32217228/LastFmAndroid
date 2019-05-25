package com.example.lastfmapp.data.lyrics;

import com.example.core.CoreCallback;

public interface ILyricsRepository {

    void getLyrics(String artist, String track,LyricsCallback callback);

    interface LyricsCallback extends CoreCallback<String> {}
}
