package com.example.projet.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.projet.R;
import com.example.projet.utils.Constants;

public class TrainTypeChoiceFrag extends Fragment {

    public TrainTypeChoiceFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_train_type_choice, container, false);

        int type_game = getArguments().getInt("train_type");

        Log.d("Mess", "CHOICE FRAG");

        setupChoice(view, type_game);

        return view;
    }

    public void setupChoice(View view, int type_game) {
        final Button btn_train_eye = view.findViewById(R.id.btn_train_eye);

        btn_train_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("YO", "Helloo");
                switch (type_game) {
                    case Constants.TYPE_COLORS:
                        ColorsGameEyeFrag colors_game_frag = new ColorsGameEyeFrag();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, colors_game_frag)
                                .addToBackStack(null)
                                .commit();

                        break;
                    case Constants.TYPE_VEH:
                        VehiclesGameEyeFrag veh_game_frag = new VehiclesGameEyeFrag();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, veh_game_frag)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case Constants.TYPE_NUM:
                        NumbersGameEyeFrag numbers_game_frag = new NumbersGameEyeFrag();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, numbers_game_frag)
                                .addToBackStack(null)
                                .commit();
                        break;
                }
            }
        });

        final Button btn_train_write = view.findViewById(R.id.btn_train_write);

        btn_train_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (type_game) {
                    case Constants.TYPE_COLORS:
                        ColorsGameWriteFrag color_game_write_frag = new ColorsGameWriteFrag();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, color_game_write_frag)
                                .addToBackStack(null)
                                .commit();

                        break;
                    case Constants.TYPE_VEH:
                        /*VehiclesGameWriteFrag veh_game_write_frag = new VehiclesGameWriteFrag();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, veh_game_write_frag)
                                .commit();*/
                        break;
                    case Constants.TYPE_NUM:
                        NumbersGameWriteFrag num_game_write_frag = new NumbersGameWriteFrag();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, num_game_write_frag)
                                .addToBackStack(null)
                                .commit();
                        break;

                }
            }
        });

        final Button btn_close_choice = view.findViewById(R.id.btn_close_choice_t);

        btn_close_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuTrainFrag menu_train_frag = new MenuTrainFrag();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.train_choice_frag, menu_train_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });

        final Button btn_close_choice_b = view.findViewById(R.id.btn_close_choice_b);

        btn_close_choice_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuTrainFrag menu_train_frag = new MenuTrainFrag();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.train_choice_frag, menu_train_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });

    }
}