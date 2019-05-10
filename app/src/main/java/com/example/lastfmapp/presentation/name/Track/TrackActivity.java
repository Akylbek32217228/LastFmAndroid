package com.example.lastfmapp.presentation.name.Track;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.core.mvp.CoreMvpActivity;
import com.example.core.mvp.CoreMvpPresenter;
import com.example.core.mvp.ICoreMvpContract;
import com.example.lastfmapp.App;
import com.example.lastfmapp.R;

public class TrackActivity extends CoreMvpActivity<ITrackContract.Presenter> implements ITrackContract.View{

    String track;
    String artist;

    @Override
    protected ITrackContract.Presenter providPresenter() {
        return new TrackPresenter(App.tracksRepository);
    }

    @Override
    protected void initView() {
        track = getIntent().getStringExtra("key_track");
        artist = getIntent().getStringExtra("key_artist");
        //presenter.getTrack(track, artist);
    }

    @Override
    protected int getActivityId() {
        return R.layout.activity_track;
    }
}
