package com.example.projet.models;

import com.example.projet.utils.Constants;

import java.util.Random;

public class GameEye {
    public int[] array;
    public int element_to_find;
    public int total_choices;

    public GameEye(int total_choices){
        this.total_choices=total_choices;
        this.array=new int[4];
    }

    public int get_cell(int indice){
        return this.array[indice];
    }

    public void choose_elements_display(){
        Boolean color_already_choose=false;
        Random rand=new Random();
        int rand_num;
        int indice=0;

        while(indice<4){
            rand_num = rand.nextInt(this.total_choices);
            for (int i = 0; i< this.array.length; i++){
                if (rand_num== this.array[i]){
                    color_already_choose=true;
                }
            }

            if (!color_already_choose){
                this.array[indice]=rand_num;
                indice++;
            }
            color_already_choose=false;
        }
    }

    public int get_element_to_find(){
        Random rand=new Random();
        int rand_num = rand.nextInt(Constants.NBR_CHOICES_IN_GAME-1);
        element_to_find=this.array[rand_num];

        return this.array[rand_num];
    }

    public Boolean verify_victory(int choosed){
        if(choosed==this.element_to_find){
            return true;
        }
        return false;
    }
}
