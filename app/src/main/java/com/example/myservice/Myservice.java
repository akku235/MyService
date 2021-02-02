package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.Provider;

public class Myservice extends Service {
    Messenger messenger=new Messenger(new IncomingHandler());
    static final int job_1=1;
    static final int job_2=2;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(),"Service Binding!!!",Toast.LENGTH_LONG).show();
        return messenger.getBinder();
    }

    class IncomingHandler extends Handler{
        public void handleMessage(Message msg){
            switch (msg.what) {
                case job_1:
                    Toast.makeText(getApplicationContext(), "Hello From Job 1", Toast.LENGTH_LONG).show();
                    break;
                case job_2:
                    Toast.makeText(getApplicationContext(), "Hello From job 2", Toast.LENGTH_LONG).show();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
}

