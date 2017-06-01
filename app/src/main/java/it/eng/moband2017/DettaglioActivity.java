package it.eng.moband2017;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class DettaglioActivity extends AppCompatActivity {

    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettaglio);

        dbManager = new DBManager(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_cart){
            Intent opzioni = new Intent(this, OpzioniActivity.class);
            startActivity(opzioni);
        }
        return super.onOptionsItemSelected(item);
    }

    public void inserisciGiorno(View view){
        Giorno newGiorno = new Giorno();

        // ora entrata
        TextView appoTextViewIn = (TextView) findViewById(R.id.editText);

        String appoDayin = appoTextViewIn.getText().toString();
        int indiceIn = appoDayin.indexOf(":");
        Calendar today = Calendar.getInstance();
                today.set(Calendar.HOUR_OF_DAY,Integer.valueOf(appoDayin.substring(0,indiceIn)));
                today.set(Calendar.MINUTE,Integer.valueOf(appoDayin.substring(indiceIn+1)));
        Log.w("DATAIN", "Setto data in a: "+ today.getTime().toString());
        newGiorno.setIn_dt_time(today.getTime().getTime());

        // ora uscita
        TextView appoTextViewOut = (TextView) findViewById(R.id.editText4);

        appoDayin = appoTextViewOut.getText().toString();
        indiceIn = appoDayin.indexOf(":");
        today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY,Integer.valueOf(appoDayin.substring(0,indiceIn)));
        today.set(Calendar.MINUTE,Integer.valueOf(appoDayin.substring(indiceIn+1)));
        Log.w("DATAOUT", "Setto data out a: "+ today.getTime().toString());
        newGiorno.setOut_dt_time(today.getTime().getTime());

        dbManager.saveGiorno(newGiorno);
    }
}
