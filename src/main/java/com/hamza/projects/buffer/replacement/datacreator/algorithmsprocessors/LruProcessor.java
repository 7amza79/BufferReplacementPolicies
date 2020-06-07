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
        int missingPagesCount = 0;
        // set first elements
        Buffer buffer = new Buffer(bufferSize);

        for (Integer caseData : inputData) {
            // if the element exists
            // search the index and put the item in the front case and push back all the other items

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
                Case caseToBeInserted = new Case(caseData.toString(), 0);
                buffer.insertCase(caseToBeInserted, bufferSize - 1);

                missingPagesCount++;
            }

        }
        return missingPagesCount;
    }

}
