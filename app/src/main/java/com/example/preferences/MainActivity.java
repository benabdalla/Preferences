
package com.example.preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {
    private static final String tag = "MainActivity";

    private SharedPreferences prefs;
    private SharedPreferences.Editor myedt;
    private EditText name, password;
    private Button btn;
    private CheckBox chek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameet);
        password = findViewById(R.id.password);
        chek = findViewById(R.id.check);
        btn = findViewById(R.id.log);
        prefs = getPreferences(Context.MODE_PRIVATE);
        myedt=prefs.edit();
        checkSharedPreferences();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chek.isChecked()) {
                    myedt.putString(getString(R.string.chekbox), "true");
                    myedt.apply();
                    String passwordd = password.getText().toString();
                    myedt.putString(getString(R.string.pass), passwordd);
                    myedt.apply();
                    String named = name.getText().toString();
                    myedt.putString(getString(R.string.nom), named);
                    myedt.apply();

                } else {

                    myedt.putString(getString(R.string.chekbox), "flase");
                    myedt.apply();


                    myedt.putString(getString(R.string.pass), "");
                    myedt.apply();

                    myedt.putString(getString(R.string.nom), "");
                    myedt.apply();
                }
            }
        });


    }

    private void checkSharedPreferences() {
        String chekp = prefs.getString(getString(R.string.chekbox), "false");
        String namep = prefs.getString(getString(R.string.nom), "");
        String passwordp = prefs.getString(getString(R.string.pass), "");


        name.setText(namep);
        password.setText(passwordp);
        if (chekp.equals("true")) {
            chek.setChecked(true);
        } else {
            chek.setChecked(false);
        }


    }
}