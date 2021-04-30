package com.example.projet.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projet.R;
import com.example.projet.utils.Constants;


public class MenuTrainFrag extends Fragment {

    public MenuTrainFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_menu_train, container, false);

        setupToolbar(view);
        setupMenu(view);

        return view;
    }


    private void setupToolbar(View view){
        final ImageView img_return = view.findViewById(R.id.img_return);
        img_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuFrag menu_frag= new MenuFrag();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.train_menu_frag, menu_frag)
                        .commit();
            }
        });
    }


    public void setupMenu(View view){
        final TextView tv_train=view.findViewById(R.id.tv_train);

        final Button btn_col=view.findViewById(R.id.btn_color_game);
        btn_col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("train_type", Constants.TYPE_COLORS);

                TrainTypeChoiceFrag train_choice_frag= new TrainTypeChoiceFrag();
                train_choice_frag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.train_menu_frag, train_choice_frag)
                        .commit();
            }
        });

        final Button btn_num = view.findViewById(R.id.btn_numbers_game);
        btn_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("train_type", Constants.TYPE_NUM);

                TrainTypeChoiceFrag train_choice_frag= new TrainTypeChoiceFrag();
                train_choice_frag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.train_menu_frag, train_choice_frag)
                        .commit();
            }
        });

        final Button btn_veh = view.findViewById(R.id.btn_vehicles_game);
        btn_veh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("train_type", Constants.TYPE_VEH);

                TrainTypeChoiceFrag train_choice_frag= new TrainTypeChoiceFrag();
                train_choice_frag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.train_menu_frag, train_choice_frag)
                        .commit();
            }
        });

    }
}