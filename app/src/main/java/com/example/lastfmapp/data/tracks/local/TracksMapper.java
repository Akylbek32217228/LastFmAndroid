package com.example.lastfmapp.data.tracks.local;

import com.example.lastfmapp.data.common.RImage;
import com.example.lastfmapp.model.Artist;
import com.example.lastfmapp.model.Image;
import com.example.lastfmapp.model.Track;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class TracksMapper {

    static RTrack toRTrack(Track track) {
        RealmList<RImage> images = new RealmList<>();
        RTrackArtist trackArtist = new RTrackArtist(track.getArtist().getName(), track.getArtist().getMbid(),
                track.getArtist().getUrl());
        for (Image image : track.getImage()) {
            images.add(new RImage(image.getUrl(), image.getSize()));
        }

        return new RTrack(
                track.getUniqueId(),
                track.getName(),
                track.getUrl(),
                track.getPlaycount(),
                track.getListeners(),
                trackArtist,
                images
        );
    }

    static Track toTrack(RTrack track) {
        ArrayList<Image> images = new ArrayList<>();
        Artist artist = new Artist(track.getArtist().getName(),
                track.getArtist().getMbid(),
                track.getArtist().getUrl());

        for (RImage image : track.getImages()) {
            images.add(new Image(image.getUrl(), image.getSize()));
        }

        return new Track(
                track.getName(),
                artist,
                track.getUrl(),
                track.getPlaycount(),
                track.getListeners(),
                images
        );
    }

    static List<RTrack> toRTracks(List<Track> tracks) {
        ArrayList<RTrack> result = new ArrayList<>();

        for (Track track : tracks) {
            result.add(toRTrack(track));
        }

        return result;
    }

    static List<Track> toTracks(List<RTrack> tracks) {
        ArrayList<Track> result = new ArrayList<>();

        for (RTrack rTrack : tracks) {
            result.add(toTrack(rTrack));
        }

        return result;
    }

}
