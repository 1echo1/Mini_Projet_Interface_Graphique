package com.example.mini_projet.models;

import com.example.mini_projet.utils.Constants;

import java.util.Random;

public class Color_game {

    public int[] colorArray;
    public int color_to_find;

    public Color_game(){
        colorArray=new int[4];
    }

    public int get_color_cell(int indice){
        return this.colorArray[indice];
    }

    public void choose_colors_display(){
        Boolean color_already_choose=false;
        Random rand=new Random();
        int rand_num;
        int indice=0;

        while(indice<4){
            rand_num = rand.nextInt(Constants.NBR_COLORS_TOTAL-1);
            for (int i = 0; i< this.colorArray.length; i++){
                if (rand_num== this.colorArray[i]){
                    color_already_choose=true;
                }
            }

            if (!color_already_choose){
                this.colorArray[indice]=rand_num;
                indice++;
            }
            color_already_choose=false;
        }
    }

    public int getColor_to_find(){
        Random rand=new Random();
        int rand_num = rand.nextInt(Constants.NBR_COLORS_IN_GAME-1);
        color_to_find=this.colorArray[rand_num];

        return this.colorArray[rand_num];
    }

    public Boolean verify_victory(int choosed){
        if(choosed==this.color_to_find){
            return true;
        }
        return false;
    }


}
