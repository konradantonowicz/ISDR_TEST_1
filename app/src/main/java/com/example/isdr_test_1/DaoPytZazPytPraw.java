package com.example.isdr_test_1;

class DaoPytZazPytPraw
{

    private String Odpowiedzprawidlowa,Odpowiedzzaznaczona;

    String getOdpowiedzPrawidlowa() {return Odpowiedzprawidlowa;}
    String getOdpowiedzZaznaczona() {return Odpowiedzzaznaczona;}




    DaoPytZazPytPraw(String odpowiedzprawidlowa, String odpowiedzzaznaczona) {

        Odpowiedzprawidlowa=odpowiedzprawidlowa;
        Odpowiedzzaznaczona=odpowiedzzaznaczona;
    }



    public DaoPytZazPytPraw(DaoPytZazPytPraw favourites) {
        Odpowiedzprawidlowa = favourites.Odpowiedzprawidlowa;
        Odpowiedzzaznaczona = favourites.Odpowiedzzaznaczona;

    }


}
