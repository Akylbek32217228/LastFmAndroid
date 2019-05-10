package com.example.lastfmapp.presentation.name.Artist;

import com.example.core.mvp.CoreMvpActivity;
import com.example.lastfmapp.App;
import com.example.lastfmapp.R;


public class ArtistActivity extends CoreMvpActivity<IArtistContract.Presenter> implements IArtistContract.View {


    @Override
    protected IArtistContract.Presenter providPresenter() {
        return new ArtistPresenter(App.artistsRepository);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getActivityId() {
        return R.layout.activity_artist;
    }
}
