package it.eng.moband2017;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DettaglioActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.activity_dettaglio, container, false);


        return root;
    }
}
