/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseavancee;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
    
    
    

    
 
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
       
         // please uncomment the following code if you want to use random input  normally 
         // distributed centred at 50 with 7 deviance 
        // otherwise the program will ask you to introduce input
        
        
        PrintWriter writer = new PrintWriter("D:/Output2.csv", "UTF-8");
        writer.println("size,Clck,FIFO,LRU");
        
       for(int b= 3; b<=100;b++){
        
    
        Random  a = new Random();
        Vector in = new Vector();
        for(int i =0;i<10000;i++){
            in.add(new Double((a.nextGaussian()*20+100)).intValue());
        }
         processing p = new processing(in,b);
         
        
         
         
         // uncomment the following code to introduce your input 
      // processing p = new processing();
      
       // p.showStatus_SC();
       
         int missing_sc = p.Process_second_chance();
       
       // p.showStatus_SC();
       // System.out.println("********************************");
        int missing_FIFO = p.process_FIFO();
      //  p.showStatus_FIFO();
       //  System.out.println("********************************");
        int missing_LRU = p.process_LRU();
      //  p.showStatus_LRU();
       // System.out.println("\nNumber of missing pages :\n Second chance "+ missing_sc+" \n FIFO "+missing_FIFO+"\n LRU "+missing_LRU);
        
      //  System.out.println();
        System.out.println(b+" "+missing_sc+" "+missing_FIFO+" "+missing_LRU);
        String s =b+","+missing_sc+","+missing_FIFO+","+missing_LRU;
        writer.println(s);
      }
      
       writer.close();
    }
    
}
