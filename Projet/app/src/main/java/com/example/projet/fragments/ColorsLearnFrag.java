package com.example.projet.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projet.R;

import java.util.List;

public class ColorsLearnFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_colors_learn, container, false);

        setupList(view);

        return view;
    }

    void setupList(View view){

        final int colors_val[]={0xFFFF0000,0xFF66FFFF,0xFF000000,0xFFFFFFFF,0xFFFFB366,0xFFFFFF66,0xFF994D00,0xFF66FF66};

        final ArrayAdapter<String> colors_list = new ArrayAdapter<String>(getActivity(), R.layout.list_item, R.id.tv_color_to_learn) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                String color=getItem(position);

                ImageView im_color = view.findViewById(R.id.img_color_learn);
                TextView tv_color = view.findViewById(R.id.tv_color_to_learn);
               // ImageButton btn_speaker = view.findViewById(R.id.btn_speaker);

                tv_color.setText(color);
                im_color.setBackgroundColor(colors_val[position]);
                im_color.setImageDrawable(getActivity().getDrawable(R.drawable.rectangle_learn));

                return view;
            }
        };
        colors_list.addAll(getString(R.string.clr_red),
                getString(R.string.clr_blue),
                getString(R.string.clr_black),
                getString(R.string.clr_white),
                getString(R.string.clr_orange),
                getString(R.string.clr_yellow),
                getString(R.string.clr_brown),
                getString(R.string.clr_green));

        ListView list=view.findViewById(R.id.list_colors);
        list.setAdapter(colors_list);
    }
}