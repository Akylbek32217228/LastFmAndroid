package com.example.lastfmapp.presentation.name.Artist;

import com.example.core.mvp.ICoreMvpContract;

public interface IArtistContract {

    interface View extends ICoreMvpContract.View<Presenter> {

    }


    interface Presenter  extends ICoreMvpContract.Presenter<View>{


    }
}
