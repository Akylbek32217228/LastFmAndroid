package com.example.lastfmapp.data.tracks.local;

import com.example.lastfmapp.data.common.RImage;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RTrack extends RealmObject {

    @PrimaryKey
    private String uniqueId;

    private String name;
    private String url;
    private String playcount;
    private String listeners;
    private RealmList<RImage> images;
    private RTrackArtist artist;


    public RTrack() {
    }

    public RTrack(String uniqueId, String name, String url, String playcount, String listeners,
                  RTrackArtist artist,
                  RealmList<RImage> images) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.url = url;
        this.playcount = playcount;
        this.listeners = listeners;
        this.images = images;
        this.artist = artist;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public RealmList<RImage> getImages() {
        return images;
    }

    public void setImages(RealmList<RImage> images) {
        this.images = images;
    }

    public RTrackArtist getArtist() {
        return artist;
    }

    public void setArtist(RTrackArtist artist) {
        this.artist = artist;
    }


}
