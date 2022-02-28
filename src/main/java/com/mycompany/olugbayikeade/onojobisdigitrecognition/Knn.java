/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.olugbayikeade.onojobisdigitrecognition;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author olugb
 */
public class Knn extends commonFunctions{
    
    /**
     * The K-NN Algorithm implementation
     * @param train the train data set
     * @param test the test data set
     * @param k the number of nearest neighbours to filter
     * @return 
     */
    Dataset knnAlgorithm(Dataset train, Dataset test, int k){
        Dataset estimatedValues = new Dataset();  // contains the integer value as key and the distance as value
        
        for(ArrayList<Integer> testData : test.getKey()){
            // List to store the pixel value (key), distance (value) pairs
            ArrayList<Dataset> allDistances = new ArrayList();
            // loop through the training data
            int keySize = train.getKey().size();
            for (int i = 0; i < keySize; i++) {
                ArrayList<Integer> trainData = train.getKey().get(i);
                double individualDistance = euclideanDistance(testData, trainData);
                Dataset dataWithDistances = new Dataset();
                int trainValue = train.getData().get(trainData);
                
                dataWithDistances.addData(trainData, trainValue);
                dataWithDistances.setDistance(individualDistance);
                dataWithDistances.addKeys();
                allDistances.add(dataWithDistances);
            }
            
            Collections.sort(allDistances, new Comparator<Dataset>() {

                @Override
                public int compare(Dataset o1, Dataset o2) {
                    return Double.compare(o1.getDistance(), o2.getDistance());
                }
            });

            List<Dataset> kElements = allDistances.subList(0, k);


            ArrayList<Integer> kValues = new ArrayList();
            for(Dataset data : kElements){
                ArrayList<Integer> pixelValues = data.getKey().get(0);
                kValues.add(data.getData().get(pixelValues));
            }    
            
            ArrayList<Integer> modeList = modeWithMaps(kValues);
            int size = modeList.size();
            int mode = 0;
            if(size == 1){
                mode = modeList.get(0);
            }if(size > 1){
                Random rand = new Random();
                int randValue = rand.nextInt(k);
                mode = modeList.get(randValue);
            }if(size< 1){
                System.out.println("Its a size of zero");
            }
            estimatedValues.addData(testData, mode);
            estimatedValues.addKeys();
        }
        
        return estimatedValues;
    }
    
    
    /**
     * run the K-NN algorithm
     * @param train the train data set
     * @param test the test data set
     * @param k the number of nearest neighbours to filter
     * @return 
     */
    double Knnrun(Dataset train, Dataset test, int k){
        Dataset predictedValues = knnAlgorithm(train, test, k);
        double accuracy = testaccuracy(test, predictedValues);
//        System.out.println("Accuracy is: "+ accuracy);
        return accuracy;
    }
    
    /**
     * calculates the euclidean distance between pixel values
     * @param key1 the first list of pixel values
     * @param key2 the second list of pixel values
     * @return 
     */
     private double euclideanDistance(ArrayList<Integer> key1, ArrayList<Integer> key2){
        int size = key1.size();
        double equation = 0;
        for(int i=0; i<size;i++){
            int value1 = key1.get(i);
            int value2 = key2.get(i);
            int comparison = value1 - value2;
            equation += Math.pow(comparison, 2);
        }
        
        return Math.sqrt(equation);
    }
}
