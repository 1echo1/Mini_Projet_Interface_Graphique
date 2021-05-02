package com.example.projet.fragments;

import android.content.Context;
import android.content.res.Resources;
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
import com.example.projet.models.LocaleHelper;

public class ColorsLearnFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_colors_learn, container, false);


        ////////Récupère langue//////////
        String locale = getArguments().getString("locale");
        Context context;
        Resources resources;
        context = LocaleHelper.setLocale(getActivity(), locale);
        resources = context.getResources();

        setupToolbar(view);
        setupList(view, resources);

        return view;
    }

    private void setupToolbar(View view) {
        final ImageView img_return = view.findViewById(R.id.img_return);
        img_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("locale", LocaleHelper.getLanguage(getActivity()));

                MenuLearnFrag learn_menu_frag = new MenuLearnFrag();
                learn_menu_frag.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.color_learn_frag, learn_menu_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    void setupList(View view, Resources resources) {

        final TextView tv_colors = view.findViewById(R.id.tv_colors);
        tv_colors.setText(resources.getText(R.string.btn_colors));

        Drawable[] colors_val = {getActivity().getDrawable(R.drawable.rectangle_learn_red),
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

                String color = getItem(position);

                ImageView im_color = view.findViewById(R.id.img_type_learn);
                TextView tv_color = view.findViewById(R.id.tv_type_to_learn);
                // ImageButton btn_speaker = view.findViewById(R.id.btn_speaker);

                tv_color.setText(color);
                im_color.setImageDrawable(colors_val[position]);

                return view;
            }
        };
        colors_list.addAll(resources.getString(R.string.clr_red),
                resources.getString(R.string.clr_blue),
                resources.getString(R.string.clr_black),
                resources.getString(R.string.clr_white),
                resources.getString(R.string.clr_orange),
                resources.getString(R.string.clr_yellow),
                resources.getString(R.string.clr_brown),
                resources.getString(R.string.clr_green));

        ListView list = view.findViewById(R.id.list_colors);
        list.setAdapter(colors_list);
    }
}