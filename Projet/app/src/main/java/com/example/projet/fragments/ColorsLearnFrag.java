package com.example.projet.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projet.R;

public class ColorsLearnFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_colors_learn, container, false);

        setupToolbar(view);
        setupList(view);

        return view;
    }

    private void setupToolbar(View view) {
        final ImageView img_return = view.findViewById(R.id.img_return);
        img_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuLearnFrag learn_menu_frag = new MenuLearnFrag();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.color_learn_frag, learn_menu_frag)
                        .commit();
            }
        });
    }

    void setupList(View view){

        Drawable[] colors_val ={getActivity().getDrawable(R.drawable.rectangle_learn_red),
                getActivity().getDrawable(R.drawable.rectangle_learn_blue),
                getActivity().getDrawable(R.drawable.rectangle_learn_black),
                getActivity().getDrawable(R.drawable.rectangle_learn_white),
                getActivity().getDrawable(R.drawable.rectangle_learn_orange),
                getActivity().getDrawable(R.drawable.rectangle_learn_yellow),
                getActivity().getDrawable(R.drawable.rectangle_learn_brown),
                getActivity().getDrawable(R.drawable.rectangle_learn_green),
        };

        final ArrayAdapter<String> colors_list = new ArrayAdapter<String>(getActivity(), R.layout.list_item, R.id.tv_type_to_learn) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                String color=getItem(position);

                ImageView im_color = view.findViewById(R.id.img_type_learn);
                TextView tv_color = view.findViewById(R.id.tv_type_to_learn);
               // ImageButton btn_speaker = view.findViewById(R.id.btn_speaker);

                tv_color.setText(color);
                im_color.setImageDrawable(colors_val[position]);

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