package com.example.lastfmapp.presentation.name.Artist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lastfmapp.R;
import com.example.lastfmapp.presentation.name.BaseInterface.BaseInterface;


public class ArtistActivity extends AppCompatActivity implements ArtistContract.View {

    private ArtistContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        mPresenter = new ArtistPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void finishView() {

    }

    @Override
    public void attachPresenter(BaseInterface.Presenter presenter) {

    }


}
