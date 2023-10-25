package com.example.clcoktimer;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    public static final int  LAUNCH_SEARCH_ACTIVITY = 1;
    RecyclerView rvCountry;

    TextView tvTime;

    TextView tvTimeFormat;

    FloatingActionButton btAdd;

    CountryClockAdapter countryClockAdapter;

    ArrayList<Country> countryArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }


    private void initUI(){
        rvCountry = findViewById(R.id.rvCountryClock);
        tvTime = findViewById(R.id.tvTime);
        tvTimeFormat = findViewById(R.id.tvFormat);
        btAdd = findViewById(R.id.btAddCountry);

        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        String formattedDate = dateFormat.format(new Date()).toString();
        tvTime.setText(formattedDate);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvCountry.setLayoutManager(linearLayoutManager);

        countryClockAdapter = new CountryClockAdapter(this);
        rvCountry.setAdapter(countryClockAdapter);
        countryClockAdapter.setCountryArrayList(countryArrayList);


        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SearchCountryActivity.class);
                startActivityForResult(i, LAUNCH_SEARCH_ACTIVITY);
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
                Intent stopw = new Intent(MainActivity.this,StopwatchActivity.class);
                startActivity(stopw);
            }
        });

        ImageView imgtmr = findViewById(R.id.imgtmr);

        imgtmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tmr = new Intent(MainActivity.this,TimerActivity.class);
                startActivity(tmr);
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_CANCELED) {
            return;
        }
        if (requestCode == LAUNCH_SEARCH_ACTIVITY) {
            Country result=(Country) data.getParcelableExtra("result");
            addCountryToList(result);
            Log.d("MainActivity", "onActivityResult: "+result.name);
        }
    }


    private void addCountryToList(Country country){

        for (Country addedCountry : countryArrayList) {
            if(country.name.contains(addedCountry.name)){
                return;
            }

        }
        countryArrayList.add(country);
        countryClockAdapter.notifyDataSetChanged();

    }



    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.settings_menu, popupMenu.getMenu()); // Replace with your actual menu resource

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_menu) {
                    Intent sett = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(sett);
                    return true;
                }
                return false;
            }});

        popupMenu.show();

    }
}