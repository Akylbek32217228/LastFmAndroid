package com.example.lastfmapp.presentation.name.TopArtists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.core.Logger;
import com.example.core.mvp.CoreMvpActivity;
import com.example.lastfmapp.App;
import com.example.lastfmapp.R;
import com.example.lastfmapp.model.ArtistEntity;

import java.util.List;

public class TopArtistsActivity extends CoreMvpActivity<ITopArtistsContract.Presenter>
implements ITopArtistsContract.View{


    @Override
    protected ITopArtistsContract.Presenter providPresenter() {
        return new TopArtistsPresenter(App.artistsRepository);
    }

    @Override
    protected void initView() {
        /*TopArtistsFragment fragment = TopArtistsFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragment)
                .commit();*/
        Logger.d("david");


    }

    @Override
    protected int getActivityId() {
        return R.layout.activity_top_artists;
    }

    @Override
    public void showArtists(List<ArtistEntity> artists) {

    }

    @Override
    public void openArtist(ArtistEntity artist) {

    }




    /*

    */

}
