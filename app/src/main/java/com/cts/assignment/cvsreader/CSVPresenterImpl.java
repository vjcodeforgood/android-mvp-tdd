package com.cts.assignment.cvsreader;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rabo on 01/08/17.
 */

public class CSVPresenterImpl implements CSVPresenter , CSVInteractor.OnCSVParsingFinishListener{
    private CSVView csvView;
    private CSVInteractor csvInteractor;
    private List<Issues> issues;
    private Context context;
    private boolean success;

    public CSVPresenterImpl(CSVView csvView, Context context) {
        this.csvView = csvView;
        this.csvInteractor = new CSVInteractorImpl();
        this.context = context;
        issues = new ArrayList<>();

    }

    @Override
    public boolean parseCSV(String fileName) {

        if (csvView != null) {
            csvView.showProgress();


            new AsyncTask<Void, Void, List<Issues>>() {
                @Override
                protected List<Issues> doInBackground(Void... voids) {

                    String ISSUES_CSV = "issues.csv";
                    String REGEX = "^\"|\"$";
                    String SOMETHING_WENT_WRONG = "Something Went wrong !";
                    BufferedReader reader = null;

                    try {

                        AssetManager assetManager = context.getAssets();
                        InputStream csvStream = assetManager.open(ISSUES_CSV);
                        reader = new BufferedReader(new InputStreamReader(csvStream));
                        String line;

                        // to skip header
                        reader.readLine();

                        while ((line = reader.readLine()) != null) {

                            String[] issueRow = line.split(",");
                            Issues issue = new Issues();
                            issue.setFirstName(issueRow[0].replaceAll(REGEX, ""));
                            issue.setSurName(issueRow[1].replaceAll(REGEX, ""));
                            issue.setIssueCount(Integer.parseInt(issueRow[2]));
                            issue.setDOB(issueRow[3].replaceAll(REGEX, ""));
                            issues.add(issue);

                            Log.d("Data",issue.getFirstName());

                        }

                        success = true;

                    } catch (IOException ex) {
                        //catch exception here
                        Log.d("Log", ex.getMessage());
                        Toast.makeText(context, SOMETHING_WENT_WRONG, Toast.LENGTH_LONG).show();
                        success = false;
                    } finally {
                        if (reader != null) {
                            try {
                                reader.close();
                            } catch (IOException e) {
                                // handle exception
                                Toast.makeText(context, SOMETHING_WENT_WRONG, Toast.LENGTH_LONG).show();
                            }
                        }

                    }





                    return issues;
                }

                @Override
                protected void onPostExecute(List<Issues> issues) {
                }

            }.execute();



        }

        csvView.UpdateAdaptor(issues);

        return true;


    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onSuccess(List<Issues> issues) {

    }


}
