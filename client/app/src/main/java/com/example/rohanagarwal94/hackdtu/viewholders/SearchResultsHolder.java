package com.example.rohanagarwal94.hackdtu.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import com.example.rohanagarwal94.hackdtu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by saurabh on 19/11/16.
 */

public class SearchResultsHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.message)
    public TextView message;
    @BindView(R.id.timestamp)
    public TextView timeStamp;
    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    public SearchResultsHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
