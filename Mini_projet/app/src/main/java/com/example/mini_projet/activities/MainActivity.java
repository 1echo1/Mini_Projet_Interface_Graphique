package com.example.mini_projet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.mini_projet.R;
import com.example.mini_projet.models.LocaleHelper;

import java.time.format.ResolverStyle;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupMenu();
    }

    public void setupMenu(){
        final Button btn_col=findViewById(R.id.btn_color_game);
        final Button btn_veh = findViewById(R.id.btn_vehicles_game);


        btn_col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorGame();
            }
        });

        final Button btn_num = findViewById(R.id.btn_numbers_game);
        btn_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNumbersGame();
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.languages_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Context context;
                Resources resources;

                switch (pos) {
                    case 0:
                        context = LocaleHelper.setLocale(MainActivity.this, "en");
                        resources = context.getResources();

                        break;
                    default:
                        context = LocaleHelper.setLocale(MainActivity.this, "fr");
                        resources = context.getResources();
                        break;
                }
                btn_col.setText(resources.getString(R.string.btn_colors));
                btn_num.setText(resources.getString(R.string.btn_numbers));
                btn_veh.setText(resources.getString(R.string.btn_vehicles));
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void openColorGame(){
        Intent intent= new Intent(this, ColorGameActivity.class);
        intent.putExtra("locale",LocaleHelper.getLanguage(MainActivity.this));
        startActivity(intent);
    }

    public void openNumbersGame(){
        Intent intent= new Intent(this, NumbersGameActivity.class);
        intent.putExtra("locale",LocaleHelper.getLanguage(MainActivity.this));
        startActivity(intent);
    }



}