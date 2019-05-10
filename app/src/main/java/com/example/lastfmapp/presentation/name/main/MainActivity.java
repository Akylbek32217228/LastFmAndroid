package com.example.lastfmapp.presentation.name.main;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.core.mvp.CoreMvpActivity;
import com.example.lastfmapp.App;
import com.example.lastfmapp.R;
import com.example.lastfmapp.presentation.name.TopArtists.ITopArtistsContract;
import com.example.lastfmapp.presentation.name.TopArtists.TopArtistsActivity;
import com.example.lastfmapp.presentation.name.TopArtists.TopArtistsFragment;
import com.example.lastfmapp.presentation.name.TopArtists.TopArtistsPresenter;
import com.example.lastfmapp.presentation.name.topTracks.ITopTracksContract;
import com.example.lastfmapp.presentation.name.topTracks.TopTracksFragment;
import com.example.lastfmapp.presentation.name.topTracks.TopTracksPresenter;

import java.util.ArrayList;
import java.util.List;

public class  MainActivity extends AppCompatActivity {
    private SectionsPagerAdapter sectionsPagerAdapter;
    TopArtistsFragment topArtistsFragment;
    TopTracksFragment topTracksFragment;
    private ITopTracksContract.Presenter mPresenter;
    private ITopArtistsContract.Presenter artistsPresenter;
    private TabLayout tab;
    public static int i = 0;
    ArrayList<Fragment> list;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        topTracksFragment = TopTracksFragment.newInstance();
        topArtistsFragment = TopArtistsFragment.newInstance();


        /*getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragment)
                .commit();*/

        artistsPresenter = new TopArtistsPresenter(App.artistsRepository);
        artistsPresenter.attachView(topArtistsFragment);
        artistsPresenter.getArtist();
        mPresenter = new TopTracksPresenter(App.tracksRepository);
        mPresenter.attachView(topTracksFragment);
        mPresenter.getTracks();
        //mPresenter.getTracks();

        list = new ArrayList<>();

        list.add(topTracksFragment);
        list.add(topArtistsFragment);

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.container_fragment);
        viewPager.setAdapter(sectionsPagerAdapter);


        tab = findViewById(R.id.tab_dots);
        tab.setupWithViewPager(viewPager, true);


    }


    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {

        }
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_layout, container, false);
            int number = getArguments().getInt(ARG_SECTION_NUMBER);
            TextView textView = (TextView) rootView.findViewById(R.id.text);

            switch (number) {
                case 0:
                    textView.setText("hello");
                    break;
                case 1:
                    textView.setText("how are you");
                    break;
            }

            return rootView;
        }
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
