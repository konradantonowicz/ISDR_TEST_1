package com.example.isdr_test_1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class AdapterSwipeWersety extends FragmentStatePagerAdapter
{

    public AdapterSwipeWersety(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);

    }


    @Override
    public int getCount() {
        return 520;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment_Pokaz_pytania();
        Bundle bundle   =new Bundle();
        bundle.putString("autalna_strona_swipe", String.valueOf(position+1));
        fragment.setArguments(bundle);

        return fragment;
    }



}