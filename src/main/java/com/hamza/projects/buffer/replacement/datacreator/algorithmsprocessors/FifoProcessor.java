package com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors;

import com.hamza.projects.buffer.replacement.datacreator.Buffer;
import com.hamza.projects.buffer.replacement.datacreator.Case;
import com.hamza.projects.buffer.replacement.exceptions.CannotCreateProcessorObjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
public class FifoProcessor {

    private FifoProcessor() throws CannotCreateProcessorObjectException {
        throw new CannotCreateProcessorObjectException();
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(FifoProcessor.class);

    public static int processFIFO(List<Integer> inputData, final Integer bufferSize) {
        int missingPagesCount = 0;
        int caseToUpdateIndex = 0;
        // set first elements

        Buffer buffer = new Buffer(bufferSize);

        for (Integer caseData : inputData) {
            // if the element exists
            // parse all the buffer to search

            if (buffer.exist(caseData.toString())) {
                final String stringToDisplay = "input is " + caseData.toString() + "/ frame exists";
                LOGGER.info(stringToDisplay);
            }
            // if the element does not exist
            else {
                buffer.insertCase(new Case(caseData.toString(), 0), caseToUpdateIndex);
                caseToUpdateIndex = (caseToUpdateIndex + 1) % bufferSize;
                missingPagesCount++;

            }
        }
        LOGGER.info("end of processing fifo");
        return missingPagesCount;
    }
}
