package com.example.anniv_2022_am.modele.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.anniv_2022_am.R;

public class GNotif {

    NotificationManager notificationManager;
    Context context;

    public GNotif(Context context) {
        this.context = context;
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //CharSequence name = getString(R.string.channel_name);
            //String description = getString(R.string.channel_description);
            NotificationChannel channel = new NotificationChannel("0", "Name", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Une description");
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        } else {
            notificationManager = (NotificationManager)context.getSystemService(context.getApplicationContext().NOTIFICATION_SERVICE);
        }
    }

    public void notifVocal() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "0")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Notif Vocal")
                .setContentText("Hello World!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setAutoCancel(true);

        notificationManager.notify(0, builder.build());
    }

    public void notifDocument() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "0")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Notif Document")
                .setContentText("Hello World!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setAutoCancel(true);

        notificationManager.notify(0, builder.build());
    }
}
