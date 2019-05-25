package com.example.lastfmapp.presentation.track;

import com.example.core.Logger;
import com.example.core.mvp.CoreMvpPresenter;
import com.example.lastfmapp.data.lyrics.ILyricsRepository;
import com.example.lastfmapp.data.tracks.ITracksRepository;
import com.example.lastfmapp.model.Track;

public class TrackPresenter extends CoreMvpPresenter<ITrackContract.View> implements ITrackContract.Presenter {

    private ITracksRepository repositoryTrack;
    private ILyricsRepository repositoryLyric;
    private String uniqueId;
    private String artistName;
    private String trackName;

    public TrackPresenter(ITracksRepository repositoryTrack, ILyricsRepository repositoryLyric, String uniqueId,
                          String artistName,
                          String trackName) {
        this.repositoryTrack = repositoryTrack;
        this.uniqueId = uniqueId;
        this.repositoryLyric = repositoryLyric;
        this.artistName = artistName;
        this.trackName = trackName;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        Logger.d("fdfdfdddddddddfdfdfdfdfdfdfdfdfdfd");
        loadTrack();

    }

    @Override
    public void loadTrack() {
        Logger.d(artistName +  " " + trackName);
        repositoryTrack.getTrack(uniqueId, artistName, trackName, new ITracksRepository.TrackCallback() {
            @Override
            public void onSucces(Track result) {
                if ( mView != null) {
                    mView.showTrack(result);

                    repositoryLyric.getLyrics(result.getArtist().getName(), result.getName(),
                            new ILyricsRepository.LyricsCallback() {
                                @Override
                                public void onSucces(String result) {
                                    if ( mView != null) {
                                        mView.showLyrics(result);
                                        mView.setVisibility(false);
                                    }
                                }

                                @Override
                                public void onFailure(String message) {
                                    mView.setVisibility(false);
                                }
                            });
                }
            }

            @Override
            public void onFailure(String message) {
                Logger.d("Fail load track!");
            }
        });



    }
}
