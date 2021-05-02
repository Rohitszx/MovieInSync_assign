package com.example.newapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class CustomService extends AsyncTask<Void, Void, Void> {

    private WeakReference<TextView> tv;
    private final Context context;
    int i;

    CustomService(Context context, TextView tv, int i){
        this.context = context;
        this.tv = new WeakReference<>(tv);
        this.i = i;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        HandlerThread ht = new HandlerThread("abc");
        ht.start();
        Handler handler = new Handler(ht.getLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 5000);
                i++;
                tv.get().setText(" "+i);
            }
        };
        handler.post(runnable);
        return null;
    }
}
