package com.example.rohanagarwal94.hackdtu.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.rohanagarwal94.hackdtu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.himanshusoni.chatmessageview.ChatMessageView;

/**
 * Created by saurabh on 19/11/16.
 */

public class SearchResultHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.title)
    public TextView title;
    @BindView(R.id.description)
    public TextView description;
    @BindView(R.id.chatMessageView)
    public ChatMessageView chatMessageView;
    @BindView(R.id.link_preview_image)
    public ImageView previewImageView;
    @BindView(R.id.link_preview_title)
    public TextView titleTextView;
    @BindView(R.id.link_preview_description)
    public TextView descriptionTextView;
    @BindView(R.id.preview_layout)
    public LinearLayout previewLayout;

    public SearchResultHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
