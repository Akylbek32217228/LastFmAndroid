package com.example.lastfmapp.presentation.main;

import android.support.annotation.Nullable;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TopTracksFragment topTracksFragment = TopTracksFragment.newInstance();
        TopArtistsFragment topArtistsFragment = TopArtistsFragment.newInstance();


        ITopArtistsContract.Presenter artistsPresenter = new TopArtistsPresenter(App.artistsRepository);
        artistsPresenter.attachView(topArtistsFragment);
        ITopTracksContract.Presenter mPresenter = new TopTracksPresenter(App.tracksRepository);
        mPresenter.attachView(topTracksFragment);

        ArrayList<Fragment> list = new ArrayList<>();

        list.add(topTracksFragment);
        list.add(topArtistsFragment);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), list);
        ViewPager viewPager = findViewById(R.id.container_fragment);
        viewPager.setAdapter(sectionsPagerAdapter);


        TabLayout tab = findViewById(R.id.tab_dots);
        tab.setupWithViewPager(viewPager, true);

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> list;
        public SectionsPagerAdapter(FragmentManager fm , ArrayList<Fragment> list) {
            super(fm);
            this.list = list;
        }

        String[] titles = {"Top Tracks", "Top Artists"};

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }


        @Override
        public int getCount() {
            return list.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
