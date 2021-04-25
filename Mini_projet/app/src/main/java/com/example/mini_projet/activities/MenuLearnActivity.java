package com.example.mini_projet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mini_projet.R;

public class MenuLearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_learn);

        setupToolbar();
        setupMenu();
    }

    private void setupToolbar(){
        final ImageView img_return = findViewById(R.id.img_return);
        img_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void setupMenu(){
        final TextView tv_train=findViewById(R.id.tv_train);

        final Button btn_col=findViewById(R.id.btn_color_game);
        btn_col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final Button btn_num = findViewById(R.id.btn_numbers_game);
        btn_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final Button btn_veh = findViewById(R.id.btn_vehicles_game);
        btn_veh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}