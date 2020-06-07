/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamza.projects.buffer.replacement.datacreator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors.FifoProcessor.processFIFO;
import static com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors.LruProcessor.processLRU;
import static com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors.SecondChanceProcessor.processSecondChance;

/**
 * @author Hamza
 */
public class Comparaison {


    private Comparaison() {

    }


    public static void main(String[] args) throws IOException {

        // please uncomment the following code if you want to use random input  normally
        // distributed centred at 50 with 7 deviance
        // otherwise the program will ask you to introduce input


        PrintWriter writer = new PrintWriter("Output2.csv", StandardCharsets.UTF_8);
        writer.println("size,Clck,FIFO,LRU");
        System.out.println("size,Clck,FIFO,LRU");
        for (int bufferSize = 3; bufferSize <= 50; bufferSize++) {


            Random a = new Random();
            List<Integer> input = new ArrayList<>();
            initializeInputDate(a, input);


            int missingSecondChancePages = processSecondChance(input, bufferSize);

            int missingFifoPages = processFIFO(input, bufferSize);

            int missingLruPages = processLRU(input, bufferSize);

            System.out.println("\nNumber of missing pages :\n Second chance " + missingSecondChancePages + " \n FIFO " + missingFifoPages + "\n LRU " + missingLruPages);

            System.out.println(bufferSize + " " + missingSecondChancePages + " " + missingFifoPages + " " + missingLruPages);
            String s = bufferSize + "," + missingSecondChancePages + "," + missingFifoPages + "," + missingLruPages;
            writer.println(s);
        }

        writer.close();
    }

    private static void initializeInputDate(Random a, List<Integer> input) {
        for (int i = 0; i < 10000; i++) {
            input.add(Double.valueOf((a.nextGaussian() * 17 + 100)).intValue());
        }
    }

}
