package com.example.clcoktimer;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StopwatchActivity extends AppCompatActivity {

    private int milliseconds=0;
    private boolean running;
    TextView timer;
    FloatingActionButton play1,pause,flag,resume,stop;
    SeekBar seekBar;
    private long startTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        timer = (TextView) findViewById(R.id.textview1);
        play1 = (FloatingActionButton) findViewById(R.id.fplay1);
        pause = (FloatingActionButton) findViewById(R.id.fpause1);
        flag = (FloatingActionButton) findViewById(R.id.flag1);
        resume = (FloatingActionButton) findViewById(R.id.fplay2);
        stop = (FloatingActionButton) findViewById(R.id.fstop);
        seekBar = findViewById(R.id.seekBar);

        pause.setVisibility(View.INVISIBLE);
        flag.setVisibility(View.INVISIBLE);
        resume.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);

        seekBar.setMax(60000);
        seekBar.setProgress(0);

        startTimer();
        ImageView imgset = findViewById(R.id.imgset);

        imgset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view); // Call the method to show the menu
            }
        });

        ImageView imgclk = findViewById(R.id.imgclock);

        imgclk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clk = new Intent(StopwatchActivity.this, MainActivity.class);
                startActivity(clk);
            }
        });

        ImageView imgtmr = findViewById(R.id.imgtmr);

        imgtmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tmr = new Intent(StopwatchActivity.this, TimerActivity.class);
                startActivity(tmr);
            }
        });
    }
    public void onstart(View view)
    {
        running=true;
        play1.setVisibility(View.INVISIBLE);
        pause.setVisibility(View.VISIBLE);
        flag.setVisibility(View.VISIBLE);
        resume.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);


    }
    public void onpause(View view)
    {
        running=false;
        resume.setVisibility(View.VISIBLE);
        stop.setVisibility(View.VISIBLE);
        play1.setVisibility(View.INVISIBLE);
        pause.setVisibility(View.INVISIBLE);
        flag.setVisibility(View.INVISIBLE);
    }
    public void onstop(View view)
    {
        running=false;
        milliseconds=0;
        seekBar.setProgress(0);
        resume.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);
        play1.setVisibility(View.VISIBLE);
        pause.setVisibility(View.INVISIBLE);
        flag.setVisibility(View.INVISIBLE);

        updateTimerText();
    }

    public void onresume(View view)
    {
        running=true;
        play1.setVisibility(View.INVISIBLE);
        pause.setVisibility(View.VISIBLE);
        flag.setVisibility(View.VISIBLE);
        resume.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);

    }
    private void startTimer() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                updateTimerText();
                if (running) {
                    milliseconds++;
                    if (milliseconds % 100 == 0) {
                        // Update the SeekBar every second
                        seekBar.setProgress(milliseconds);
                    }
                }
                handler.postDelayed(this, 0); // Update every millisecond
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) {
                    return;
                }
                // Update time and seekbar position when seekbar changes
                milliseconds = progress;
                updateTimerText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed for your specific case
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not needed for your specific case
            }
        });
    }
    private void updateTimerText() {
        String time="";
        int hrs = milliseconds / 360000;
        int min = (milliseconds % 360000) / 6000;
        int sec = (milliseconds % 6000) / 100;
        int millis = milliseconds % 100;
        if(hrs<=0) {
            time = String.format("%02d:%02d.%02d", min, sec, millis);
        }
        else{
            time = String.format("%02d:%02d:%02d.%02d", hrs, min, sec, millis);
        }
        timer.setText(time);
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.settings_menu, popupMenu.getMenu()); // Replace with your actual menu resource

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_menu) {
                    Intent sett = new Intent(StopwatchActivity.this, SettingsActivity.class);
                    startActivity(sett);
                    return true;
                }
                return false;
            }});

        popupMenu.show();

    }
}
