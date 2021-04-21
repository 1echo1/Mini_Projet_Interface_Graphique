package com.example.mini_projet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mini_projet.R;
import com.example.mini_projet.utils.LocaleHelper;

///////////////////////////////////////
//
//Lien vers github: https://github.com/1echo1/Mini_Projet_Interface_Graphique
//
//////////////////////////////////////


public class MenuTrainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_train);

        setupMenu();
    }

    public void setupMenu(){
        final TextView tv_train=findViewById(R.id.tv_train);

        final Button btn_col=findViewById(R.id.btn_color_game);
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

        final Button btn_veh = findViewById(R.id.btn_vehicles_game);
        btn_veh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVehicleGame();
            }
        });

    }

    public void openColorGame(){
        Intent intent= new Intent(this, ColorGameActivity.class);
        intent.putExtra("locale",LocaleHelper.getLanguage(MenuTrainActivity.this));
        startActivity(intent);
    }

    public void openNumbersGame(){
        Intent intent= new Intent(this, NumbersGameActivity.class);
        intent.putExtra("locale",LocaleHelper.getLanguage(MenuTrainActivity.this));
        startActivity(intent);
    }

    public void openVehicleGame(){
        Intent intent= new Intent(this, VehiclesGameActivity.class);
        intent.putExtra("locale",LocaleHelper.getLanguage(MenuTrainActivity.this));
        startActivity(intent);
    }


}