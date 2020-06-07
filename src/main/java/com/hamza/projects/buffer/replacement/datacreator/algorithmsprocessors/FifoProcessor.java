package com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors;

import com.hamza.projects.buffer.replacement.datacreator.Buffer;
import com.hamza.projects.buffer.replacement.datacreator.Case;
import com.hamza.projects.buffer.replacement.exceptions.CannotCreateProcessorObjectException;

import java.util.List;

public class FifoProcessor {

    private FifoProcessor() throws CannotCreateProcessorObjectException {
        throw new CannotCreateProcessorObjectException();
    }

    public static int processFIFO(List<Integer> inputData, final Integer bufferSize) {
        int count = 0;
        int pointer = 0;
        // set first elements

        Buffer buffer = new Buffer(bufferSize);
        buffer.bufferInit();

        for (int i = 0; i < bufferSize; i++) {
            // if the element exists
            // parse all the buffer to search

            if (buffer.exist(inputData.get(i).toString())) {

                System.out.println("input is " + inputData.get(i).toString() + "/ frame exists");
            }

            // if the element does not exist

            else {

                try {
                    buffer.insertCase(new Case(inputData.get(i).toString(), 0), pointer);
                    pointer = (pointer + 1) % bufferSize;
                    count++;

                } catch (Exception e) {

                    System.out.println("Error with inserting new element");
                }

            }
        }
        System.out.println("end of processing fifo");
        return count;
    }
}
