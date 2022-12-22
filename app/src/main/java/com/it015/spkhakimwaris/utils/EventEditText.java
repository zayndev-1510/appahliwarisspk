package com.it015.spkhakimwaris.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public abstract class EventEditText<T> implements TextWatcher {
    private T target;

    public EventEditText(T target) {
        this.target = target;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
    }

    public abstract void afterTextChanged(T target, Editable s);

}
