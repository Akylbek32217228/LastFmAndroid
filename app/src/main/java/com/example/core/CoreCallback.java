package com.example.core;

public interface CoreCallback<T> {

    void onSucces(T result);

    void onFailure(String message);
}
