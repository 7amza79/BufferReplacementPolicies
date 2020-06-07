package com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors;

import com.hamza.projects.buffer.replacement.datacreator.Buffer;
import com.hamza.projects.buffer.replacement.datacreator.Case;
import com.hamza.projects.buffer.replacement.exceptions.CannotCreateProcessorObjectException;

import java.util.List;

public class LruProcessor {

    private LruProcessor() throws CannotCreateProcessorObjectException {
        throw new CannotCreateProcessorObjectException();
    }

    public static int processLRU(List<Integer> inputData, int bufferSize) {
        int count = 0;
        // set first elements
        Buffer buffer = new Buffer(bufferSize);
        buffer.bufferInit();
        final int inBufferSize = buffer.getSize();

        for (Integer integer : inputData) {
            // if the element exists
            // search the index and put the item in the last case and push back all the other items

            if (buffer.exist(integer.toString())) {

                int lastIndex = buffer.existAt(integer.toString());
                Case a;
                a = buffer.elementAt(lastIndex);
                for (int k = lastIndex; k < (inBufferSize - 1); k++) {
                    buffer.insertCase(buffer.elementAt(k + 1), k);
                }
                buffer.insertCase(a, inBufferSize - 1);


            } else {
                // if the item doesn't exist in the buffer  we push back all the
                // items and we put the input item in the front

                for (int k = 0; k < (inBufferSize - 1); k++) {
                    buffer.insertCase(buffer.elementAt(k + 1), k);

                }
                Case a = new Case(integer.toString(), 0);
                buffer.insertCase(a, inBufferSize - 1);

                count++;
            }

        }
        System.out.println("end of processing LRU");
        return count;
    }

}
