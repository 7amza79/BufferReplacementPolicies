package com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class FifoProcessorTest {


    public static final ArrayList<Integer> FIRST_TEST_SERIES = new ArrayList<>(Arrays.asList(2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2, 5, 2));
    public static final ArrayList<Integer> SECOND_TEST_SERIES = new ArrayList<>(Arrays.asList(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1));

    static List<Integer> getRandomIntegers(final int bufferinitialSize) {
        List<Integer> inputData = new ArrayList<>();

        for (int i = 0; i < bufferinitialSize; i++) {
            final int intToAdd = new Random().nextInt(20);
            inputData.add(intToAdd);
        }
        return inputData;
    }

    @Test
    void fifoProcessorShouldReturn_ZeroFaultPages_whenInputLessThanBuffer() {

        //given
        final int bufferSize = 10;
        final int bufferinitialSize = 6;


        List<Integer> inputData = getRandomIntegers(bufferinitialSize);

        //when
        int missingPagesForFifo = FifoProcessor.process(inputData, bufferSize);

        //then
        Assertions.assertEquals(0, missingPagesForFifo);
    }

    @Test
    void fifoProcessorShouldReturn_RightFaultPages_whenGivenInput() {

        //given
        final int bufferSize = 3;

        //when
        int missingPagesForFifo = FifoProcessor.process(FIRST_TEST_SERIES, bufferSize);

        //then
        Assertions.assertEquals(10, missingPagesForFifo);
    }

    @Test
    void fifoProcessorShouldReturn_RightFaultPages_whenGivenInput2() {

        //given
        final int bufferSize = 3;

        //when
        int missingPagesForFifo = FifoProcessor.process(SECOND_TEST_SERIES, bufferSize);

        //then
        Assertions.assertEquals(12, missingPagesForFifo);
    }

    @Test
    void fifoProcessorShouldReturn_RightFaultPages_whenGivenInputAndIncreasedSize() {

        //given
        final int bufferSize = 4;

        //when
        int missingPagesForFifo = FifoProcessor.process(FIRST_TEST_SERIES, bufferSize);

        //then
        Assertions.assertEquals(3, missingPagesForFifo);
    }

    @Test
    void fifoProcessorShouldReturn_RightFaultPages_whenGivenInput2andIncreasedSize() {

        //given
        final int bufferSize = 4;

        //when
        int missingPagesForFifo = FifoProcessor.process(SECOND_TEST_SERIES, bufferSize);

        //then
        Assertions.assertEquals(6, missingPagesForFifo);
    }
}