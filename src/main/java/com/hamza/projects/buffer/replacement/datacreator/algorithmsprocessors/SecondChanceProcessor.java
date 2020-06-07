package com.hamza.projects.buffer.replacement.datacreator.algorithmsprocessors;

import com.hamza.projects.buffer.replacement.datacreator.Buffer;
import com.hamza.projects.buffer.replacement.datacreator.Case;
import com.hamza.projects.buffer.replacement.exceptions.CannotCreateProcessorObjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SecondChanceProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecondChanceProcessor.class);

    private SecondChanceProcessor() throws CannotCreateProcessorObjectException {
        throw new CannotCreateProcessorObjectException();
    }

    public static int processSecondChance(List<Integer> inputData, int bufferSize) {

        int pointer;
        int last = -1;
        int count = 0;

        Buffer buffer = new Buffer(bufferSize);

        LOGGER.info("Start second change processing");
        for (Integer caseData : inputData) {
            // if the element exists
            // parse all the buffer to search

            if (buffer.exist(caseData.toString())) {
                buffer.insertCase(new Case(caseData.toString(), 1), buffer.existAt(caseData.toString()));
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
                    buffer.insertCase(new Case(caseData.toString(), 0), pointer);
                    last = pointer;
                }
            }
        }
        LOGGER.info("End of second chance algorithm processing");
        return count;
    }

}
