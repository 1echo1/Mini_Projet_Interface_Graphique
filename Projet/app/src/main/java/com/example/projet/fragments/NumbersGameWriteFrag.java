package com.example.projet.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projet.R;
import com.example.projet.models.Game;
import com.example.projet.models.LocaleHelper;
import com.example.projet.utils.Constants;
import com.google.android.material.textfield.TextInputEditText;

public class NumbersGameWriteFrag extends Fragment {

    Game num_game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_numbers_game_write, container, false);


        String locale = getArguments().getString("locale");

        Context context;
        Resources resources;

        context = LocaleHelper.setLocale(getActivity(), locale);
        resources = context.getResources();

        num_game=new Game(Constants.NBR_NUMS_TOTAL,resources);

        setupToolbar(view);
        //setupReload(view, locale);
        setupColors(view, locale);

        return view;
    }

    private void setupToolbar(View view) {
        final ImageView img_return = view.findViewById(R.id.img_return);
        img_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("locale", LocaleHelper.getLanguage(getActivity()));

                MenuTrainFrag train_menu_frag = new MenuTrainFrag();
                train_menu_frag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.num_game_write_frag, train_menu_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    /*private void setupReload(View view, String locale) {
        final ImageView img_reload = view.findViewById(R.id.img_reload);
        img_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupColors(view, locale);
                setupColorChoice(view, locale);
            }
        });

    }*/

    private void setupColors(View view, String locale) {

        int num_to_find=num_game.get_element_to_write(Constants.TYPE_NUM);

        final TextInputEditText text=view.findViewById(R.id.input_num);

        final ImageButton btn_check = view.findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (num_game.verify_write_victory(text.getText().toString(),Constants.TYPE_NUM)) {
                    setupColors(view, locale);
                }
            }
        });

        final TextView num_find=view.findViewById(R.id.tv_num_write);
        num_find.setText(String.valueOf(num_to_find));

    }
}