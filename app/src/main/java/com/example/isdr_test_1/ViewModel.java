package com.example.isdr_test_1;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

public class ViewModel extends android.arch.lifecycle.ViewModel {

    private MutableLiveData<List<DaoPytZazPytPraw>> currentName;

    public MutableLiveData<List<DaoPytZazPytPraw>> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<List<DaoPytZazPytPraw>>();
        }
        return currentName;


}}
