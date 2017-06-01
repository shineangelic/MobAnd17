package it.eng.moband2017;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        EditText pippo = (EditText) findViewById(R.id.editText3);
        String appoPippo = String.valueOf(pippo.getText());

        if (appoPippo.equals("mappa")){
            Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                Toast.makeText(this,"Provo a caricare la mappa!",Toast.LENGTH_SHORT).show();
                startActivity(mapIntent);
            }
            else{
                Toast.makeText(this,"App Maps non disponibile!",Toast.LENGTH_SHORT).show();
            }
        }
        else if (appoPippo.equals("foto")){
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
        else{
            Toast.makeText(this,pippo.getText(),Toast.LENGTH_SHORT).show();
            Intent chiamoTest = new Intent(this, CallBackTest.class);
            startActivity(chiamoTest);
        }

    }

    public void showDettaglio(View view){
        Intent chiamodettaglio = new Intent(this, DettaglioActivity.class);
        startActivity(chiamodettaglio);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            ImageView mImg;
            mImg = (ImageView) findViewById(R.id.mImageView);
            mImg.setImageBitmap(imageBitmap);

        }
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
}
