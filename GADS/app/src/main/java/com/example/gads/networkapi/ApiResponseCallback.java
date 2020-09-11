package com.example.gads.networkapi;

public interface ApiResponseCallback<T> {
    void onResponse(T response);
    void onError(Throwable error);
}
