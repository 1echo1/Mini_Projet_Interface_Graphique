package com.example.projet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projet.fragments.MenuFrag;
import com.example.projet.R;
import com.example.projet.fragments.MenuLearnFrag;

public class MainActivity extends AppCompatActivity {

    MenuFrag frag_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag_menu= new MenuFrag();

    }
}