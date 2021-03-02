package com.example.mini_projet.activities;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mini_projet.R;
import com.example.mini_projet.models.Game;
import com.example.mini_projet.models.LocaleHelper;
import com.example.mini_projet.utils.Constants;

public class VehiclesGameActivity extends Activity {

    Game veh_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);

        Bundle bundle = getIntent().getExtras();
        String locale = bundle.getString("locale");

        veh_game=new Game(Constants.NBR_VEH_TOTAL);

        setupToolbar();
        setupVehicles(locale);
        setupVehChoice(locale);
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
                setupVehicles(locale);
                setupVehChoice(locale);
            }
        });

    }


    private void setupVehicles(String locale){

        final ImageButton btn_veh_1 = findViewById(R.id.btn_veh_1);
        btn_veh_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(veh_game.verify_victory(veh_game.get_cell(0))) {
                    setupVehicles(locale);
                    setupVehChoice(locale);
                }
            }
        });

        final ImageButton btn_veh_2 = findViewById(R.id.btn_veh_2);
        btn_veh_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(veh_game.verify_victory(veh_game.get_cell(1))) {
                    setupVehicles(locale);
                    setupVehChoice(locale);
                }
            }
        });

        final ImageButton btn_veh_3 = findViewById(R.id.btn_veh_3);
        btn_veh_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(veh_game.verify_victory(veh_game.get_cell(2))) {
                    setupVehicles(locale);
                    setupVehChoice(locale);
                }
            }
        });

        final ImageButton btn_veh_4 = findViewById(R.id.btn_veh_4);
        btn_veh_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(veh_game.verify_victory(veh_game.get_cell(3))) {
                    setupVehicles(locale);
                    setupVehChoice(locale);
                }
            }
        });

        veh_game.choose_elements_display();

        for(int i = 0; i<veh_game.array.length; i++) {
            Log.d("Array", String.valueOf(veh_game.array[i]));
        }


        for(int i = 0; i<veh_game.array.length; i++) {
            switch (veh_game.get_cell(i)) {
                case Constants.CAR:
                    if (i == 0) {
                        btn_veh_1.setImageResource(R.mipmap.ic_car_foreground);
                    } else if (i == 1) {
                        btn_veh_2.setImageResource(R.mipmap.ic_car_foreground);
                    } else if (i == 2) {
                        btn_veh_3.setImageResource(R.mipmap.ic_car_foreground);
                    } else {
                        btn_veh_4.setImageResource(R.mipmap.ic_car_foreground);
                    }
                    break;
                case Constants.MOTO:
                    if (i == 0) {
                        btn_veh_1.setImageResource(R.mipmap.ic_moto_foreground);
                    } else if (i == 1) {
                        btn_veh_2.setImageResource(R.mipmap.ic_moto_foreground);
                    } else if (i == 2) {
                        btn_veh_3.setImageResource(R.mipmap.ic_moto_foreground);
                    } else {
                        btn_veh_4.setImageResource(R.mipmap.ic_moto_foreground);
                    }
                    break;
                case Constants.TRUCK:
                    if (i == 0) {
                        btn_veh_1.setImageResource(R.mipmap.ic_truck_foreground);
                    } else if (i == 1) {
                        btn_veh_2.setImageResource(R.mipmap.ic_truck_foreground);
                    } else if (i == 2) {
                        btn_veh_3.setImageResource(R.mipmap.ic_truck_foreground);
                    } else {
                        btn_veh_4.setImageResource(R.mipmap.ic_truck_foreground);
                    }
                    break;
                case Constants.BUS:
                    if (i == 0) {
                        btn_veh_1.setImageResource(R.mipmap.ic_bus_foreground);
                    } else if (i == 1) {
                        btn_veh_2.setImageResource(R.mipmap.ic_bus_foreground);
                    } else if (i == 2) {
                        btn_veh_3.setImageResource(R.mipmap.ic_bus_foreground);
                    } else {
                        btn_veh_4.setImageResource(R.mipmap.ic_bus_foreground);
                    }
                    break;
                case Constants.BOAT:
                    if (i == 0) {
                        btn_veh_1.setImageResource(R.mipmap.ic_boat_foreground);
                    } else if (i == 1) {
                        btn_veh_2.setImageResource(R.mipmap.ic_boat_foreground);
                    } else if (i == 2) {
                        btn_veh_3.setImageResource(R.mipmap.ic_boat_foreground);
                    } else {
                        btn_veh_4.setImageResource(R.mipmap.ic_boat_foreground);
                    }
                    break;
                case Constants.BIKE:
                    if (i == 0) {
                        btn_veh_1.setImageResource(R.mipmap.ic_bike_foreground);
                    } else if (i == 1) {
                        btn_veh_2.setImageResource(R.mipmap.ic_bike_foreground);
                    } else if (i == 2) {
                        btn_veh_3.setImageResource(R.mipmap.ic_bike_foreground);
                    } else {
                        btn_veh_4.setImageResource(R.mipmap.ic_bike_foreground);
                    }
                    break;
            }
        }
    }

    private void setupVehChoice(String locale){
        Context context;
        Resources resources;

        context = LocaleHelper.setLocale(VehiclesGameActivity.this, locale);
        resources = context.getResources();

        final TextView text_veh = findViewById(R.id.text_veh);

        int veh=veh_game.get_element_to_find();

        switch (veh){
            case Constants.CAR:
                text_veh.setText(resources.getString(R.string.veh_car));
                break;
            case Constants.MOTO:
                text_veh.setText(resources.getString(R.string.veh_moto));
                break;
            case Constants.TRUCK:
                text_veh.setText(resources.getString(R.string.veh_truck));
                break;
            case Constants.BUS:
                text_veh.setText(resources.getString(R.string.veh_bus));
                break;
            case Constants.BOAT:
                text_veh.setText(resources.getString(R.string.veh_boat));
                break;
            case Constants.BIKE:
                text_veh.setText(resources.getString(R.string.veh_bike));
                break;
        }

    }
}
