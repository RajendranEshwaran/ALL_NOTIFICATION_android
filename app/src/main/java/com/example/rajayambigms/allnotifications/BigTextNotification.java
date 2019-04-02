package com.example.rajayambigms.allnotifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BigTextNotification extends AppCompatActivity {

    Button notifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_text_notification);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("BIG TEXT NOTIFIY");

        notifyBtn = (Button)findViewById(R.id.showSimpleNotify);

        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                bigTextStyle.bigText("We are providing the online free games to play for online gamers. We have " +
                        "various kinds of online games ");

                NotificationCompat.Builder mBuilder =  new NotificationCompat.Builder(BigTextNotification.this)
                        .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                        .setContentTitle("READY4GAMES")
                        .setStyle(bigTextStyle);

                // Set the intent to fire when the user taps on notification.
                Intent resultIntent = new Intent(BigTextNotification.this, BigTextNotification.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(BigTextNotification.this, 0, resultIntent, 0);
                mBuilder.setContentIntent(pendingIntent);

                // Sets an ID for the notification
                int mNotificationId = 001;
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // It will display the notification in notification bar
                notificationManager.notify(mNotificationId, mBuilder.build());
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
