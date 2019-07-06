package com.example.isdr_test_1;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ObslugaBazyDanych extends SQLiteOpenHelper
{
    public static final String DBNAME = "BazaDanychPytan.db";
    public static final String DBLOCATION = "/data/data/com.example.isdr_test_1/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;
    public ObslugaBazyDanych(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }
    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }}


    public List<DaoPytZazPytPraw> Lista_wyswietl_odpPraw_odpZaz()
    {
        openDatabase();
        DaoPytZazPytPraw pytaniaDao = null;
        List<DaoPytZazPytPraw> ListaOdpPrawZaz = new ArrayList<>();

        Cursor k = mDatabase.rawQuery("select OdpowiedzPrawidlowa,Odpowiedz_zaznaczona from Pytania",null);
        k.moveToFirst();
        while (!k.isAfterLast())
        {
            String Tresc_odpPrawidlowa = k.getString(0);
            String Tresc_odpZaznaczona = k.getString(1);

            pytaniaDao = new DaoPytZazPytPraw(Tresc_odpPrawidlowa,Tresc_odpZaznaczona);

            ListaOdpPrawZaz.add(pytaniaDao);
            k.moveToNext();
        }
        k.close();
        closeDatabase();


        return ListaOdpPrawZaz;
    }

    public Cursor Cursor_wyswietl_pytaniaiodp(String [] nrpytania,String mySQL) {
        openDatabase();
        return mDatabase.rawQuery(mySQL,nrpytania);
    }

    public long updateOdpowiedz(String numer_pytania, String kliknieta_odp) {
        int number = Integer.parseInt(numer_pytania);

        openDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Odpowiedz_zaznaczona",kliknieta_odp);
        String whereClause = "Nr_pytania" + " = ?";
        String[] w_ktorym_wierszu_usunac ={Integer.toString(number)};
        long returnValue =  mDatabase.update("Pytania",contentValues,whereClause,w_ktorym_wierszu_usunac);

        closeDatabase();
        return returnValue;
    }

}