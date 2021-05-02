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

import com.example.projet.R;
import com.example.projet.models.LocaleHelper;
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

        String locale = getArguments().getString("locale");

        Context context;
        Resources resources;

        context = LocaleHelper.setLocale(getActivity(), locale);
        resources = context.getResources();

        int type_game = getArguments().getInt("train_type");

        Log.d("Mess", "CHOICE FRAG");

        setupChoice(view, type_game, resources);

        return view;
    }

    public void setupChoice(View view, int type_game, Resources resources) {
        final Button btn_train_eye = view.findViewById(R.id.btn_train_eye);
        btn_train_eye.setText(resources.getText(R.string.btn_train_eye));

        btn_train_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("YO", "Helloo");
                Bundle bundle = new Bundle();
                bundle.putString("locale", LocaleHelper.getLanguage(getActivity()));
                switch (type_game) {
                    case Constants.TYPE_COLORS:
                        ColorsGameEyeFrag colors_game_frag = new ColorsGameEyeFrag();
                        colors_game_frag.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, colors_game_frag)
                                .addToBackStack(null)
                                .commit();

                        break;
                    case Constants.TYPE_VEH:
                        VehiclesGameEyeFrag veh_game_frag = new VehiclesGameEyeFrag();
                        veh_game_frag.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, veh_game_frag)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case Constants.TYPE_NUM:
                        NumbersGameEyeFrag numbers_game_frag = new NumbersGameEyeFrag();
                        numbers_game_frag.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, numbers_game_frag)
                                .addToBackStack(null)
                                .commit();
                        break;
                }
            }
        });

        final Button btn_train_write = view.findViewById(R.id.btn_train_write);
        btn_train_write.setText(resources.getText(R.string.btn_train_write));
        btn_train_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("locale", LocaleHelper.getLanguage(getActivity()));
                switch (type_game) {
                    case Constants.TYPE_COLORS:
                        ColorsGameWriteFrag color_game_write_frag = new ColorsGameWriteFrag();
                        color_game_write_frag.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, color_game_write_frag)
                                .addToBackStack(null)
                                .commit();

                        break;
                    case Constants.TYPE_VEH:
                        VehiclesGameWriteFrag veh_game_write_frag = new VehiclesGameWriteFrag();
                        veh_game_write_frag.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.train_choice_frag, veh_game_write_frag)
                                .commit();
                        break;
                    case Constants.TYPE_NUM:
                        NumbersGameWriteFrag num_game_write_frag = new NumbersGameWriteFrag();
                        num_game_write_frag.setArguments(bundle);
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
                Bundle bundle = new Bundle();
                bundle.putString("locale", LocaleHelper.getLanguage(getActivity()));

                MenuTrainFrag menu_train_frag = new MenuTrainFrag();
                menu_train_frag.setArguments(bundle);
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
                Bundle bundle = new Bundle();
                bundle.putString("locale", LocaleHelper.getLanguage(getActivity()));

                MenuTrainFrag menu_train_frag = new MenuTrainFrag();
                menu_train_frag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.train_choice_frag, menu_train_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });

    }
}