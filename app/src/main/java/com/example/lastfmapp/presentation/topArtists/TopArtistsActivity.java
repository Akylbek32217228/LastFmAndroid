package com.example.lastfmapp.presentation.topArtists;

import com.example.core.Logger;
import com.example.core.mvp.CoreMvpActivity;
import com.example.lastfmapp.App;
import com.example.lastfmapp.R;
import com.example.lastfmapp.model.Artist;

import java.util.List;

public class TopArtistsActivity extends CoreMvpActivity<ITopArtistsContract.Presenter>
implements ITopArtistsContract.View{


    @Override
    protected ITopArtistsContract.Presenter providePresenter() {
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
    protected int getLayoutId() {
        return R.layout.activity_top_artists;
    }

    @Override
    public void showArtists(List<Artist> artists) {

    }

    @Override
    public void openArtist(Artist artist) {

    }
}
