package com.example.day4.util;

public interface NetCallBack<T> {
    public void onSuccess(T t);

    public void onFail(String error);
}
