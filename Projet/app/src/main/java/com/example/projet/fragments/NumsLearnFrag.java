package com.example.projet.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
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
import com.example.projet.models.LocaleHelper;

public class NumsLearnFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nums_learn, container, false);

        String locale = getArguments().getString("locale");

        Context context;
        Resources resources;

        context = LocaleHelper.setLocale(getActivity(), locale);
        resources = context.getResources();

        setupToolbar(view);
        //setupMp3(view, locale);
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
                        .replace(R.id.num_learn_frag, learn_menu_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    /*void setupMp3(View view, String locale){
        final ImageButton speak=view.findViewById(R.id.btn_speaker);
        final MediaPlayer mp=  MediaPlayer.create(getActivity(),R.raw.un);
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locale=="fr"){
                    mp.start();
                }
            }
        });


    }*/

    void setupList(View view, Resources resources) {
        TextView tv_num = view.findViewById(R.id.tv_num);
        tv_num.setText(resources.getText(R.string.btn_numbers));

        String[] num_val = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        final ArrayAdapter<String> num_list = new ArrayAdapter<String>(getActivity(), R.layout.list_item_num_version, R.id.tv_type_to_learn) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                String color = getItem(position);

                TextView tv_num_img = view.findViewById(R.id.tv_num_learn);
                TextView tv_num = view.findViewById(R.id.tv_type_to_learn);
                // ImageButton btn_speaker = view.findViewById(R.id.btn_speaker);

                tv_num.setText(color);
                tv_num_img.setText(num_val[position]);

                return view;
            }
        };
        num_list.addAll(resources.getString(R.string.num_zero),
                resources.getString(R.string.num_one),
                resources.getString(R.string.num_two),
                resources.getString(R.string.num_three),
                resources.getString(R.string.num_four),
                resources.getString(R.string.num_five),
                resources.getString(R.string.num_six),
                resources.getString(R.string.num_seven),
                resources.getString(R.string.num_eight),
                resources.getString(R.string.num_nine));

        ListView list = view.findViewById(R.id.list_num);
        list.setAdapter(num_list);
    }
}