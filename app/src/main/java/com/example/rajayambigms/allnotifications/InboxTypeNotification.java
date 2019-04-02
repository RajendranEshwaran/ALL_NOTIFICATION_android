package com.example.rajayambigms.allnotifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class InboxTypeNotification extends AppCompatActivity {

    Button notifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox_type_notification);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("INBOX STYLE NOTIFIY");

        notifyBtn = (Button)findViewById(R.id.button2);

        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Implement inbox style notification
                NotificationCompat.InboxStyle iStyle =  new NotificationCompat.InboxStyle();
                iStyle.addLine("Message 1.");
                iStyle.addLine("Message 2.");
                iStyle.addLine("Message 3.");
                iStyle.addLine("Message 4.");
                iStyle.addLine("Message 5.");
                iStyle.setSummaryText("+2 more");

                // Set the intent to fire when the user taps on notification.
                Intent rIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ready4games.com"));
                PendingIntent pendingIntent = PendingIntent.getActivity(InboxTypeNotification.this, 0, rIntent, 0);
                NotificationCompat.Builder mBuilder =  new NotificationCompat.Builder(InboxTypeNotification.this)
                        .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                        .setContentTitle("Inbox Style Notify Example")
                        .setStyle(iStyle);

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


