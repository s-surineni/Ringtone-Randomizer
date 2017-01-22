package com.adda.ours.ringtonerandomizer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class RebootReceiver extends BroadcastReceiver {

    private static final String APP_PREFS = "AppPrefs";
    private static final String ON_STATE_TEXT = "Stop";
    private static final String OFF_STATE_TEXT = "Randomize Tones";

    @Override
    public void onReceive(Context context, Intent intent) {
        String buttonText = context.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE).getString("buttonText", OFF_STATE_TEXT);
        if(buttonText.equals(ON_STATE_TEXT)) {
            Intent startServiceIntent = new Intent(context, CallDetectService.class);
            context.startService(startServiceIntent);
        }
    }
}
