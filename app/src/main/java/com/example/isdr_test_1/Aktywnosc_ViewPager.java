package com.example.isdr_test_1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class Aktywnosc_ViewPager extends AppCompatActivity {
    AdapterSwipeWersety adapterSwipeWersety;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktywnosc__view_pager);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        String numer_pytaniaa = intent.getStringExtra("numer_pytania");
        final ViewPager viewPager = findViewById(R.id.view_pager_pytania);
        viewPager.setOffscreenPageLimit(0);
        adapterSwipeWersety = new AdapterSwipeWersety(getSupportFragmentManager());
        viewPager.setAdapter(adapterSwipeWersety);
        viewPager.setCurrentItem(Integer.parseInt(numer_pytaniaa) - 1);







    }
}
