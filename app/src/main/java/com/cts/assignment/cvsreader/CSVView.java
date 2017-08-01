package com.cts.assignment.cvsreader;

import java.util.List;

/**
 * Created by rabo on 01/08/17.
 */

public interface CSVView {

    void showProgress();
    void hideProgress();
    void UpdateAdaptor(List<Issues> issues);
    void showParsingError();
    void navigateHome();
}
