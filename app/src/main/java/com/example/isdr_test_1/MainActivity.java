package com.example.isdr_test_1;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Klik_na_Numer_Pytania{
    ObslugaBazyDanych   mObslugaBazyDanych;
    RecyclerView recyclerView;
    private List<DaoPytZazPytPraw> mFav;
    AdapterRecycler adapterRecycler;
    private ViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mObslugaBazyDanych = new ObslugaBazyDanych(this);
        sprawdz_warunek();
        model = ViewModelProviders.of(this).get(ViewModel.class);

        recyclerView = findViewById(R.id.id_listaRecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,6));
        adapterRecycler = new AdapterRecycler(this, mObslugaBazyDanych.Lista_wyswietl_odpPraw_odpZaz());
        recyclerView.setAdapter(adapterRecycler);
        adapterRecycler.ustawSluchaczaKlikniecia(this);

        final Observer<List<DaoPytZazPytPraw>> favsObserver = new Observer<List<DaoPytZazPytPraw>>() {
            @Override
            public void onChanged(@Nullable List<DaoPytZazPytPraw> updatedList) {

                mFav = updatedList;
                assert mFav != null;
                adapterRecycler.addItems(mFav);


            }

        };

        model.getCurrentName().observe(this,favsObserver);




    }
        private void sprawdz_warunek()
        {
            mObslugaBazyDanych = new ObslugaBazyDanych(this);
            File database = getApplicationContext().getDatabasePath(ObslugaBazyDanych.DBNAME);
            if (!database.exists()) {
                mObslugaBazyDanych.getReadableDatabase();
                mObslugaBazyDanych.closeDatabase();
                if (copyDatabase(this)) {
                    Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                }
            }
        }




        private boolean copyDatabase(Context context) {
            try {
                InputStream inputStream = context.getAssets().open(ObslugaBazyDanych.DBNAME);
                String outFileName = ObslugaBazyDanych.DBLOCATION + ObslugaBazyDanych.DBNAME;
                OutputStream outputStream = new FileOutputStream(outFileName);
                byte[] buff = new byte[1024];
                int length;
                while ((length = inputStream.read(buff)) > 0) {
                    outputStream.write(buff, 0, length);
                }
                outputStream.flush();
                outputStream.close();
                Log.w("MainActivity", "DB copied");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

    @Override
    public void klik_na_numerze_pytania(String NumerPytania) {
        Intent intent = new Intent(getApplicationContext(),Aktywnosc_ViewPager.class);
        intent.putExtra("numer_pytania",NumerPytania);
        startActivity(intent);
    }
    public void onResume()
    {
        super.onResume();
        model.getCurrentName().setValue(mObslugaBazyDanych.Lista_wyswietl_odpPraw_odpZaz());
    }

}
