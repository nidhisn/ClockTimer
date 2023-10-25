package com.example.clcoktimer;



import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

public class Timer2Activity extends AppCompatActivity {
    TextView countdowntxt;
    CountDownTimer countDownTimer;
    FloatingActionButton reset, pause;

    private int currentProgress;
    private ProgressBar progressBar;
    private boolean timerRunning;
    int totalSeconds;
    long timeLeftInMillis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer2);

        reset = (FloatingActionButton) findViewById(R.id.fab2);
        pause = (FloatingActionButton) findViewById(R.id.fab3);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        countdowntxt = findViewById(R.id.textView2);

        int hr = getIntent().getIntExtra("hr", 0);
        int min = getIntent().getIntExtra("min", 0);
        int sec = getIntent().getIntExtra("sec", 0);
        totalSeconds = (hr * 3600) + (min * 60) + sec;
        timeLeftInMillis = totalSeconds * 1000;
        progressBar.setMax(totalSeconds * 1000);
        startCountdown(totalSeconds);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Timer2Activity.this, TimerActivity.class);
                startActivity(intent);
            }
        });

        ImageView imgset = findViewById(R.id.imgset);

        imgset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view); // Call the method to show the menu
            }
        });

        ImageView imgstp = findViewById(R.id.imgstp);

        imgstp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stopw = new Intent(Timer2Activity.this,StopwatchActivity.class);
                startActivity(stopw);
            }
        });

        ImageView imgclk = findViewById(R.id.imgclock);

        imgclk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clk = new Intent(Timer2Activity.this,TimerActivity.class);
                startActivity(clk);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timerRunning) {
                    pauseTimer();
                } else {
                    resumeTimer();
                }
            }
        });
    }

    private void startCountdown(int seconds) {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                int remainingSeconds = (int) millisUntilFinished / 1000;
                int remainingHours = remainingSeconds / 3600;
                int remainingMinutes = (remainingSeconds % 3600) / 60;
                remainingSeconds = remainingSeconds % 60;

                String remainingTime = String.format(Locale.getDefault(), "%02d:%02d:%02d", remainingHours, remainingMinutes, remainingSeconds);
                countdowntxt.setText(remainingTime);
                //progressBar.setProgress((int) millisUntilFinished);
            }

            @Override
            public void onFinish() {
                countdowntxt.setText("00:00:00");
                // progressBar.setProgress(0);


            }
        }.start();
        timerRunning = true;
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        pause.setImageResource(R.drawable.play1);
        pause.setImageResource(R.drawable.play1);
    }

    private void resumeTimer() {
        startCountdown((int) (timeLeftInMillis / 1000));
        timerRunning = true;
        pause.setImageResource(R.drawable.reset);
    }
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.settings_menu, popupMenu.getMenu()); // Replace with your actual menu resource

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_menu) {
                    Intent sett = new Intent(Timer2Activity.this, SettingsActivity.class);
                    startActivity(sett);
                    return true;
                }
                return false;
            }});

        popupMenu.show();

    }

}

/*public class timer extends AppCompatActivity {
    TextView countdowntxt;
    CountDownTimer countDownTimer;
    FloatingActionButton reset,pause;
    private ProgressBar progressBar;
    private boolean timerrunning;
    int ttl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        reset=(FloatingActionButton) findViewById(R.id.fab2);
        pause=(FloatingActionButton) findViewById(R.id.fab3);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        countdowntxt=findViewById(R.id.textView2);
        int hr=getIntent().getIntExtra("hr",0);
        int min=getIntent().getIntExtra("min",0);
        int sec=getIntent().getIntExtra("sec",0);
        ttl=(hr*3600)+(min*60)+sec;
        progressBar.setMax(ttl*1000);
        startCountdown(ttl);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(timer.this,MainActivity.class);
                startActivity(intent);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timerrunning){
                    pauseTimer();
                }
            }
        });
    }
    private void startCountdown(int sec){
        //long ttl=(hr*3600+min*60+sec)*1000;
        countDownTimer=new CountDownTimer(sec*1000,1000) {
            @Override
            public void onTick(long l) {
                int remsec=(int) l/1000;
                int remhr=remsec/3600;
                int remmin=(remsec%3600)/60;
                remsec=remsec%60;

                String remtime=String.format(Locale.getDefault(),"%02d:%02d:%02d",remhr,remmin,remsec);
                countdowntxt.setText(remtime);
                progressBar.setProgress((int)l);
            }

            @Override
            public void onFinish() {
                countdowntxt.setText("00:00:00");
                progressBar.setProgress(0);
            }
        }.start();
        timerrunning=true;
    }
   /* private String convertsec(int ttl){
        int hr=ttl/3600;
        int min=(ttl%3600)/60;
        int sec=ttl%60;
        return String.format(Locale.getDefault(),"%02d:%02d:%02d",hr,min,sec);
    }
    private void pauseTimer(){
        countDownTimer.cancel();
        timerrunning=false;
        pause.setImageResource(R.drawable.play1);
    }
}*/