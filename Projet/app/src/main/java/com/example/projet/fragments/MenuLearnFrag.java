package com.example.projet.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projet.R;
import com.example.projet.models.LocaleHelper;

public class MenuLearnFrag extends Fragment {

    public MenuLearnFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_learn, container, false);


        ////////Récupère langue//////////
        String locale = getArguments().getString("locale");
        Context context;
        Resources resources;
        context = LocaleHelper.setLocale(getActivity(), locale);
        resources = context.getResources();

        setupToolbar(view);
        setupMenu(view, resources);

        Log.d("Mess", "MENU LEARN FRAG");

        return view;
    }


    private void setupToolbar(View view) {
        final ImageView img_return = view.findViewById(R.id.img_return);
        img_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("locale", LocaleHelper.getLanguage(getActivity()));

                MenuFrag menu_frag = new MenuFrag();
                menu_frag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.learn_menu_frag, menu_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    public void setupMenu(View view, Resources resources) {


        final TextView tv_learn = view.findViewById(R.id.tv_learn);
        tv_learn.setText(resources.getText(R.string.text_learn_menu));

        final Button btn_col = view.findViewById(R.id.btn_color_game);
        btn_col.setText(resources.getText(R.string.btn_colors));
        btn_col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("locale", LocaleHelper.getLanguage(getActivity()));

                ColorsLearnFrag colors_frag = new ColorsLearnFrag();
                colors_frag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.learn_menu_frag, colors_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        final Button btn_num = view.findViewById(R.id.btn_numbers_game);
        btn_num.setText(resources.getText(R.string.btn_numbers));
        btn_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("locale", LocaleHelper.getLanguage(getActivity()));

                NumsLearnFrag num_frag = new NumsLearnFrag();
                num_frag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.learn_menu_frag, num_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        final Button btn_veh = view.findViewById(R.id.btn_vehicles_game);
        btn_veh.setText(resources.getText(R.string.btn_vehicles));
        btn_veh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("locale", LocaleHelper.getLanguage(getActivity()));

                VehiclesLearnFrag veh_frag = new VehiclesLearnFrag();
                veh_frag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.learn_menu_frag, veh_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });

    }
}