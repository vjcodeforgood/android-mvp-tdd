package com.cts.assignment.cvsreader;

import java.util.List;

/**
 * Created by rabo on 01/08/17.
 */

public interface CSVInteractor {

    interface OnCSVParsingFinishListener {

        void onFailure();
        void onSuccess(List<Issues> issues);

    }

    void updateUI(List<Issues> issues, OnCSVParsingFinishListener onCSVParsingFinishListener);

}
