package com.cts.assignment.adaptor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cts.assignment.cvsreader.Issues;
import com.cts.assignment.util.DateUtil;
import com.cts.rabobankassignment.R;

import java.util.List;

/**
 * Created by 486521 on 7/20/2017.
 */

public class IssueAdaptor extends RecyclerView.Adapter<IssueViewHolder> {
    private List<Issues> issues;

    public IssueAdaptor(List<Issues> issues) {
        this.issues = issues;
    }

    @Override
    public IssueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Load custom view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.issue_list, parent, false);
        return new IssueViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IssueViewHolder holder, int position) {
        Issues issue = issues.get(position);
        // Bind data to UI
        holder.name.setText(issue.getSurName() + " " + issue.getFirstName());
        holder.dob.setText(DateUtil.getDate(issue.getDOB()));
        holder.count.setText(String.valueOf(issue.getIssueCount()));
    }

    @Override
    public int getItemCount() {
        return issues.size();
    }
}
