package com.example.newapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CustomService customService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.timer);
        customService = new CustomService(this, tv, 0);
        customService.execute();
        Button btn = findViewById(R.id.stopBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomService(MainActivity.this,tv, 0).cancel(false);
            }
        });

        Button n = findViewById(R.id.next_activity);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = customService.i;
                customService.cancel(true);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("val", i);
                startActivityForResult(intent, 100);
            }
        });
    }
}