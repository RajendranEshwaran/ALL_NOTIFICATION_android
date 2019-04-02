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

public class BigShareNotification extends AppCompatActivity {

    Button notifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_share_notification);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("IMAGE SHARE NOTIFIY");

        notifyBtn = (Button)findViewById(R.id.button3);

        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Assign big picture notification
                NotificationCompat.BigPictureStyle bpStyle = new NotificationCompat.BigPictureStyle();
                bpStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.notify)).build();

                // Set the intent to fire when the user taps on notification.
                Intent rIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ready4games.com"));
                PendingIntent pendingIntent = PendingIntent.getActivity(BigShareNotification.this, 0, rIntent, 0);
                NotificationCompat.Builder mBuilder =  new NotificationCompat.Builder(BigShareNotification.this)
                        .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                        .setContentTitle("Image Share Notifiy")
                        .addAction(R.drawable.ic_share_black_24dp, "Share", pendingIntent)
                        .setStyle(bpStyle);

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
