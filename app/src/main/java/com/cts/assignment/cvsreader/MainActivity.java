package com.cts.assignment.cvsreader;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.cts.assignment.adaptor.IssueAdaptor;
import com.cts.assignment.adaptor.SimpleDividerItemDecoration;
import com.cts.rabobankassignment.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements CSVView{

    private IssueAdaptor issueAdaptor;
    private ProgressBar progressBar;

    private CSVPresenter csvInteractor;
    private List<Issues> issues_data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView issueRecyclerView = findViewById(R.id.issue_recycle);
        progressBar = findViewById(R.id.progressBar);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        issueRecyclerView.setLayoutManager(mLayoutManager);
        issueRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(
                getApplicationContext()
        ));

        issueAdaptor = new IssueAdaptor(issues_data);
        issueRecyclerView.setAdapter(issueAdaptor);

        csvInteractor = new CSVPresenterImpl(this,this);
        csvInteractor.parseCSV("issues.csv");

    }



    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void UpdateAdaptor(List<Issues> issues) {
        issues_data.clear();
        issues_data.addAll(issues);
        this.issueAdaptor.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }



    @Override
    public void showParsingError() {

    }

    @Override
    public void navigateHome() {

    }


}
