package com.example.lastfmapp.data.lyrics.remote.model;

import com.google.gson.annotations.SerializedName;

public class LyricsResponse {

    @SerializedName("lyrics")
    String lyrics;

    public LyricsResponse(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}
