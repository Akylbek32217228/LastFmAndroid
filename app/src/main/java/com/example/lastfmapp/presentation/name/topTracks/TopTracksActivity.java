package com.example.lastfmapp.presentation.name.topTracks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.example.lastfmapp.R;
import com.example.lastfmapp.model.TrackEntity;
import com.example.lastfmapp.presentation.name.BaseInterface.BaseInterface;

import java.util.List;

public class TopTracksActivity extends AppCompatActivity
    implements TopTracksContract.View{

    private TopTracksContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_tracks);

        mPresenter = new TopTracksPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showTracks(List<TrackEntity> tracks) {

    }

    @Override
    public void openTrack(TrackEntity track) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void finishView() {

    }

    @Override
    public void attachPresenter(BaseInterface.Presenter presenter) {

    }
}
