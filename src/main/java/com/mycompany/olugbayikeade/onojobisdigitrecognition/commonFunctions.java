/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.olugbayikeade.onojobisdigitrecognition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author olugb
 */
public class commonFunctions {
    // function to sort hashmap by values
    public Map<Integer, Double> sortByValue(Map<Integer, Double> hm){
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Double>> list
            = new LinkedList<Map.Entry<Integer, Double>>(
                hm.entrySet());
 
        // Sort the list using lambda expression
        Collections.sort(
            list,
            (i1,
             i2) -> i1.getValue().compareTo(i2.getValue()));
 
        // put data from sorted list to hashmap
        Map<Integer, Double> temp = new LinkedHashMap<Integer, Double>();
        for (Map.Entry<Integer, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    
     
    ArrayList<Integer> modeWithMaps(ArrayList<Integer> list){
        ArrayList<Integer> modes = new ArrayList();
        Map<Integer, Integer> hp = new HashMap();
        int size = list.size();
        for(int i = 0; i< size;i++){
            int key = list.get(i);
            if(hp.containsKey(key)){
                int frequency = hp.get(key);
                frequency++;
                hp.put(key, frequency);
            }else{
                hp.put(key, 1);
            }
        }
        
        int maxValue = (Collections.max(hp.values()));
        
        hp.forEach((k, val) -> {
            if(val.equals(maxValue)) {
                modes.add(k);
            }
        });
        
        return modes;
    }

    
    double testaccuracy(Dataset actual, Dataset predicted){
        int correct = 0;
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                      Pixel Value                      | Actual Value | Predicted Value | Correct ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i = 0; i < actual.getData().size();i++){
            ArrayList<Integer> pixelValues = actual.getKey().get(i);
            int actualValue = actual.getData().get(pixelValues);
            int predictedValue =  predicted.getData().get(pixelValues);
            System.out.print(pixelValues + " | ");
            System.out.print(actualValue + " | ");
            System.out.print(predictedValue + " | ");
            if( actualValue == predictedValue){
                correct += 1;
                System.out.println(" True ");
            }else{
                System.out.println(" False ");
            }
            
        }
        double actualSize = actual.getData().size();
        return correct / actualSize * 100.0;
    }
}
