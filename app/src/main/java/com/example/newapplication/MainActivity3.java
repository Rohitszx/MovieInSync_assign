package com.example.newapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    CustomService customService;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView tv = findViewById(R.id.timer);
        intent = getIntent();
        int i = intent.getIntExtra("val", 0);
        customService = new CustomService(this, tv, i);
        customService.execute();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, MainActivity2.class);
            int l = customService.i;
            intent.putExtra("value", l);
            startActivity(intent);
            finish();
        return super.onOptionsItemSelected(item);
    }
}