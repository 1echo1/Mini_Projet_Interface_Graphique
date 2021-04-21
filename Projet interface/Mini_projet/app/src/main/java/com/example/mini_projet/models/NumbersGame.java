package com.example.mini_projet.models;

import com.example.mini_projet.utils.Constants;

import java.util.Random;

public class NumbersGame {

    public int[] numArray;
    public int num_to_find;

    public NumbersGame(){
        numArray=new int[4];
    }

    public int get_color_cell(int indice){
        return this.numArray[indice];
    }

    public void choose_numbers_display(){
        Boolean color_already_choose=false;
        Random rand=new Random();
        int rand_num;
        int indice=0;

        while(indice<4){
            rand_num = rand.nextInt(Constants.NBR_NUMS_TOTAL-1);
            for (int i = 0; i< this.numArray.length; i++){
                if (rand_num== this.numArray[i]){
                    color_already_choose=true;
                }
            }

            if (!color_already_choose){
                this.numArray[indice]=rand_num;
                indice++;
            }
            color_already_choose=false;
        }
    }

    public int getNum_to_find(){
        Random rand=new Random();
        int rand_num = rand.nextInt(Constants.NBR_NUMS_IN_GAME-1);
        num_to_find=this.numArray[rand_num];

        return this.numArray[rand_num];
    }

    public Boolean verify_victory(int choosed){
        if(choosed==this.num_to_find){
            return true;
        }
        return false;
    }
}
