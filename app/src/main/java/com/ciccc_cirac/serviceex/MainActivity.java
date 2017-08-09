package com.ciccc_cirac.serviceex;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    Button buttonStart, buttonStop, buttonNext, buttonIntent;
    Button buttonHandler;
    EditText sleepTime;
    Long secondstoSleep;
    private Handler handler;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        setContentView(R.layout.activity_main);
        handler = new Handler();

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStop = (Button) findViewById(R.id.buttonStop);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonIntent = (Button) findViewById(R.id.buttonIntent);
        sleepTime = (EditText) findViewById(R.id.editSeconds);
        buttonHandler = (Button) findViewById(R.id.buttonHandler);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
        buttonIntent.setOnClickListener(this);
        buttonHandler.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonStart:
                Intent i = new Intent(this, Myservice.class);
                startService(i);
                break;
            case R.id.buttonStop:
                i = new Intent(this, Myservice.class);
                stopService(i);
                break;
            case R.id.buttonNext:
                secondstoSleep = Long.parseLong(sleepTime.getText().toString());
                i = new Intent(this, Myservice.class);
                i.putExtra("seconds", secondstoSleep);
                startService(i);
                break;
            case R.id.buttonIntent:
                secondstoSleep = Long.parseLong(sleepTime.getText().toString());
                i = new Intent(this, Sleeper.class);
                i.putExtra("seconds", secondstoSleep);
                startService(i);
                break;
//            case R.id.buttonHandler:
//                Toast.makeText(getBaseContext(), "Handler Start",
//                        Toast.LENGTH_LONG).show();
//                startProgress();
//                break;
        }
    }
//    public void startProgress()
//    {
//            new Thread(new Task()).start();
//    }
//
//
//     class Task implements Runnable{
//         @Override
//         public void run() {
//             for (int i = 0; i <= 20; i++) {
//                 final int value = i;
//                 try {
//                     Thread.sleep(1000);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//                 handler.post(new Runnable() {
//                     @Override
//                     public void run() {
//                         progressBar.setProgress(value);
//                     }
//                 });
//             }
//         }
//     }


}