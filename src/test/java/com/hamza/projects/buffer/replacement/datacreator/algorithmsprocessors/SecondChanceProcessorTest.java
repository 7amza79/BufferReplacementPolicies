package com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors.FifoProcessorTest.getRandomIntegers;

class SecondChanceProcessorTest {

    @Test
    void SecondChanceProcessorShouldReturn_ZeroFaultPages_whenInputLessThanBuffer() {
        //given
        final int bufferSize = 10;
        final int bufferinitialSize = 6;


        List<Integer> inputData = getRandomIntegers(bufferinitialSize);

        //when
        int missingPagesForSecondChance = SecondChanceProcessor.process(inputData, bufferSize);

        //then
        Assertions.assertEquals(0, missingPagesForSecondChance);
    }

    @Test
    void SecondChanceProcessorShouldReturn_RightFaultPages_whenGivenInput() {

        //given
        final int bufferSize = 3;

        List<Integer> inputData = new ArrayList<>(Arrays.asList(2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2, 5, 2));

        //when
        int missingPagesForSecondChance = SecondChanceProcessor.process(inputData, bufferSize);

        //then
        Assertions.assertEquals(11, missingPagesForSecondChance);
    }

    @Test
    void SecondChanceProcessorShouldReturn_RightFaultPages_whenGivenInput2() {

        //given
        final int bufferSize = 3;

        List<Integer> inputData = new ArrayList<>(Arrays.asList(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1));

        //when
        int missingPagesForSecondChance = SecondChanceProcessor.process(inputData, bufferSize);

        //then
        Assertions.assertEquals(8, missingPagesForSecondChance);
    }

    @Test
    void SecondChanceProcessorShouldReturn_RightFaultPages_whenGivenInputAndIncreasedBuffer() {

        //given
        final int bufferSize = 4;

        List<Integer> inputData = new ArrayList<>(Arrays.asList(2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2, 5, 2));

        //when
        int missingPagesForSecondChance = SecondChanceProcessor.process(inputData, bufferSize);

        //then
        Assertions.assertEquals(2, missingPagesForSecondChance);
    }

    @Test
    void SecondChanceProcessorShouldReturn_RightFaultPages_whenGivenInput2AndIncreasedBuffer() {

        //given
        final int bufferSize = 4;

        List<Integer> inputData = new ArrayList<>(Arrays.asList(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1));

        //when
        int missingPagesForSecondChance = SecondChanceProcessor.process(inputData, bufferSize);

        //then
        Assertions.assertEquals(4, missingPagesForSecondChance);
    }


}