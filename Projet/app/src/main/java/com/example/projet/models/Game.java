package com.example.projet.models;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.example.projet.R;
import com.example.projet.utils.Constants;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public int[] array;
    public int element_to_find;
    public int total_choices;

    private ArrayList<String> color_val = new ArrayList<String>();
    private ArrayList<String> num_val = new ArrayList<String>();
    private ArrayList<String> veh_val = new ArrayList<String>();

    public Game(int total_choices,Context context) {

        this.total_choices = total_choices;
        this.array = new int[4];

        color_val.add(context.getString(R.string.clr_orange));
        color_val.add(context.getString(R.string.clr_blue));
        color_val.add(context.getString(R.string.clr_green));
        color_val.add(context.getString(R.string.clr_yellow));
        color_val.add(context.getString(R.string.clr_red));
        color_val.add(context.getString(R.string.clr_black));
        color_val.add(context.getString(R.string.clr_white));
        color_val.add(context.getString(R.string.clr_brown));

        num_val.add(context.getString(R.string.num_zero));
        num_val.add(context.getString(R.string.num_one));
        num_val.add(context.getString(R.string.num_two));
        num_val.add(context.getString(R.string.num_three));
        num_val.add(context.getString(R.string.num_four));
        num_val.add(context.getString(R.string.num_five));
        num_val.add(context.getString(R.string.num_six));
        num_val.add(context.getString(R.string.num_seven));
        num_val.add(context.getString(R.string.num_eight));
        num_val.add(context.getString(R.string.num_nine));

        veh_val.add(context.getString(R.string.veh_car));
        veh_val.add(context.getString(R.string.veh_moto));
        veh_val.add(context.getString(R.string.veh_truck));
        veh_val.add(context.getString(R.string.veh_bus));
        veh_val.add(context.getString(R.string.veh_boat));
        veh_val.add(context.getString(R.string.veh_bike));
    }

    public int get_cell(int indice) {
        return this.array[indice];
    }

    public void choose_elements_display() {
        Boolean color_already_choose = false;
        Random rand = new Random();
        int rand_num;
        int indice = 0;

        while (indice < 4) {
            rand_num = rand.nextInt(this.total_choices);
            for (int i = 0; i < this.array.length; i++) {
                if (rand_num == this.array[i]) {
                    color_already_choose = true;
                }
            }

            if (!color_already_choose) {
                this.array[indice] = rand_num;
                indice++;
            }
            color_already_choose = false;
        }
    }

    public int get_element_to_find() {
        Random rand = new Random();
        int rand_num = rand.nextInt(Constants.NBR_CHOICES_IN_GAME - 1);
        element_to_find = this.array[rand_num];

        return this.array[rand_num];
    }

    public int get_element_to_write(int type) {
        Random rand = new Random();
        int rand_num=0;
        switch (type) {
            case Constants.TYPE_COLORS:
                rand_num = rand.nextInt(Constants.NBR_COLORS_TOTAL - 1);
                break;
            case Constants.TYPE_NUM:
                rand_num = rand.nextInt(Constants.NBR_NUMS_TOTAL - 1);
                break;
            case Constants.TYPE_VEH:
                rand_num = rand.nextInt(Constants.NBR_VEH_TOTAL - 1);
                break;
        }
        element_to_find =rand_num;
        return rand_num;
    }

    public Boolean verify_find_victory(int choosed) {
        if (choosed == this.element_to_find) {
            return true;
        }
        return false;
    }

    public Boolean verify_write_victory(String input, int type) {
        
        boolean victory = false;

        switch (type) {
            case Constants.TYPE_COLORS:
                if (color_val.get(this.element_to_find).equalsIgnoreCase(input)
                        || (color_val.get(this.element_to_find)+" ").equalsIgnoreCase(input) ){
                    victory = true;
                }
                break;
            case Constants.TYPE_NUM:
                if (num_val.get(this.element_to_find).equalsIgnoreCase(input)
                        || (num_val.get(this.element_to_find)+" ").equalsIgnoreCase(input)) {
                    victory = true;
                }
                break;
            case Constants.TYPE_VEH:
                if (veh_val.get(this.element_to_find).equalsIgnoreCase(input)
                        || (veh_val.get(this.element_to_find)+" ").equalsIgnoreCase(input)) {
                    victory = true;
                }
                break;
        }
        return victory;
    }
}
