package com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors.FifoProcessorTest.getRandomIntegers;

class LruProcessorTest {

    @Test
    void lruProcessorShouldReturn_ZeroFaultPages_whenInputLessThanBuffer() {
        //given
        final int bufferSize = 10;
        final int bufferinitialSize = 6;


        List<Integer> inputData = getRandomIntegers(bufferinitialSize);

        //when
        int missingPagesForLru = LruProcessor.process(inputData, bufferSize);

        //then
        Assertions.assertEquals(0, missingPagesForLru);
    }

    @Test
    void LruProcessorShouldReturn_RightFaultPages_whenGivenInputAndSize() {

        //given
        final int bufferSize = 3;

        List<Integer> inputData = new ArrayList<>(Arrays.asList(2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2, 5, 2));

        //when
        int missingPagesForLru = LruProcessor.process(inputData, bufferSize);

        //then
        Assertions.assertEquals(12, missingPagesForLru);
    }


    @Test
    void LruProcessorShouldReturn_RightFaultPages_whenGivenInput2AndSize() {

        //given
        final int bufferSize = 3;

        List<Integer> inputData = new ArrayList<>(Arrays.asList(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1));

        //when
        int missingPagesForLru = LruProcessor.process(inputData, bufferSize);

        //then
        Assertions.assertEquals(9, missingPagesForLru);
    }


    @Test
    void LruProcessorShouldReturn_RightFaultPages_whenGivenInputAndSizeIncreased() {

        //given
        final int bufferSize = 4;

        List<Integer> inputData = new ArrayList<>(Arrays.asList(2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2, 5, 2));

        //when
        int missingPagesForLru = LruProcessor.process(inputData, bufferSize);

        //then
        Assertions.assertEquals(2, missingPagesForLru);
    }


    @Test
    void LruProcessorShouldReturn_RightFaultPages_whenGivenInput2AndSizeIncreased() {

        //given
        final int bufferSize = 4;

        List<Integer> inputData = new ArrayList<>(Arrays.asList(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1));

        //when
        int missingPagesForLru = LruProcessor.process(inputData, bufferSize);

        //then
        Assertions.assertEquals(4, missingPagesForLru);
    }


}