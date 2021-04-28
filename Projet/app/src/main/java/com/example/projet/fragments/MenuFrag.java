package com.example.projet.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.projet.R;
import com.example.projet.activities.MainActivity;
import com.example.projet.fragments.MenuLearnFrag;
import com.example.projet.models.LocaleHelper;

public class MenuFrag extends Fragment {


    public MenuFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_menu, container, false);

        setupMenu(view);

        return view;
    }


    public void setupMenu(View view){
        final Button btn_learn=view.findViewById(R.id.btn_learn);
        btn_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuLearnFrag menu_learn_frag= new MenuLearnFrag();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frag_menu, menu_learn_frag)
                        .commit();
            }
        });

        final Button btn_train = view.findViewById(R.id.btn_train);
        btn_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openTrainActivity();
            }
        });

        final Button btn_google_p = view.findViewById(R.id.btn_google_play);
        btn_google_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGooglePlay();
            }
        });

        Spinner spinner = (Spinner) view.findViewById(R.id.languages_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Context context;
                Resources resources;

                switch (pos) {
                    case 0:
                        context = LocaleHelper.setLocale(getActivity(), "en");
                        resources = context.getResources();

                        break;
                    default:
                        context = LocaleHelper.setLocale(getActivity(), "fr");
                        resources = context.getResources();
                        break;
                }
                btn_learn.setText(resources.getString(R.string.btn_learn));
                btn_train.setText(resources.getString(R.string.btn_train));
                btn_google_p.setText(resources.getString(R.string.btn_google_play));
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void openGooglePlay(){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://play.google.com/store/apps"));
        startActivity(intent);
    }

}