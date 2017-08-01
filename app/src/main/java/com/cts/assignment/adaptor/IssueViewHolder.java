package com.cts.assignment.adaptor;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cts.rabobankassignment.R;

/**
 * Created by 486521 on 7/20/2017.
 */

public class IssueViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView dob;
    TextView count;

    public IssueViewHolder(View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        dob = itemView.findViewById(R.id.dob);
        count = itemView.findViewById(R.id.count);


    }
}
