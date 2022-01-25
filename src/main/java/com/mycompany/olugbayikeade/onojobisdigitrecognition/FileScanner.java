/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.olugbayikeade.onojobisdigitrecognition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Olugbayike
 */
public class FileScanner {
    String S;
    // create and use a file reader wrapper in a BufferedReader.
    String filePath;
    Map<ArrayList<Integer>, Integer> data = new HashMap();
    ArrayList<ArrayList<Integer>> key = new ArrayList();
    
//    Set<Integer> keyValues;
//    public Integer[] cityArray;
    
    /** 
     * FileScanner constructor  
     * 
     * @param FilePath -  the path of the file to read.
     */
    
    public FileScanner(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        this.data.putAll(ReadtextFromFile());
        this.key.addAll(convertKeysToArrayList(this.data));
//        keyValues = data.keySet();
//        cityArray = keyValues.toArray(new Integer[keyValues.size()]);
    }
    
    public String deleteSubString(String str, int index){
        str = str.substring(index);
        return str;
    }
    
    
    /**
     * ReadtextFrom file returns data width is a hash map of the data gotten from the
     * text file. 
     * @return data - the HashMap derived from the CSV file.
     * @throws FileNotFoundException 
     */
    public Map<ArrayList<Integer>, Integer> ReadtextFromFile() throws FileNotFoundException{
        Map<ArrayList<Integer>, Integer> data = new HashMap<ArrayList<Integer>, Integer>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            while((S = br.readLine()) != null){
//                System.out.println("-----------------------");
//                System.out.println(S);
//                System.out.println("-----------------------");
                String []arrayS = S.split(",", 0);
                
                ArrayList<Integer> pixelValues = new ArrayList();
                for(int i = 0; i < (arrayS.length - 1); i++){
                    int value = Integer.parseInt(arrayS[i]);
                    pixelValues.add(value);
                }
                int number = Integer.parseInt(arrayS[arrayS.length - 1]);

                data.put(pixelValues, number);

            }
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex);
        }
        return data;
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
    
    /**
     * display all the key value pairs in the HashMap.
     * @param map the HashMap containing the key value pairs.
     */
    void printData(Map<ArrayList<Integer>, Integer> map){
        System.out.println(map);
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
        FileScanner objscn= new FileScanner("src/test/Resources/cw2DataSet1.csv");
        objscn.printData(objscn.data);
//        System.out.println(objscn.data.size());
        System.out.println(objscn.key);
        System.out.println(objscn.getNumber(objscn.key.get(0), objscn.data));
//        ArrayList<Integer> pixelvalues= new ArrayList();
//        Collections.addAll(pixelvalues, 0,0,7,9,13,11,2,0,0,6,16,9,1,13,8,0,0,8,14,5,11,14,2,0,0,3,16,16,16,6,0,0,0,2,16,5,1,12,5,0,0,4,15,0,0,8,8,0,0,3,16,4,7,13,2,0,0,0,13,12,8,1,0,0);
//        objscn.getNumber(pixelvalues, objscn.data);
    }
}
