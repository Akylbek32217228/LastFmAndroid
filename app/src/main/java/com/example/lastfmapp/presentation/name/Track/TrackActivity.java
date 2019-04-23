package com.example.lastfmapp.presentation.name.Track;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lastfmapp.R;
import com.example.lastfmapp.presentation.name.BaseInterface.BaseInterface;

public class TrackActivity extends AppCompatActivity implements TrackContract.View{

    TrackContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        mPresenter = new TrackPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void finishView() {

    }

    @Override
    public void attachPresenter(BaseInterface.Presenter presenter) {

    }


}