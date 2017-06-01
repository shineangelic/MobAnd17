package it.eng.moband2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

public class DettaglioActivity extends Fragment {

    DBManager dbManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_dettaglio, container, false);
        dbManager = new DBManager(getActivity());
        return root;
    }

    public void inserisciGiorno(View view){
        Giorno newGiorno = new Giorno();

        // ora entrata
        TextView appoTextViewIn = (TextView) getActivity().findViewById(R.id.editText);

        String appoDayin = appoTextViewIn.getText().toString();
        int indiceIn = appoDayin.indexOf(":");
        Calendar today = Calendar.getInstance();
                today.set(Calendar.HOUR_OF_DAY,Integer.valueOf(appoDayin.substring(0,indiceIn)));
                today.set(Calendar.MINUTE,Integer.valueOf(appoDayin.substring(indiceIn+1)));
        Log.w("DATAIN", "Setto data in a: "+ today.getTime().toString());
        newGiorno.setIn_dt_time(today.getTime().getTime());

        // ora uscita
        TextView appoTextViewOut = (TextView) getActivity().findViewById(R.id.editText4);

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
