package com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors;

import com.hamza.projects.buffer.replacement.datacreator.Buffer;
import com.hamza.projects.buffer.replacement.datacreator.Case;
import com.hamza.projects.buffer.replacement.exceptions.CannotCreateProcessorObjectException;

import java.util.List;

public class SecondChanceProcessor {

    private SecondChanceProcessor() throws CannotCreateProcessorObjectException {
        throw new CannotCreateProcessorObjectException();
    }

    public static int processSecondChance(List<Integer> inputData, int bufferSize) {

        int pointer = 0;
        int last = -1;
        int count = 0;
        // set first elements

        Buffer buffer = new Buffer(bufferSize);
        buffer.bufferInit();


        // parse all remaining pages
        for (Integer integer : inputData) {
            // if the element exists
            // parse all the buffer to search

            if (buffer.exist(integer.toString())) {

                String s = "input is " + integer.toString() + " frame exists";
                System.out.println(s);
                buffer.insertCase(new Case(integer.toString(), 1), buffer.existAt(integer.toString()));

            }
            // if the element does not exist

            else {

                pointer = (last + 1) % bufferSize;
                count++;
                while (buffer.elementAt(pointer).getFlag() != 0) {
                    String a = buffer.elementAt(pointer).getFrame();
                    buffer.insertCase(new Case(a, 0), pointer);
                    pointer = (pointer + 1) % bufferSize;

                }

                if (buffer.elementAt(pointer).getFlag() == 0) {

                    buffer.insertCase(new Case(integer.toString(), 0), pointer);
                    last = pointer;
                    pointer = (pointer + 1) % bufferSize;


                }
            }
        }
        System.out.println("end of second chance processing");
        return count;
    }

}
