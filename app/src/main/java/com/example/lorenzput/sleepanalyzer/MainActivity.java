package com.example.lorenzput.sleepanalyzer;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;


public class MainActivity extends ActionBarActivity {

    private Context context;
    Button vib1;
    Button Stop;
    Vibrator mVibrator;
    Switch aSwitch;

    int vibrate = 1000; // Length of a Morse Code "vibrate" in milliseconds
    int gap = 1000; // Length of Gap Between Letters

    long[] pattern = { 0, vibrate, gap };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vib1 = (Button) findViewById(R.id.BtnTrillen);
        mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Stop = (Button) findViewById(R.id.BtnStop);
        aSwitch = (Switch) findViewById(R.id.SwOnOff);
        vib1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ( mVibrator.hasVibrator() == true && aSwitch.isChecked() == true) {
                    mVibrator.vibrate(pattern, 0);
                }
                else {
                    mVibrator.cancel();
                    Log.v("Your device doesn't have a vibrator", "OK");
                }
            }
        });
        Stop.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                mVibrator.cancel();
            }
        });
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


}
