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
        int missingPagesCount = 0;
        int caseToUpdateIndex = 0;
        // set first elements

        Buffer buffer = new Buffer(bufferSize);

        for (Integer caseData : inputData) {
            /*
            parse all the buffer to search
            if the element exists, nothing is to be done
            if the element does not contains, it should be insert and fault pages count incremented
            */

            if (!buffer.contains(caseData.toString())) {
                if (!buffer.isFull()) {
                    buffer.insertCase(new Case(caseData.toString()));
                } else {
                    buffer.insertCase(new Case(caseData.toString(), 0), caseToUpdateIndex);
                    caseToUpdateIndex = (caseToUpdateIndex + 1) % bufferSize;
                    missingPagesCount++;
                }
            }
        }
        return missingPagesCount;
    }
}
