package com.ciccc_cirac.serviceex;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by CICCC-CIRAC on 2017-08-09.
 */

public class Sleeper extends IntentService {

    public Sleeper()
    {
        super("Sleeper");
    }
    long seconds;

    @Override
    protected void onHandleIntent(Intent intent) {
        seconds =intent.getExtras().getLong("seconds");
        long millis = seconds * 1000;
        try
        {
            Thread.sleep(millis);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Thread is Destroyed",Toast.LENGTH_LONG).show();
    }
}
