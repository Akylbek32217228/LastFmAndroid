package com.example.lastfmapp.presentation.name.BaseInterface;

public interface BaseInterface {

    interface View {

        void finishView();

        void attachPresenter(Presenter presenter );

    }

    interface Presenter {

        void attachView(View view);

        void detachView();

    }

}
