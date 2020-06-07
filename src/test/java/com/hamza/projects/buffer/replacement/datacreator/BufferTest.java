package com.hamza.projects.buffer.replacement.datacreator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BufferTest {


    @Test
    public void existsShouldReturnTrueWhenElementIsInBuffer() {

        //given
        Case aCase = new Case("case1", 0);
        Case aCase2 = new Case("case2", 0);
        Case aCase3 = new Case("case3", 0);

        //when
        Buffer buffer = new Buffer(3);
        buffer.insertCase(aCase);
        buffer.insertCase(aCase2);
        buffer.insertCase(aCase3);


        //then
        Assertions.assertFalse(buffer.contains("aCase2"));
        Assertions.assertTrue(buffer.contains("case1"));
        Assertions.assertTrue(buffer.contains("case1"));
        Assertions.assertTrue(buffer.contains("case3"));
    }

    @Test
    void existsAtShouldReturnElementNotExists_whenElementDoesNotExist() {

        //given
        Case aCase = new Case("case1", 0);
        Case aCase2 = new Case("case2", 0);
        Case aCase3 = new Case("case3", 0);
        Buffer buffer = new Buffer(3);
        buffer.insertCase(aCase);
        buffer.insertCase(aCase2);
        buffer.insertCase(aCase3);

        //when
        final int inexistantCaseIndex = buffer.existAt("case56");

        //then
        Assertions.assertEquals(-1, inexistantCaseIndex);
    }

    @Test
    void existsAt_should_returnCorrectPosition_whenElementExists() {

        //given
        Case aCase = new Case("case1", 0);
        Case aCase2 = new Case("case2", 0);
        Case aCase3 = new Case("case3", 0);
        Buffer buffer = new Buffer(3);
        buffer.insertCase(aCase);
        buffer.insertCase(aCase2);
        buffer.insertCase(aCase3);

        //when
        final int case2Index = buffer.existAt("case2");

        //then
        Assertions.assertEquals(1, case2Index);
    }


}