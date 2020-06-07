package com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class FifoProcessorTest {


    @Test
    void fifoProcessorShouldReturn_FaultPages_whenInputLessThanBuffer() {

        //given
        final int bufferSize = 10;
        final int bufferinitialSize = 6;


        List<Integer> inputData = new ArrayList<>();

        for (int i = 0; i < bufferinitialSize; i++) {
            final int intToAdd = new Random().nextInt(20);
            inputData.add(intToAdd);
            System.out.println(intToAdd);
        }

        //when
        int missingPagesForFifo = FifoProcessor.processFIFO(inputData, bufferSize);

        //then
        Assertions.assertEquals(0, missingPagesForFifo);
    }
}