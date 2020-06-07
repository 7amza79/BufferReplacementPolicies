package com.hamza.projects.buffer.replacement.datacreator;

import com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors.FifoProcessor;
import com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors.LruProcessor;
import com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors.SecondChanceProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Comparator {

    public static final int BUFFER_MINIMUM_SIZE = 3;
    public static final int BUFFER_MAXIMUM_SIZE = 50;
    public static final String OUTPUT_FILE_PATH = "Output.csv";
    public static final int INPUT_SIZE = 10000;

    private Comparator() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Comparator.class);

    public static void main(String[] args) throws IOException {

        LOGGER.info("Starting processing Clock, FIFO and LRU algorithms on buffers with size from {} to {}",
                BUFFER_MINIMUM_SIZE, BUFFER_MAXIMUM_SIZE);
        try (PrintWriter writer = new PrintWriter(OUTPUT_FILE_PATH, StandardCharsets.UTF_8)) {
            writer.println("size,Clock,FIFO,LRU");
            for (int bufferSize = BUFFER_MINIMUM_SIZE; bufferSize <= BUFFER_MAXIMUM_SIZE; bufferSize++) {

                List<Integer> input = initializeInputData();

                int missingSecondChancePages = SecondChanceProcessor.process(input, bufferSize);

                int missingFifoPages = FifoProcessor.process(input, bufferSize);

                int missingLruPages = LruProcessor.process(input, bufferSize);

                String s = bufferSize + "," + missingSecondChancePages + "," + missingFifoPages + "," + missingLruPages;
                writer.println(s);
            }
        }
        LOGGER.info("End processing");
    }

    private static List<Integer> initializeInputData() {
        List<Integer> input = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < Comparator.INPUT_SIZE; i++) {
            input.add(Double.valueOf((random.nextGaussian() * 17 + 100)).intValue());
        }
        return input;
    }

}
