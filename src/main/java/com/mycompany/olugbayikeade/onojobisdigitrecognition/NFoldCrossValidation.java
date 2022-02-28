/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.olugbayikeade.onojobisdigitrecognition;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author olugb
 */
public class NFoldCrossValidation {


//    public NFoldCrossValidation(Map<ArrayList<Integer>, Integer> dataset1, Map<ArrayList<Integer>, Integer> dataset2) {
//        
//    }
    /**
     *  Cross validation function based on pseudocode from AIMA(Russel and Norvig)
     * @param k no of folds
     * @return 
     */
    public double crossValidationKNN(Dataset dataset1, Dataset dataset2) throws FileNotFoundException{
        int k = 2;
        ArrayList<Double> accuracy = new ArrayList();
        double totalAccuracy = 0;
        ArrayList<Dataset> dataset = new ArrayList();
        dataset.add(dataset1);
        dataset.add(dataset2);
        Knn knn = new Knn();
        for (int i = 0; i < k; i++) {
            if(i == 0){
                double individualAccuracy = knn.Knnrun(dataset1, dataset2, 3);
                accuracy.add(individualAccuracy);
                totalAccuracy += individualAccuracy;
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                System.out.println("The accuracy of fold " + (i + 1) + " = " + individualAccuracy);
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
            }else{
                double individualAccuracy = knn.Knnrun(dataset2, dataset1, 3);
                accuracy.add(individualAccuracy);
                totalAccuracy += individualAccuracy;
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
                System.out.println("The accuracy of fold " + (i + 1) + " = " + individualAccuracy);
                System.out.println("---------------------------------------------------------------------------------------------------------------------");
            }        
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < accuracy.size(); i++) {         
             
             System.out.println("The accuracy of fold " + (i + 1) + " = " + accuracy.get(i));
             System.out.println("");
        }
        return totalAccuracy/k;
    }
    
    
}
