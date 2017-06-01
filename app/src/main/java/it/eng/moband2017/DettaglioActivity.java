package it.eng.moband2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DettaglioActivity extends Fragment {

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

        return root;
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
