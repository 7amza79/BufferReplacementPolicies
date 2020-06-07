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

        int pointer;
        int last = -1;
        int missingPagesCount = 0;

        Buffer buffer = new Buffer(bufferSize);

        for (Integer caseData : inputData) {
            // if the element exists, increment its flag to 1

            if (buffer.exist(caseData.toString())) {
                buffer.insertCase(new Case(caseData.toString(), 1), buffer.existAt(caseData.toString()));
            }
            /*
            if the element does not exist
            parse buffer elements having non null flag and set it to null
            search case having null flag to replace it with new data to insert
             */
            else {
                pointer = (last + 1) % bufferSize;
                missingPagesCount++;
                while (buffer.elementAt(pointer).getFlag() != 0) {
                    String oldCaseFrame = buffer.elementAt(pointer).getFrame();
                    buffer.insertCase(new Case(oldCaseFrame, 0), pointer);
                    pointer = (pointer + 1) % bufferSize;
                }

                if (buffer.elementAt(pointer).getFlag() == 0) {
                    buffer.insertCase(new Case(caseData.toString(), 0), pointer);
                    last = pointer;
                }
            }
        }
        return missingPagesCount;
    }

}
