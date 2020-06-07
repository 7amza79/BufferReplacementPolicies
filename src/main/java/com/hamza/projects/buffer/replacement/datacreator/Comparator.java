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

public class Comparator {

    private Comparator() {
    }

    public static void main(String[] args) throws IOException {

        try (PrintWriter writer = new PrintWriter("Output2.csv", StandardCharsets.UTF_8)) {
            writer.println("size,Clock,FIFO,LRU");
            for (int bufferSize = 3; bufferSize <= 50; bufferSize++) {

                List<Integer> input = initializeInputData();

                int missingSecondChancePages = processSecondChance(input, bufferSize);

                int missingFifoPages = processFIFO(input, bufferSize);

                int missingLruPages = processLRU(input, bufferSize);

                String s = bufferSize + "," + missingSecondChancePages + "," + missingFifoPages + "," + missingLruPages;
                writer.println(s);
            }
        }
    }

    private static List<Integer> initializeInputData() {
        List<Integer> input = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            input.add(Double.valueOf((random.nextGaussian() * 17 + 100)).intValue());
        }
        return input;
    }

}
