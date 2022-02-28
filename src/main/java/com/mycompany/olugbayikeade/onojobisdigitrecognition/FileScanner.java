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
//    Map<ArrayList<Integer>, Integer> data = new HashMap();
//    ArrayList<ArrayList<Integer>> key = new ArrayList();
     Dataset data;
//    Set<Integer> keyValues;
//    public Integer[] cityArray;
    
    /** 
     * FileScanner constructor  
     * 
     * @param FilePath -  the path of the file to read.
     */
    
    public FileScanner(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        data = ReadtextFromFile();
//        this.key.addAll(convertKeysToArrayList(this.data));
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
    public Dataset ReadtextFromFile() throws FileNotFoundException{
        Dataset data = new Dataset();
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

                data.addData(pixelValues, number);

            }
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex);
        }
        data.addKeys();
        return data;
    }
}
