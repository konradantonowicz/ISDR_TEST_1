package com.example.isdr_test_1;


import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fragment_Pokaz_pytania extends Fragment {
    public Fragment_Pokaz_pytania() { }
    @SuppressLint("DefaultLocale")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final ObslugaBazyDanych mBazaDanych = new ObslugaBazyDanych(getContext());
        View rootView = inflater.inflate(R.layout.fragment_fragment__pokaz_pytania, container, false);
        bazadanych();
        TextView trescpytania = rootView.findViewById(R.id.id_nr_pytan_tresc_pytania);
        final TextView odpa = rootView.findViewById(R.id.id_tv_odpa);
        final TextView odpb = rootView.findViewById(R.id.id_tv_odpb);
        final TextView odpc = rootView.findViewById(R.id.id_tv_odpc);

        trescpytania.setText(String.format("%d  %s", bazadanych().get(0).getNr_pytania(), bazadanych().get(0).getPytanie()));
        odpa.setText(String.format("a) %s", bazadanych().get(0).getOdpowiedzA()));
        odpb.setText(String.format("b) %s", bazadanych().get(0).getOdpowiedzB()));
        odpc.setText(String.format("c) %s", bazadanych().get(0).getOdpowiedzC()));


        if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "a") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "a")) {
            odpa.setTextColor(0xffffff00);
            odpa.setBackgroundColor(0x00000000);
        } else if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "a") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "b")) {
            odpa.setTextColor(0xffff0000);
            odpa.setBackgroundColor(0x00000000);
        } else if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "a") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "c")) {
            odpa.setTextColor(0xffff0000);
            odpa.setBackgroundColor(0x00000000);
        }


        if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "b") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "b")) {
            odpb.setTextColor(0xffffff00);
            odpb.setBackgroundColor(0x00000000);
        } else if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "b") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "c")) {
            odpb.setTextColor(0xffff0000);
            odpb.setBackgroundColor(0x00000000);
        } else if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "b") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "a")) {
            odpb.setTextColor(0xffff0000);
            odpb.setBackgroundColor(0x00000000);
        }


        if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "c") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "c")) {
            odpc.setTextColor(0xffffff00);
            odpc.setBackgroundColor(0xff000000);
        } else if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "c") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "b")) {
            odpc.setTextColor(0xffff0000);
            odpc.setBackgroundColor(0xff000000);

        } else if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "c") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "a")) {
            odpc.setTextColor(0xffff0000);
            odpc.setBackgroundColor(0xff000000);

        }


        odpa.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {


                mBazaDanych.updateOdpowiedz(String.valueOf(bazadanych().get(0).getNr_pytania()), "a");
                bazadanych();

                if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "a") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "a")) {
                    odpa.setTextColor(0xffffff00);
                    odpa.setBackgroundColor(0x00000000);
                } else if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "a") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "b")) {
                    odpa.setTextColor(0xffff0000);
                    odpa.setBackgroundColor(0x00000000);
                } else if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "a") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "c")) {
                    odpa.setTextColor(0xffff0000);
                    odpa.setBackgroundColor(0x00000000);
                }
                odpa.setBackgroundColor(0x00000000);
                odpb.setBackgroundColor(0x00000000);
                odpc.setBackgroundColor(0x00000000);
                odpb.setTextColor(0xffffffff);
                odpc.setTextColor(0xffffffff);


            }
        });
        odpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mBazaDanych.updateOdpowiedz(String.valueOf(bazadanych().get(0).getNr_pytania()), "b");
                bazadanych();
                if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "b") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "b")) {
                    odpb.setTextColor(0xffffff00);
                    odpb.setBackgroundColor(0x00000000);
                } else if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "b") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "c")) {
                    odpb.setTextColor(0xffff0000);
                    odpb.setBackgroundColor(0x00000000);
                } else if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "b") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "a")) {
                    odpb.setTextColor(0xffff0000);
                    odpb.setBackgroundColor(0x00000000);
                }

                odpb.setBackgroundColor(0x00000000);
                odpa.setBackgroundColor(0x00000000);
                odpc.setBackgroundColor(0x00000000);
                odpa.setTextColor(0xffffffff);
                odpc.setTextColor(0xffffffff);



            }
        });
        odpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBazaDanych.updateOdpowiedz(String.valueOf(bazadanych().get(0).getNr_pytania()), "c");
                bazadanych();
                if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "c") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "c")) {
                    odpc.setTextColor(0xffffff00);
                    odpc.setBackgroundColor(0x00000000);
                } else if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "c") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "b")) {
                    odpc.setTextColor(0xffff0000);
                    odpc.setBackgroundColor(0x00000000);

                } else if (Objects.equals(bazadanych().get(0).getOdpowiedzZaznaczona(), "c") && Objects.equals(bazadanych().get(0).getOdpowiedzPrawidlowa(), "a")) {
                    odpc.setTextColor(0xffff0000);
                    odpc.setBackgroundColor(0x00000000);

                }

                odpc.setBackgroundColor(0x00000000);
                odpb.setBackgroundColor(0x00000000);
                odpa.setBackgroundColor(0x00000000);
                odpa.setTextColor(0xffffffff);
                odpb.setTextColor(0xffffffff);
            }
        });


        return rootView;
    }

    private List<PytaniaDao> bazadanych()
    {
        List<PytaniaDao> ListaPytan = new ArrayList<>();
        final ObslugaBazyDanych mBazaDanych = new ObslugaBazyDanych(getContext());
        Bundle bundle = getArguments();
        assert bundle != null;
        String numer_pytania = bundle.getString("autalna_strona_swipe");
        String mySQL = "select Nr_pytania,Pytanie,OdpowiedzA,OdpowiedzB,OdpowiedzC,OdpowiedzPrawidlowa,Odpowiedz_zaznaczona from Pytania where Nr_pytania = ?";
        String[] pytanie = {numer_pytania};


        Cursor k = mBazaDanych.Cursor_wyswietl_pytaniaiodp(pytanie, mySQL);


        mBazaDanych.openDatabase();
        k.moveToPosition(0);
        Integer Numer_pytania = k.getInt(0);
        String Tresc_pytania = k.getString(1);
        String Tresc_odpA = k.getString(2);
        String Tresc_odpB = k.getString(3);
        String Tresc_odpC = k.getString(4);
        String Tresc_odpPrawidlowa = k.getString(5);
        String Tresc_odpZaznaczona = k.getString(6);

        PytaniaDao pytaniaDao = new PytaniaDao(Numer_pytania, Tresc_pytania, Tresc_odpA, Tresc_odpB, Tresc_odpC, Tresc_odpPrawidlowa, Tresc_odpZaznaczona);

        ListaPytan.add(pytaniaDao);


        k.close();
        mBazaDanych.closeDatabase();
        return ListaPytan;
    }

}




