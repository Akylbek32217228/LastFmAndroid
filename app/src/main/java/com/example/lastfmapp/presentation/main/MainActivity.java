package com.example.lastfmapp.presentation.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lastfmapp.App;
import com.example.lastfmapp.R;
import com.example.lastfmapp.presentation.topArtists.ITopArtistsContract;
import com.example.lastfmapp.presentation.topArtists.TopArtistsFragment;
import com.example.lastfmapp.presentation.topArtists.TopArtistsPresenter;
import com.example.lastfmapp.presentation.topTracks.ITopTracksContract;
import com.example.lastfmapp.presentation.topTracks.TopTracksFragment;
import com.example.lastfmapp.presentation.topTracks.TopTracksPresenter;

import java.util.ArrayList;

public class  MainActivity extends AppCompatActivity {
    private SectionsPagerAdapter sectionsPagerAdapter;
    TopArtistsFragment topArtistsFragment;
    TopTracksFragment topTracksFragment;
    private ITopTracksContract.Presenter mPresenter;
    private ITopArtistsContract.Presenter artistsPresenter;
    private TabLayout tab;
    ArrayList<Fragment> list;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        topTracksFragment = TopTracksFragment.newInstance();
        topArtistsFragment = TopArtistsFragment.newInstance();


        artistsPresenter = new TopArtistsPresenter(App.artistsRepository);
        artistsPresenter.attachView(topArtistsFragment);
        mPresenter = new TopTracksPresenter(App.tracksRepository);
        mPresenter.attachView(topTracksFragment);

        list = new ArrayList<>();

        list.add(topTracksFragment);
        list.add(topArtistsFragment);

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.container_fragment);
        viewPager.setAdapter(sectionsPagerAdapter);


        tab = findViewById(R.id.tab_dots);
        tab.setupWithViewPager(viewPager, true);

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }


        @Override
        public int getCount() {
            return list.size();
        }
    }
}
