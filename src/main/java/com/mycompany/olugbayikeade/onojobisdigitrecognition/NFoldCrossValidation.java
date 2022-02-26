/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.olugbayikeade.onojobisdigitrecognition;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author olugb
 */
public class NFoldCrossValidation {


    public NFoldCrossValidation(Map<ArrayList<Integer>, Integer> dataset1, Map<ArrayList<Integer>, Integer> dataset2) {
        
    }
    /**
     *  Cross validation function based on pseudocode from AIMA(Russel and Norvig)
     * @param k no of folds
     * @return 
     */
    public double crossValidation(int k, Map<ArrayList<Integer>, Integer> dataset1, Map<ArrayList<Integer>, Integer> dataset2){
        double errs =0;
        for (int i = 0; i < k; i++) {
            if(i == 0){
                
            }
        }
        return errs/k;
    }
}
