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

public class VehiclesLearnFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vehicles_learn, container, false);

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
                        .replace(R.id.veh_learn_frag, learn_menu_frag)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    void setupList(View view, Resources resources) {

        TextView tv_veh = view.findViewById(R.id.tv_veh);
        tv_veh.setText(resources.getText(R.string.btn_vehicles));

        Drawable[] veh_val = {getActivity().getDrawable(R.mipmap.ic_car_foreground),
                getActivity().getDrawable(R.mipmap.ic_bike_foreground),
                getActivity().getDrawable(R.mipmap.ic_boat_foreground),
                getActivity().getDrawable(R.mipmap.ic_bus_foreground),
                getActivity().getDrawable(R.mipmap.ic_moto_foreground),
                getActivity().getDrawable(R.mipmap.ic_truck_foreground)
        };

        final ArrayAdapter<String> veh_list = new ArrayAdapter<String>(getActivity(), R.layout.list_item, R.id.tv_type_to_learn) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                String vehicle = getItem(position);

                ImageView im_veh = view.findViewById(R.id.img_type_learn);
                TextView tv_veh = view.findViewById(R.id.tv_type_to_learn);
                // ImageButton btn_speaker = view.findViewById(R.id.btn_speaker);

                tv_veh.setText(vehicle);
                im_veh.setImageDrawable(veh_val[position]);

                return view;
            }
        };
        veh_list.addAll(resources.getString(R.string.veh_car),
                resources.getString(R.string.veh_bike),
                resources.getString(R.string.veh_boat),
                resources.getString(R.string.veh_bus),
                resources.getString(R.string.veh_moto),
                resources.getString(R.string.veh_truck));

        ListView list = view.findViewById(R.id.list_veh);
        list.setAdapter(veh_list);
    }
}