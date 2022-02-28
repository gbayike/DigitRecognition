/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.olugbayikeade.onojobisdigitrecognition;

import java.io.FileNotFoundException;

/**
 *
 * @author olugb
 */
public class RunDigitRecognition {
    /**
     * Run the code
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        FileScanner dataset1 = new FileScanner("src/test/Resources/cw2DataSet1.csv");
        FileScanner dataset2 = new FileScanner("src/test/Resources/cw2DataSet2.csv");
        
       NFoldCrossValidation crss = new NFoldCrossValidation();
       double accuracy = crss.crossValidationKNN(dataset1.data, dataset2.data);
       
       System.out.println("The accuracy of the Algorithm is "+ accuracy);
       System.out.println("---------------------------------------------------------------------------------------------------------------------");
       
    }
}
