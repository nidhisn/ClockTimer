package com.example.clcoktimer;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.PopupMenu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {
    NumberPicker npk1hr,npk2mn,npk3sc;
    FloatingActionButton fltbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        npk1hr=(NumberPicker) findViewById(R.id.numpick);
        npk2mn=(NumberPicker) findViewById(R.id.numpick2);
        npk3sc=(NumberPicker) findViewById(R.id.numpick3);
        fltbtn=(FloatingActionButton) findViewById(R.id.fab1);
        npk1hr.setMinValue(0);
        npk1hr.setMaxValue(24);
        npk2mn.setMinValue(0);
        npk2mn.setMaxValue(59);
        npk3sc.setMinValue(0);
        npk3sc.setMaxValue(59);

        fltbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hr=npk1hr.getValue();
                int min=npk2mn.getValue();
                int sec=npk3sc.getValue();
                //String timestring=String.format(Locale.getDefault(),"%02d:%02d:%02d",hr,min,sec);

                Intent intent=new Intent(TimerActivity.this,Timer2Activity.class);
                intent.putExtra("hr",hr);
                intent.putExtra("min",min);
                intent.putExtra("sec",sec);
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
                Intent stopw = new Intent(TimerActivity.this,StopwatchActivity.class);
                startActivity(stopw);
            }
        });

        ImageView imgclk = findViewById(R.id.imgclock);

        imgclk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clk = new Intent(TimerActivity.this,MainActivity.class);
                startActivity(clk);
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.settings_menu, popupMenu.getMenu()); // Replace with your actual menu resource

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_menu) {
                    Intent sett = new Intent(TimerActivity.this, SettingsActivity.class);
                    startActivity(sett);
                    return true;
                }
                return false;
            }});

        popupMenu.show();

    }
}