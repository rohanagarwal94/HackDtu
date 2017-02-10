package com.example.rohanagarwal94.hackdtu.viewholders;

import android.view.View;
import android.widget.TextView;

import com.example.rohanagarwal94.hackdtu.R;
import com.github.mikephil.charting.charts.PieChart;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.himanshusoni.chatmessageview.ChatMessageView;

public class PieChartViewHolder extends MessageViewHolder {

    @BindView(R.id.chatMessageView)
    public ChatMessageView chatMessageView;
    @BindView(R.id.text)
    public TextView chatTextView;
    @BindView(R.id.piechart)
    public PieChart pieChart;
    @BindView(R.id.timestamp)
    public TextView timeStamp;

    public PieChartViewHolder(View view , ClickListener listener){
        super(view , listener);
        ButterKnife.bind(this, itemView);
    }
}
