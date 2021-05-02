package com.example.projet.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
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
import com.example.projet.utils.Constants;

public class MenuFrag extends Fragment {

    public MenuFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_menu, container, false);

        String locale = getArguments().getString("locale");

        Context context;
        Resources resources;

        context = LocaleHelper.setLocale(getActivity(), locale);
        resources = context.getResources();

        setupMenu(view,resources,locale);

        Log.d("Mess","MENU GRAG");

        return view;
    }


    public void setupMenu(View view, Resources resources, String locale){
        final Button btn_learn=view.findViewById(R.id.btn_learn);
        btn_learn.setText(resources.getText(R.string.btn_learn));
        btn_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Mess","LEARN CLICK");

                Bundle bundle = new Bundle();
                bundle.putString("locale", LocaleHelper.getLanguage(getActivity()));

                MenuLearnFrag menu_learn_frag= new MenuLearnFrag();
                menu_learn_frag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.fragment_open_enter,
                                R.anim.fragment_close_exit)
                        .replace(R.id.frag_menu, menu_learn_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        final Button btn_train = view.findViewById(R.id.btn_train);
        btn_train.setText(resources.getText(R.string.btn_train));
        btn_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("locale", LocaleHelper.getLanguage(getActivity()));

                MenuTrainFrag menu_train_frag= new MenuTrainFrag();
                menu_train_frag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.fragment_open_enter,
                                R.anim.fragment_close_exit)
                        .replace(R.id.frag_menu, menu_train_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        final Button btn_google_p = view.findViewById(R.id.btn_google_play);
        btn_google_p.setText(resources.getText(R.string.btn_google_play));
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

        if(locale=="fr"){
            spinner.setSelection(1);
        }else{
            spinner.setSelection(0);
        }


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