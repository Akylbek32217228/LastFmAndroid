package com.example.lastfmapp.data.lyrics;

import com.example.core.mvp.CoreCallback;

public interface ILyricsRepository {

    void getLyrics(LyricsCallback callback, String artist, String track);

    interface LyricsCallback extends CoreCallback<String> {}
}
