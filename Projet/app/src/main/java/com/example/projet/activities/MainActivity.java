package com.example.projet.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.projet.fragments.MenuFrag;
import com.example.projet.R;
import com.example.projet.fragments.MenuLearnFrag;
import com.example.projet.models.LocaleHelper;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = new Bundle();
        bundle.putString("locale", LocaleHelper.getLanguage(this));

        MenuFrag menu_frag= new MenuFrag();
        menu_frag.setArguments(bundle);
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, menu_frag)
                .addToBackStack(null)
                .commit();

    }
}