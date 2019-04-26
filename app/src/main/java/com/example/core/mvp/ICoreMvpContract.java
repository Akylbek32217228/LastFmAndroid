package com.example.core.mvp;

public interface ICoreMvpContract {

    interface View<T extends Presenter> {

        void finisView();

        void attachPresenter(T presenter);

    }

    interface Presenter<T extends View> {

        void attachView(T view);

        void detachView();

    }

}
