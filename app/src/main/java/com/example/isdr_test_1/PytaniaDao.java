package com.example.isdr_test_1;

class PytaniaDao
{
    Integer getNr_pytania() {
        return Nr_pytania;
    }

    String getPytanie() {
        return Pytanie;
    }

    String getOdpowiedzA() {
        return OdpowiedzA;
    }

    String getOdpowiedzB() {
        return OdpowiedzB;
    }

    String getOdpowiedzC() {
        return OdpowiedzC;
    }
    String getOdpowiedzPrawidlowa() {return Odpowiedzprawidlowa;}
    String getOdpowiedzZaznaczona() {return Odpowiedzzaznaczona;}


    PytaniaDao(Integer nr_pytania, String pytanie, String odpowiedzA, String odpowiedzB, String odpowiedzC, String odpowiedzprawidlowa, String odpowiedzzaznaczona) {
        Nr_pytania = nr_pytania;
        Pytanie = pytanie;
        OdpowiedzA = odpowiedzA;
        OdpowiedzB = odpowiedzB;
        OdpowiedzC = odpowiedzC;
        Odpowiedzprawidlowa=odpowiedzprawidlowa;
        Odpowiedzzaznaczona=odpowiedzzaznaczona;
    }

    private String Pytanie,OdpowiedzA,OdpowiedzB,OdpowiedzC,Odpowiedzprawidlowa,Odpowiedzzaznaczona;
    private Integer Nr_pytania;



}
