package com.example.projet.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
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

public class VehiclesGameEyeFrag extends Fragment {

    Game veh_game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vehicles_eye_game, container, false);

        String locale = getArguments().getString("locale");

        Context context;
        Resources resources;

        context = LocaleHelper.setLocale(getActivity(), locale);
        resources = context.getResources();

        veh_game = new Game(Constants.NBR_VEH_TOTAL, resources);

        setupToolbar(view);
        setupVehicles(view, locale);
        setupVehChoice(view, locale);
        setupReload(view, locale);

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
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.veh_game_eye_frag, train_menu_frag)
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
                setupVehicles(view, locale);
                setupVehChoice(view, locale);
            }
        });

    }


    private void setupVehicles(View view, String locale) {

        final ImageButton btn_veh_1 = view.findViewById(R.id.btn_veh_1);
        btn_veh_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (veh_game.verify_find_victory(veh_game.get_cell(0))) {
                    setupVehicles(view, locale);
                    setupVehChoice(view, locale);
                }
            }
        });

        final ImageButton btn_veh_2 = view.findViewById(R.id.btn_veh_2);
        btn_veh_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (veh_game.verify_find_victory(veh_game.get_cell(1))) {
                    setupVehicles(view, locale);
                    setupVehChoice(view, locale);
                }
            }
        });

        final ImageButton btn_veh_3 = view.findViewById(R.id.btn_veh_3);
        btn_veh_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (veh_game.verify_find_victory(veh_game.get_cell(2))) {
                    setupVehicles(view, locale);
                    setupVehChoice(view, locale);
                }
            }
        });

        final ImageButton btn_veh_4 = view.findViewById(R.id.btn_veh_4);
        btn_veh_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (veh_game.verify_find_victory(veh_game.get_cell(3))) {
                    setupVehicles(view, locale);
                    setupVehChoice(view, locale);
                }
            }
        });

        veh_game.choose_elements_display();

        for (int i = 0; i < veh_game.array.length; i++) {
            Log.d("Array", String.valueOf(veh_game.array[i]));
        }


        for (int i = 0; i < veh_game.array.length; i++) {
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

    private void setupVehChoice(View view, String locale) {
        Context context;
        Resources resources;

        context = LocaleHelper.setLocale(getActivity(), locale);
        resources = context.getResources();

        final TextView text_veh = view.findViewById(R.id.text_veh);

        int veh = veh_game.get_element_to_find();

        switch (veh) {
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