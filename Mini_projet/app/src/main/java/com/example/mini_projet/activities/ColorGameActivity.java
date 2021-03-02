package com.example.mini_projet.activities;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mini_projet.R;
import com.example.mini_projet.models.Game;
import com.example.mini_projet.utils.LocaleHelper;
import com.example.mini_projet.utils.Constants;

public class ColorGameActivity extends Activity {

    Game color_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        Bundle bundle = getIntent().getExtras();
        String locale = bundle.getString("locale");

        color_game=new Game(Constants.NBR_COLORS_TOTAL);

        setupToolbar();
        setupReload(locale);
        setupColors(locale);
        setupColorChoice(locale);
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

    private void setupReload(String locale){
        final ImageView img_reload = findViewById(R.id.img_reload);
        img_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupColors(locale);
                setupColorChoice(locale);
            }
        });

    }

    private void setupColors(String locale){

        final Button btn_col_1 = findViewById(R.id.btn_color_1);
        btn_col_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color_game.verify_victory(color_game.get_cell(0))) {
                    setupColors(locale);
                    setupColorChoice(locale);
                }
            }
        });

        final Button btn_col_2 = findViewById(R.id.btn_color_2);
        btn_col_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color_game.verify_victory(color_game.get_cell(1))) {
                    setupColors(locale);
                    setupColorChoice(locale);
                }
            }
        });
        final Button btn_col_3 = findViewById(R.id.btn_color_3);
        btn_col_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color_game.verify_victory(color_game.get_cell(2))) {
                    setupColors(locale);
                    setupColorChoice(locale);
                }
            }
        });

        final Button btn_col_4 = findViewById(R.id.btn_color_4);
        btn_col_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(color_game.verify_victory(color_game.get_cell(3))) {
                    setupColors(locale);
                    setupColorChoice(locale);
                }
            }
        });

        color_game.choose_elements_display();

        for(int i = 0; i<color_game.array.length; i++) {
            Log.d("Array", String.valueOf(color_game.array[i]));
        }


        for(int i = 0; i<color_game.array.length; i++) {
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

    private void setupColorChoice(String locale){
        Context context;
        Resources resources;

        context = LocaleHelper.setLocale(ColorGameActivity.this, locale);
        resources = context.getResources();

        final TextView text_color = findViewById(R.id.text_color);

        int color=color_game.get_element_to_find();

        switch (color){
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
