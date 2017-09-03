package com.example.rohan.carevault;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Rohan on 6/8/2016.
 */
public class MyReceiver extends BroadcastReceiver {
    static int countPowerOff=0;
    private Activity activity=null;
//    public MyReceiver (Activity activity)
//    {
//        this.activity=activity;
//    }
//
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.v("onReceive", "Power button is pressed.");

        Toast.makeText(context, "power button clicked", Toast.LENGTH_LONG)
                .show();

        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            countPowerOff++;
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            if (countPowerOff == 5) {
                Intent i = new Intent(activity, PeopleSecond.class);
                activity.startActivity(i);
            }
        }

    }
}