package com.example.core.mvp;

public interface CoreCallback<T> {

    void onSucces(T result);

    void onFailure(String message);
}
