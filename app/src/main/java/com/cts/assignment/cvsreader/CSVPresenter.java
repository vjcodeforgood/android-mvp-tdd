package com.cts.assignment.cvsreader;

/**
 * Created by rabo on 01/08/17.
 */

public interface CSVPresenter {

    boolean parseCSV(String fileName);
    void onDestroy();


}
