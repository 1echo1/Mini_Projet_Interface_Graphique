package com.example.mini_projet.models;

import com.example.mini_projet.utils.Constants;

import java.util.Random;

public class VehiclesGame {

    public int[] vehArray;
    public int veh_to_find;

    public VehiclesGame(){
        vehArray=new int[4];
    }

    public int get_veh_cell(int indice){
        return this.vehArray[indice];
    }

    public void choose_vehicles_display(){
        Boolean color_already_choose=false;
        Random rand=new Random();
        int rand_num;
        int indice=0;

        while(indice<4){
            rand_num = rand.nextInt(Constants.NBR_VEH_TOTAL);
            for (int i = 0; i< this.vehArray.length; i++){
                if (rand_num== this.vehArray[i]){
                    color_already_choose=true;
                }
            }

            if (!color_already_choose){
                this.vehArray[indice]=rand_num;
                indice++;
            }
            color_already_choose=false;
        }
    }

    public int getVeh_to_find(){
        Random rand=new Random();
        int rand_num = rand.nextInt(Constants.NBR_VEH_IN_GAME-1);
        veh_to_find=this.vehArray[rand_num];

        return this.vehArray[rand_num];
    }

    public Boolean verify_victory(int choosed){
        if(choosed==this.veh_to_find){
            return true;
        }
        return false;
    }


}

