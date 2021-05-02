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

public class NumsLearnFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_nums_learn, container, false);

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
                        .replace(R.id.num_learn_frag, learn_menu_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    void setupList(View view){

        String[] num_val ={"0","1","2","3","4","5","6","7","8","9"};

        final ArrayAdapter<String> num_list = new ArrayAdapter<String>(getActivity(), R.layout.list_item_num_version, R.id.tv_type_to_learn) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                String color=getItem(position);

                TextView tv_num_img = view.findViewById(R.id.tv_num_learn);
                TextView tv_num = view.findViewById(R.id.tv_type_to_learn);
                // ImageButton btn_speaker = view.findViewById(R.id.btn_speaker);

                tv_num.setText(color);
                tv_num_img.setText(num_val[position]);

                return view;
            }
        };
        num_list.addAll(getString(R.string.num_zero),
                getString(R.string.num_one),
                getString(R.string.num_two),
                getString(R.string.num_three),
                getString(R.string.num_four),
                getString(R.string.num_five),
                getString(R.string.num_six),
                getString(R.string.num_seven),
                getString(R.string.num_eight),
                getString(R.string.num_nine));

        ListView list=view.findViewById(R.id.list_num);
        list.setAdapter(num_list);
    }
}