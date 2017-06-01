package it.eng.moband2017;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;


public class OpzioniActivity extends AppCompatPreferenceActivity implements Preference.OnPreferenceChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Preference prefGeofencing = findPreference("geofencing");
        prefGeofencing.setOnPreferenceChangeListener(this);

        Preference prefThreshold = findPreference("geofencing_threshold");
        prefThreshold.setOnPreferenceChangeListener(this);

        Preference prefPause = findPreference("timePause");
        prefPause.setOnPreferenceChangeListener(this);

        SharedPreferences miePreferenze = PreferenceManager.getDefaultSharedPreferences(this);
        prefThreshold.setSummary(miePreferenze.getString("geofencing_threshold",""));
        prefPause.setSummary(miePreferenze.getString("timePause",""));

        // di default metto disabled il threshold
        prefThreshold.setEnabled(false);
    }


    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        if (preference.getKey().equals("geofencing")){

            CheckBoxPreference cur =(CheckBoxPreference) preference;
            Preference prefThreshold = findPreference("geofencing_threshold");
            if(cur.isChecked()){
                prefThreshold.setEnabled(true);
            }
            else{
                prefThreshold.setEnabled(false);
            }
        }
        else {

            preference.setSummary((String) newValue);
        }
        return true;
    }
}
