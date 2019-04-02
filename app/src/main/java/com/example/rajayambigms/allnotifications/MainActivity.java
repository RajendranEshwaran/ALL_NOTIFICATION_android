package com.example.rajayambigms.allnotifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void simpleNotifity(View view)
    {
        Intent intent = new Intent(MainActivity.this,SimpleNotification.class);
        startActivity(intent);
    }

    public void bigNotifity(View view)
    {
        Intent intent = new Intent(MainActivity.this,BigTextNotification.class);
        startActivity(intent);
    }

}
