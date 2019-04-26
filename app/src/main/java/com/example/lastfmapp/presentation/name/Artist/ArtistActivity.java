package com.example.lastfmapp.presentation.name.Artist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lastfmapp.R;


public class ArtistActivity extends AppCompatActivity implements IArtistContract.View {

    private IArtistContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        mPresenter = new ArtistPresenter();
        mPresenter.attachView(this);
    }


    @Override
    public void finisView() {

    }

    @Override
    public void attachPresenter(IArtistContract.Presenter presenter) {

    }
}
