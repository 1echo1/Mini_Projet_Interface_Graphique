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
import com.example.projet.models.Game;
import com.example.projet.models.LocaleHelper;
import com.example.projet.utils.Constants;

public class ColorsGameEyeFrag extends Fragment {

    Game color_game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_colors_eye_game, container, false);

        color_game = new Game(Constants.NBR_COLORS_TOTAL,getContext());

        String locale = "en";

        setupToolbar(view);
        setupReload(view, locale);
        setupColors(view, locale);
        setupColorChoice(view, locale);

        return view;
    }

    private void setupToolbar(View view) {
        final ImageView img_return = view.findViewById(R.id.img_return);
        img_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuTrainFrag train_menu_frag = new MenuTrainFrag();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.color_game_frag, train_menu_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void setupReload(View view, String locale) {
        final ImageView img_reload = view.findViewById(R.id.img_reload);
        img_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupColors(view, locale);
                setupColorChoice(view, locale);
            }
        });

    }

    private void setupColors(View view, String locale) {

        final Button btn_col_1 = view.findViewById(R.id.btn_color_1);
        btn_col_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_game.verify_find_victory(color_game.get_cell(0))) {
                    setupColors(view, locale);
                    setupColorChoice(view, locale);
                }
            }
        });

        final Button btn_col_2 = view.findViewById(R.id.btn_color_2);
        btn_col_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_game.verify_find_victory(color_game.get_cell(1))) {
                    setupColors(view, locale);
                    setupColorChoice(view, locale);
                }
            }
        });
        final Button btn_col_3 = view.findViewById(R.id.btn_color_3);
        btn_col_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_game.verify_find_victory(color_game.get_cell(2))) {
                    setupColors(view, locale);
                    setupColorChoice(view, locale);
                }
            }
        });

        final Button btn_col_4 = view.findViewById(R.id.btn_color_4);
        btn_col_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color_game.verify_find_victory(color_game.get_cell(3))) {
                    setupColors(view, locale);
                    setupColorChoice(view, locale);
                }
            }
        });

        color_game.choose_elements_display();

        for (int i = 0; i < color_game.array.length; i++) {
            Log.d("Array", String.valueOf(color_game.array[i]));
        }


        for (int i = 0; i < color_game.array.length; i++) {
            switch (color_game.get_cell(i)) {
                case Constants.GREEN:
                    if (i == 0) {
                        btn_col_1.setBackgroundColor(0xFF66FF66);
                    } else if (i == 1) {
                        btn_col_2.setBackgroundColor(0xFF66FF66);
                    } else if (i == 2) {
                        btn_col_3.setBackgroundColor(0xFF66FF66);
                    } else {
                        btn_col_4.setBackgroundColor(0xFF66FF66);
                    }
                    break;
                case Constants.BLUE:
                    if (i == 0) {
                        btn_col_1.setBackgroundColor(0xFF66FFFF);
                    } else if (i == 1) {
                        btn_col_2.setBackgroundColor(0xFF66FFFF);
                    } else if (i == 2) {
                        btn_col_3.setBackgroundColor(0xFF66FFFF);
                    } else {
                        btn_col_4.setBackgroundColor(0xFF66FFFF);
                    }
                    break;
                case Constants.ORANGE:
                    if (i == 0) {
                        btn_col_1.setBackgroundColor(0xFFFFB366);
                    } else if (i == 1) {
                        btn_col_2.setBackgroundColor(0xFFFFB366);
                    } else if (i == 2) {
                        btn_col_3.setBackgroundColor(0xFFFFB366);
                    } else {
                        btn_col_4.setBackgroundColor(0xFFFFB366);
                    }
                    break;
                case Constants.YELLOW:
                    if (i == 0) {
                        btn_col_1.setBackgroundColor(0xFFFFFF66);
                    } else if (i == 1) {
                        btn_col_2.setBackgroundColor(0xFFFFFF66);
                    } else if (i == 2) {
                        btn_col_3.setBackgroundColor(0xFFFFFF66);
                    } else {
                        btn_col_4.setBackgroundColor(0xFFFFFF66);
                    }
                    break;
                case Constants.RED:
                    if (i == 0) {
                        btn_col_1.setBackgroundColor(0xFFFF0000);
                    } else if (i == 1) {
                        btn_col_2.setBackgroundColor(0xFFFF0000);
                    } else if (i == 2) {
                        btn_col_3.setBackgroundColor(0xFFFF0000);
                    } else {
                        btn_col_4.setBackgroundColor(0xFFFF0000);
                    }
                    break;
                case Constants.BLACK:
                    if (i == 0) {
                        btn_col_1.setBackgroundColor(0xFF000000);
                    } else if (i == 1) {
                        btn_col_2.setBackgroundColor(0xFF000000);
                    } else if (i == 2) {
                        btn_col_3.setBackgroundColor(0xFF000000);
                    } else {
                        btn_col_4.setBackgroundColor(0xFF000000);
                    }
                    break;
                case Constants.WHITE:
                    if (i == 0) {
                        btn_col_1.setBackgroundColor(0xFFFFFFFF);
                    } else if (i == 1) {
                        btn_col_2.setBackgroundColor(0xFFFFFFFF);
                    } else if (i == 2) {
                        btn_col_3.setBackgroundColor(0xFFFFFFFF);
                    } else {
                        btn_col_4.setBackgroundColor(0xFFFFFFFF);
                    }
                    break;
                case Constants.BROWN:
                    if (i == 0) {
                        btn_col_1.setBackgroundColor(0xFF994D00);
                    } else if (i == 1) {
                        btn_col_2.setBackgroundColor(0xFF994D00);
                    } else if (i == 2) {
                        btn_col_3.setBackgroundColor(0xFF994D00);
                    } else {
                        btn_col_4.setBackgroundColor(0xFF994D00);
                    }
                    break;
            }
        }
    }

    private void setupColorChoice(View view, String locale) {
        Context context;
        Resources resources;

        context = LocaleHelper.setLocale(getActivity(), locale);
        resources = context.getResources();

        final TextView text_color = view.findViewById(R.id.text_color);

        int color = color_game.get_element_to_find();

        switch (color) {
            case Constants.GREEN:
                text_color.setText(resources.getString(R.string.clr_green));
                break;
            case Constants.BLUE:
                text_color.setText(resources.getString(R.string.clr_blue));
                break;
            case Constants.ORANGE:
                text_color.setText(resources.getString(R.string.clr_orange));
                break;
            case Constants.YELLOW:
                text_color.setText(resources.getString(R.string.clr_yellow));
                break;
            case Constants.RED:
                text_color.setText(resources.getString(R.string.clr_red));
                break;
            case Constants.BLACK:
                text_color.setText(resources.getString(R.string.clr_black));
                break;
            case Constants.WHITE:
                text_color.setText(resources.getString(R.string.clr_white));
                break;
            case Constants.BROWN:
                text_color.setText(resources.getString(R.string.clr_brown));
                break;
        }

    }
}