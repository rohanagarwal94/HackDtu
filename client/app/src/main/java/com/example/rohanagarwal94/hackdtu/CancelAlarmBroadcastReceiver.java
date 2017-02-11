package com.example.rohanagarwal94.hackdtu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by rohanpc on 5/30/2016.
 */
public class
CancelAlarmBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        String name=bundle.getString("name");
        Log.v("CancelAlarm",name);
        SharedPreferences.Editor editor=context.getSharedPreferences("bills",MODE_PRIVATE).edit();
        editor.putString(bundle.getString("name"), "yes");

        editor.commit();
        SharedPreferences preferences=context.getSharedPreferences("bills",Context.MODE_PRIVATE);
        String cancel=preferences.getString(bundle.getString("name"),null);
        Log.v("CancelAlarm","cancellation in progress "+bundle.getString("name")+ cancel);
    }
}