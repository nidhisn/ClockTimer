package com.example.clcoktimer;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button changeButton = findViewById(R.id.transparentButton);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start Activity2

                final View layout = findViewById(R.id.setlayout);
                layout.setBackgroundColor(Color.parseColor("#FFFF"));

                TextView textView1 = findViewById(R.id.textView1);
                textView1.setTextColor(Color.parseColor("#FF000000"));

                TextView textView2 = findViewById(R.id.textView2);
                textView2.setTextColor(Color.parseColor("#FF000000"));

                /*Intent intent = new Intent(SettingsActivity.this, MainActivity.class);

                intent.putExtra("backgroundColor", "#FFFF");
                intent.putExtra("textColor", "#FF000000");*/
                // startActivity(intent);
            }
        });
    }
}
