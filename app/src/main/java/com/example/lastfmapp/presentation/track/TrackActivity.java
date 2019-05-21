package com.example.lastfmapp.presentation.track;

import android.app.Activity;
import android.content.Intent;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.core.Logger;
import com.example.core.mvp.CoreMvpActivity;
import com.example.lastfmapp.App;
import com.example.lastfmapp.R;
import com.example.lastfmapp.model.Track;

public class TrackActivity extends CoreMvpActivity<ITrackContract.Presenter> implements ITrackContract.View{

    TextView trackName;
    TextView artistName;
    TextView textViewLyrics;
    ProgressBar progressBar;
    private static final String EXTRA_TRACK_ID = "track_id";
    private static final String EXTRA_TRACK_UNIQUEID = "unique_id";

    @Override
    protected ITrackContract.Presenter providePresenter() {
        return new TrackPresenter(App.tracksRepository, App.lyricsRepository, getTrackUniqueId(getIntent()));
    }

    public static void start(
            Activity activity,
            String uniqueId
    ) {
        Intent intent = new Intent(activity, TrackActivity.class);

        intent.putExtra(EXTRA_TRACK_UNIQUEID, uniqueId);

        activity.startActivity(intent);
    }

    private static String getTrackUniqueId(Intent intent) {
        return intent.getStringExtra(EXTRA_TRACK_UNIQUEID);
    }

    @Override
    protected void initView() {
        //presenter.getTrack(track, artist);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
