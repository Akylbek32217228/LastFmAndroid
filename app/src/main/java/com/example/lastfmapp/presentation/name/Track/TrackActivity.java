package com.example.lastfmapp.presentation.name.Track;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lastfmapp.R;

public class TrackActivity extends AppCompatActivity implements ITrackContract.View{

    ITrackContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        mPresenter = new TrackPresenter();
        mPresenter.attachView(this);
    }


    @Override
    public void finisView() {

    }

    @Override
    public void attachPresenter(ITrackContract.Presenter presenter) {

    }
}
