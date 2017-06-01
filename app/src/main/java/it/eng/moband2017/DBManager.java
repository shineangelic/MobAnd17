package it.eng.moband2017;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "moband17";

    // Characters table name
    private static final String TABLE_GIORNI = "Giorni";

    // Characters Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_IN_DT_TIME = "in_dt_time";
    private static final String KEY_OUT_DT_TIME = "out_dt_time";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CHARACTERS_TABLE = "CREATE TABLE " + TABLE_GIORNI + "("
                + KEY_ID + " LONG PRIMARY KEY,"
                + KEY_IN_DT_TIME + " NUMBER,"
                + KEY_OUT_DT_TIME + " NUMBER" + ")";
        db.execSQL(CREATE_CHARACTERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GIORNI);
        // Creating tables again
        onCreate(db);
    }



    // ------------------------------------------------------------------------------------
    // METODI DELETE
    // ------------------------------------------------------------------------------------
    // Deleting a character
    public void deleteShop(Giorno giorno) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_GIORNI, KEY_ID + " = ?",
                new String[] { String.valueOf(giorno.getId()) });
        db.close();
    }



    // ------------------------------------------------------------------------------------
    // METODI INSERT
    // ------------------------------------------------------------------------------------
    // Creo nuovo Giorno
    public int saveGiorno(Giorno giorno) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IN_DT_TIME, giorno.getIn_dt_time());
        values.put(KEY_OUT_DT_TIME, giorno.getOut_dt_time());

        Log.i("DBManager","Giorno creato");
int ritorno = 0;
        // Inserting Row
        try{
            db.insert(TABLE_GIORNI, null, values);

        }catch (Exception e){
            ritorno = 1;
        }
        db.close(); // Closing database connection
        return ritorno;
    }



    // ------------------------------------------------------------------------------------
    // METODI UPDATE
    // ------------------------------------------------------------------------------------
    // Update giorno
    public int updateGiorno(Giorno giorno) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IN_DT_TIME, giorno.getIn_dt_time());
        values.put(KEY_OUT_DT_TIME, giorno.getOut_dt_time());

        // updating row
        return db.update(TABLE_GIORNI, values, KEY_ID + " = ?",
                new String[]{String.valueOf(giorno.getId())});
    }



    // ------------------------------------------------------------------------------------
    // METODI SELECT
    // ------------------------------------------------------------------------------------
    // Lista di tutti i Giorni
    public List<Giorno> getListaGiorni () {
        Log.d("DBManager","Entrato in lista");
        List<Giorno> giornoList = new ArrayList<Giorno>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_GIORNI;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Giorno giorno = new Giorno();
                giorno.setId(Integer.parseInt(cursor.getString(0)));
                giorno.setIn_dt_time(Integer.parseInt(cursor.getString(1)));
                giorno.setOut_dt_time(Integer.parseInt(cursor.getString(2)));

                // Adding contact to list
                giornoList.add(giorno);
            } while (cursor.moveToNext());
        }

        cursor.close();
        // return giorno list
        return giornoList;
    }
}
