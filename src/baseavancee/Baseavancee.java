/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseavancee;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Hamza
 */
public class Baseavancee {

    /**
     * @param args the command line arguments
     */
    
    
    private int size ;
    private Vector input;

    public Baseavancee() {
        
    }
    
    
    

    
 
    public static void main(String[] args) {
       
         // please uncomment the following code if you want to use random input  normally 
         // distributed centred at 50 with 7 deviance 
        // otherwise the program will ask you to introduce input
        /*
         Random  a = new Random();
        Vector in = new Vector();
        for(int i =0;i<500;i++){
            in.add(new Double((a.nextGaussian()*10+50)).intValue());
        }
         processing p = new processing(in);
         for(int i=0;i<in.size();i++){
             System.out.print(in.elementAt(i)+" ");
         }
         */
         
        processing p = new processing();
      
        p.showStatus_SC();
        int missing_sc = p.Process_second_chance();
       
        p.showStatus_SC();
        System.out.println("********************************");
        int missing_FIFO = p.process_FIFO();
        p.showStatus_FIFO();
         System.out.println("********************************");
        int missing_LRU = p.process_LRU();
        p.showStatus_LRU();
        System.out.println("\n Second chance "+ missing_sc+" \n FIFO "+missing_FIFO);
        
        System.out.println("missing LRU "+missing_LRU);
        
      
         
    }
    
}
