/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.olugbayikeade.onojobisdigitrecognition;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author olugb
 */
public class Dataset {
    private Map<ArrayList<Integer>, Integer> data = new HashMap();
    private ArrayList<ArrayList<Integer>> key = new ArrayList();
    double distance;
    
    public Dataset(){
        
    }
    
    /**
     * Add contents to the data set data variable
     * @param pixelValues - the pixel value to add
     * @param number - the number associated with the pixel value
     */
    void addData(ArrayList<Integer> pixelValues, int number) {
        data.put(pixelValues, number);
        
    }
    
    /**
     * add the pixel values only to the key variable.
     */
    
    void addKeys(){
        key.addAll(convertKeysToArrayList(data));
    }
    
    /**
     * Returns the data stores in key (pixel value) and value (integer values i.e. 1, 2, etc.) pairs
     * @return data
     */
    Map<ArrayList<Integer>, Integer> getData(){
        //int value = data.get(key.get(0));
        //System.out.println(value);
        //System.out.println();
        return data;
    }
    
    /**
     * sets the ecluidean distance
     * @param distance 
     */
    void setDistance(double distance){
        this.distance = distance;
    }
    
    double getDistance(){
        return distance;
    }
    String size(){
        return "Key size is " + key.size() + " data size is " + data.size();
    }
    
    /**
     * Returns all keys (pixel values) in the data set
     * @return key
     */
    ArrayList<ArrayList<Integer>> getKey(){
        
        return key;
    }
    
    /**
     * display all the key value pairs in the HashMap.
     * @param map the HashMap containing the key value pairs.
     */
    void printData(Map<ArrayList<Integer>, Integer> map){
        System.out.println(map);
    }
    
    /**
     * Converts the hashMap keys to an array list.
     * @param data the hashMap that has the key.
     * @return key - the arayList containing all keys in data.
     */
    ArrayList<ArrayList<Integer>> convertKeysToArrayList(Map<ArrayList<Integer>, Integer> data){
        Set<ArrayList<Integer>> Keyset = data.keySet();
        ArrayList<ArrayList<Integer>> key = new ArrayList(Keyset);
        return key;
    }
    
    
    /**
     * Gets the number that has the pixel values from the hashMap.
     * @param pixelValues the pixel values of the number. Note has to be in data.
     * @param data the HashMap containing the pixel values and the number.
     * @return number - the number that has the pixel value.
     */
    int getNumber(ArrayList<Integer> pixelValues, Map<ArrayList<Integer>, Integer> data){
        int number = data.get(pixelValues);
//        System.out.println(number);
        return number;
    }
}
