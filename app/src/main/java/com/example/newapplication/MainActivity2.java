package com.example.newapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    CustomService customService;
    Intent mintent;
    int i;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mintent = getIntent();
        if(mintent.hasExtra("val")) {
            i = mintent.getIntExtra("val", 0);
        }
        if(mintent.hasExtra("value")) {
            i = mintent.getIntExtra("value", 0);
        }
        tv = findViewById(R.id.timer);
        customService = new CustomService(this, tv, i);
        customService.execute();
        Button n = findViewById(R.id.next_activity);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = customService.i;
                customService.cancel(true);
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("val", i);
                startActivityForResult(intent, 100);
            }
        });

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == 100 && resultCode == 123){
//            i = data != null ? data.getIntExtra("val", 0) : 0;
//            Toast.makeText(this, ""+i+"", Toast.LENGTH_SHORT).show();
//            customService = new CustomService(this, tv, i);
//
//            i = customService.i;
//            mintent.putExtra("value", i);
//            setResult(RESULT_OK, mintent);
//        }
//        else {
//            Toast.makeText(this, "bkjkhkj", Toast.LENGTH_SHORT).show();
//
//        }
//    }
}