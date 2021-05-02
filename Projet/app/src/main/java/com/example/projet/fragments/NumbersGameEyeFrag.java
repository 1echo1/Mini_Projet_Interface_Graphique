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

public class NumbersGameEyeFrag extends Fragment {

    public NumbersGameEyeFrag() {
        // Required empty public constructor
    }

    Game num_game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numbers_eye_game, container, false);

        num_game = new Game(Constants.NBR_NUMS_TOTAL,getContext());

        Log.d("Mess", "GAME NUM FRAG");

        //  Bundle bundle = getActivity().getIntent().getExtras();
        String locale = "en";//bundle.getString("locale");

        setupToolbar(view);
        setupNumbers(locale, view);
        setupNumChoice(locale, view);
        setupReload(locale, view);

        return view;
    }

    private void setupToolbar(View view) {
        final ImageView img_return = view.findViewById(R.id.img_return);
        img_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuTrainFrag train_menu_frag = new MenuTrainFrag();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.numbers_game_frag, train_menu_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private void setupReload(String locale, View view) {
        final ImageView img_reload = view.findViewById(R.id.img_reload);
        img_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupNumbers(locale, view);
                setupNumChoice(locale, view);
            }
        });

    }

    private void setupNumbers(String locale, View view) {

        final Button btn_num_1 = view.findViewById(R.id.btn_num_1);
        btn_num_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num_game.verify_find_victory(num_game.get_cell(0))) {
                    setupNumbers(locale, view);
                    setupNumChoice(locale, view);
                }
            }
        });

        final Button btn_num_2 = view.findViewById(R.id.btn_num_2);
        btn_num_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num_game.verify_find_victory(num_game.get_cell(1))) {
                    setupNumbers(locale, view);
                    setupNumChoice(locale, view);
                }
            }
        });

        final Button btn_num_3 = view.findViewById(R.id.btn_num_3);
        btn_num_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num_game.verify_find_victory(num_game.get_cell(2))) {
                    setupNumbers(locale, view);
                    setupNumChoice(locale, view);
                }
            }
        });

        final Button btn_num_4 = view.findViewById(R.id.btn_num_4);
        btn_num_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num_game.verify_find_victory(num_game.get_cell(3))) {
                    setupNumbers(locale, view);
                    setupNumChoice(locale, view);
                }
            }
        });

        num_game.choose_elements_display();

        for (int i = 0; i < num_game.array.length; i++) {
            Log.d("Array", String.valueOf(num_game.array[i]));
        }


        for (int i = 0; i < num_game.array.length; i++) {
            switch (num_game.get_cell(i)) {
                case 0:
                    if (i == 0) {
                        btn_num_1.setText("0");
                    } else if (i == 1) {
                        btn_num_2.setText("0");
                    } else if (i == 2) {
                        btn_num_3.setText("0");
                    } else {
                        btn_num_4.setText("0");
                    }
                    break;
                case 1:
                    if (i == 0) {
                        btn_num_1.setText("1");
                    } else if (i == 1) {
                        btn_num_2.setText("1");
                    } else if (i == 2) {
                        btn_num_3.setText("1");
                    } else {
                        btn_num_4.setText("1");
                    }
                    break;
                case 2:
                    if (i == 0) {
                        btn_num_1.setText("2");
                    } else if (i == 1) {
                        btn_num_2.setText("2");
                    } else if (i == 2) {
                        btn_num_3.setText("2");
                    } else {
                        btn_num_4.setText("2");
                    }
                    break;
                case 3:
                    if (i == 0) {
                        btn_num_1.setText("3");
                    } else if (i == 1) {
                        btn_num_2.setText("3");
                    } else if (i == 2) {
                        btn_num_3.setText("3");
                    } else {
                        btn_num_4.setText("3");
                    }
                    break;
                case 4:
                    if (i == 0) {
                        btn_num_1.setText("4");
                    } else if (i == 1) {
                        btn_num_2.setText("4");
                    } else if (i == 2) {
                        btn_num_3.setText("4");
                    } else {
                        btn_num_4.setText("4");
                    }
                    break;
                case 5:
                    if (i == 0) {
                        btn_num_1.setText("5");
                    } else if (i == 1) {
                        btn_num_2.setText("5");
                    } else if (i == 2) {
                        btn_num_3.setText("5");
                    } else {
                        btn_num_4.setText("5");
                    }
                    break;
                case 6:
                    if (i == 0) {
                        btn_num_1.setText("6");
                    } else if (i == 1) {
                        btn_num_2.setText("6");
                    } else if (i == 2) {
                        btn_num_3.setText("6");
                    } else {
                        btn_num_4.setText("6");
                    }
                    break;
                case 7:
                    if (i == 0) {
                        btn_num_1.setText("7");
                    } else if (i == 1) {
                        btn_num_2.setText("7");
                    } else if (i == 2) {
                        btn_num_3.setText("7");
                    } else {
                        btn_num_4.setText("7");
                    }
                    break;
                case 8:
                    if (i == 0) {
                        btn_num_1.setText("8");
                    } else if (i == 1) {
                        btn_num_2.setText("8");
                    } else if (i == 2) {
                        btn_num_3.setText("8");
                    } else {
                        btn_num_4.setText("8");
                    }
                    break;
                case 9:
                    if (i == 0) {
                        btn_num_1.setText("9");
                    } else if (i == 1) {
                        btn_num_2.setText("9");
                    } else if (i == 2) {
                        btn_num_3.setText("9");
                    } else {
                        btn_num_4.setText("9");
                    }
                    break;
            }
        }
    }

    private void setupNumChoice(String locale, View view) {
        Context context;
        Resources resources;

        context = LocaleHelper.setLocale(getActivity(), locale);
        resources = context.getResources();

        final TextView text_num = view.findViewById(R.id.text_num);

        int num = num_game.get_element_to_find();

        switch (num) {
            case 0:
                text_num.setText(resources.getString(R.string.num_zero));
                break;
            case 1:
                text_num.setText(resources.getString(R.string.num_one));
                break;
            case 2:
                text_num.setText(resources.getString(R.string.num_two));
                break;
            case 3:
                text_num.setText(resources.getString(R.string.num_three));
                break;
            case 4:
                text_num.setText(resources.getString(R.string.num_four));
                break;
            case 5:
                text_num.setText(resources.getString(R.string.num_five));
                break;
            case 6:
                text_num.setText(resources.getString(R.string.num_six));
                break;
            case 7:
                text_num.setText(resources.getString(R.string.num_seven));
                break;
            case 8:
                text_num.setText(resources.getString(R.string.num_eight));
                break;
            case 9:
                text_num.setText(resources.getString(R.string.num_nine));
                break;
        }

    }
}
