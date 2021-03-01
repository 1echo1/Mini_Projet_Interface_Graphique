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
import com.example.mini_projet.models.LocaleHelper;
import com.example.mini_projet.models.NumbersGame;

public class NumbersGameActivity extends Activity {

   NumbersGame num_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        Bundle bundle = getIntent().getExtras();
        String locale = bundle.getString("locale");

        num_game=new NumbersGame();

        setupToolbar();
        setupNumbers(locale);
        setupNumChoice(locale);
        setupReload(locale);
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
                setupNumbers(locale);
                setupNumChoice(locale);
            }
        });

    }


    private void setupNumbers(String locale){

        final Button btn_num_1 = findViewById(R.id.btn_num_1);
        btn_num_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num_game.verify_victory(num_game.get_color_cell(0))) {
                    setupNumbers(locale);
                    setupNumChoice(locale);
                }
            }
        });

        final Button btn_num_2 = findViewById(R.id.btn_num_2);
        btn_num_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num_game.verify_victory(num_game.get_color_cell(1))) {
                    setupNumbers(locale);
                    setupNumChoice(locale);
                }
            }
        });

        final Button btn_num_3 = findViewById(R.id.btn_num_3);
        btn_num_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num_game.verify_victory(num_game.get_color_cell(2))) {
                    setupNumbers(locale);
                    setupNumChoice(locale);
                }
            }
        });

        final Button btn_num_4 = findViewById(R.id.btn_num_4);
        btn_num_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num_game.verify_victory(num_game.get_color_cell(3))) {
                    setupNumbers(locale);
                    setupNumChoice(locale);
                }
            }
        });

        num_game.choose_numbers_display();

        for(int i = 0; i<num_game.numArray.length; i++) {
            Log.d("Array", String.valueOf(num_game.numArray[i]));
        }


        for(int i = 0; i<num_game.numArray.length; i++) {
            switch (num_game.get_color_cell(i)) {
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

    private void setupNumChoice(String locale){
        Context context;
        Resources resources;

        context = LocaleHelper.setLocale(NumbersGameActivity.this, locale);
        resources = context.getResources();

        final TextView text_num = findViewById(R.id.text_num);

        int num=num_game.getNum_to_find();

        switch (num){
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
