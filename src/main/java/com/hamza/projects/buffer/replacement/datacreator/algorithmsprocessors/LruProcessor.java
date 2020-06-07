package com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors;

import com.hamza.projects.buffer.replacement.datacreator.Buffer;
import com.hamza.projects.buffer.replacement.datacreator.Case;
import com.hamza.projects.buffer.replacement.exceptions.CannotCreateProcessorObjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LruProcessor {

    private LruProcessor() throws CannotCreateProcessorObjectException {
        throw new CannotCreateProcessorObjectException();
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(LruProcessor.class);

    public static int processLRU(List<Integer> inputData, int bufferSize) {
        LOGGER.info("Start LRU processing");
        int count = 0;
        // set first elements
        Buffer buffer = new Buffer(bufferSize);

        for (Integer caseData : inputData) {
            // if the element exists
            // search the index and put the item in the last case and push back all the other items

            if (buffer.exist(caseData.toString())) {

                final int searchedCasePosition = buffer.existAt(caseData.toString());
                Case caseToUpdate = buffer.elementAt(searchedCasePosition);

                for (int k = searchedCasePosition; k < (bufferSize - 1); k++) {
                    buffer.insertCase(buffer.elementAt(k + 1), k);
                }
                buffer.insertCase(caseToUpdate, bufferSize - 1);


            } else {
                // if the item doesn't exist in the buffer  we push back all the
                // items and we put the input item in the front

                for (int k = 0; k < (bufferSize - 1); k++) {
                    buffer.insertCase(buffer.elementAt(k + 1), k);

                }
                Case a = new Case(caseData.toString(), 0);
                buffer.insertCase(a, bufferSize - 1);

                count++;
            }

        }
        LOGGER.info("end of processing LRU with {} fault pages", count);
        return count;
    }

}
