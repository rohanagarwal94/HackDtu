package com.example.rohanagarwal94.hackdtu.viewholders;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.rohanagarwal94.hackdtu.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.himanshusoni.chatmessageview.ChatMessageView;

import static com.example.rohanagarwal94.hackdtu.ChatFeedRecyclerAdapter.SUSI_IMAGE;
import static com.example.rohanagarwal94.hackdtu.ChatFeedRecyclerAdapter.SUSI_MESSAGE;
import static com.example.rohanagarwal94.hackdtu.ChatFeedRecyclerAdapter.USER_IMAGE;
import static com.example.rohanagarwal94.hackdtu.ChatFeedRecyclerAdapter.USER_MESSAGE;

/**
 * Created by
 * --Vatsal Bajpai on
 * --25/09/16 at
 * --9:51 PM
 */

public class ChatViewHolder extends MessageViewHolder{

    @BindView(R.id.text)
    public TextView chatTextView;
    @BindView(R.id.timestamp)
    public TextView timeStamp;
    @BindView(R.id.chatMessageView)
    public ChatMessageView chatMessageView;
    @Nullable @BindView(R.id.received_tick)
    public ImageView receivedTick;

    public ChatViewHolder(View view, ClickListener clickListener ,int myMessage) {
        super(view,clickListener);
        ButterKnife.bind(this, view);
        switch (myMessage) {
            case USER_MESSAGE:
                break;
            case SUSI_MESSAGE:
                break;
            case USER_IMAGE:
            case SUSI_IMAGE:
            default:
        }
    }
}