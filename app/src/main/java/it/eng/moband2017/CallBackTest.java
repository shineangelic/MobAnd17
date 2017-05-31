package it.eng.moband2017;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class CallBackTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_back_test);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("TEST","onStart chiamato");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("TEST","onResume chiamato");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("TEST","onRestart chiamato");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("TEST","onPause chiamato");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("TEST","onStop chiamato");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("TEST","onDestroy chiamato");
    }
}
