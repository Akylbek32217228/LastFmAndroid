package com.example.lastfmapp.presentation.track;

import android.app.Activity;
import android.content.Intent;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.core.mvp.CoreMvpActivity;
import com.example.lastfmapp.App;
import com.example.lastfmapp.R;
import com.example.lastfmapp.model.Track;

public class TrackActivity extends CoreMvpActivity<ITrackContract.Presenter> implements ITrackContract.View{

    TextView trackName;
    TextView artistName;
    TextView textViewLyrics;
    ProgressBar progressBar;
    private static final String EXTRA_TRACK_UNIQUEID = "unique_id";

    @Override
    protected ITrackContract.Presenter providePresenter() {
        return new TrackPresenter(App.tracksRepository, App.lyricsRepository, getTrackUniqueId(getIntent()),
                getArtistName(getIntent()), getTrackName(getIntent()));
    }

    public static void start(
            Activity activity,
            String uniqueId,
            String artistName,
            String trackName
    ) {
        Intent intent = new Intent(activity, TrackActivity.class);

        intent.putExtra(EXTRA_TRACK_UNIQUEID, uniqueId);
        intent.putExtra("artistName", artistName);
        intent.putExtra("trackName", trackName);

        activity.startActivity(intent);
    }

    private static String getTrackUniqueId(Intent intent) {
        return intent.getStringExtra(EXTRA_TRACK_UNIQUEID);
    }

    private static String getTrackName(Intent intent) {
        return intent.getStringExtra("trackName");
    }

    private static String getArtistName(Intent intent) {
        return intent.getStringExtra("artistName");
    }
    @Override
    protected void initView() {
        trackName = findViewById(R.id.track_name);
        artistName = findViewById(R.id.artist_name);
        textViewLyrics = findViewById(R.id.track_lyrics);
        progressBar = findViewById(R.id.activity_track_progress_bar);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_track;
    }

    @Override
    public void showTrack(Track track) {
        trackName.setText(track.getName());
        artistName.setText(track.getArtist().getName());
    }

    @Override
    public void showLyrics(String lyrics) {
        textViewLyrics.setText(lyrics);
    }

    @Override
    public void setVisibility(boolean visible) {
        if ( visible) {
            progressBar.setVisibility(ProgressBar.VISIBLE);
        } else {
            progressBar.setVisibility(ProgressBar.INVISIBLE);
        }

    }

}
