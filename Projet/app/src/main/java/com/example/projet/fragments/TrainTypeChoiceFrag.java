package com.example.projet.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
        View view =inflater.inflate(R.layout.fragment_train_type_choice, container, false);

        int type_game=getArguments().getInt("train_type");

        setupChoice(view,type_game);

        return view;
    }

    public void setupChoice(View view, int type_game){
        final Button btn_train_eye=view.findViewById(R.id.btn_train_eye);

        btn_train_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("YO","Helloo");
                switch (type_game){
                    case Constants.TYPE_COLORS:
                      /*  NumbersGameFrag numbers_game_frag = new NumbersGameFrag();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, numbers_game_frag)
                                .commit();*/

                        break;
                    case Constants.TYPE_VEH:
                        /*NumbersGameFrag numbers_game_frag = new NumbersGameFrag();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, numbers_game_frag)
                                .commit();*/
                        break;
                    case Constants.TYPE_NUM:
                        NumbersGameFrag numbers_game_frag = new NumbersGameFrag();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, numbers_game_frag)
                                .commit();
                        break;

                }
            }
        });

        final Button btn_close_choice=view.findViewById(R.id.btn_close_choice_t);

        btn_close_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuTrainFrag menu_train_frag = new MenuTrainFrag();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.train_choice_frag, menu_train_frag)
                        .commit();
             }
        });

        final Button btn_close_choice_b=view.findViewById(R.id.btn_close_choice_b);

        btn_close_choice_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuTrainFrag menu_train_frag = new MenuTrainFrag();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.train_choice_frag, menu_train_frag)
                        .commit();
            }
        });

    }
}