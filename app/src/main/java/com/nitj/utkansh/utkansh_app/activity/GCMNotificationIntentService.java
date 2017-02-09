/*
package com.nitj.utkansh.utkansh_app.activity;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.nitj.utkansh.utkansh_app.R;
import com.nitj.utkansh.utkansh_app.helper.SQLiteHelper;
import com.nitj.utkansh.utkansh_app.helper.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

public class GCMNotificationIntentService extends IntentService {
    // Sets an ID for the notification, so it can be updated
    public static final int notifyID = 9001;
    private SessionManager session;


    public GCMNotificationIntentService() {
        super("GcmIntentService");
    }

    public static final String TAG = "GCMNotificationIntentService";

    private SQLiteHelper db;
    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

        String messageType = gcm.getMessageType(intent);

       */
/* if (!extras.isEmpty()) {
            if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR
                    .equals(messageType)) {
                sendNotification("Send error: " + extras.toString());
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED
                    .equals(messageType)) {
                sendNotification("Deleted messages on server: "
                        + extras.toString());
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE
                    .equals(messageType)) {

                String jsonMsg=extras.get(ApplicationConstants.MSG_KEY).toString();
                String notification="";
                try {
                    JSONObject json=new JSONObject(jsonMsg);
                    notification= json.getString("greetMsg");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                session = new SessionManager(getApplicationContext());

                if(session.isLoggedIn())
                {
                    db = new SQLiteHelper(getApplicationContext());
                    db.addNotification(notification);
                    sendNotification(notification);
                }

            }
        }*//*

        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }
    private void sendNotification(String notification) {
        Intent resultIntent = new Intent(this,com.nitj.utkansh.utkansh_app.Notifications.class);
        resultIntent.putExtra("notification", notification);
        resultIntent.setAction(Intent.ACTION_MAIN);
        resultIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0,
                resultIntent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder mNotifyBuilder;
        NotificationManager mNotificationManager;

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotifyBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Utkansh'16")
                .setContentText(notification)
                .setSmallIcon(R.mipmap.ic_launcher);
        // Set pending intent
        mNotifyBuilder.setContentIntent(resultPendingIntent);

        // Set Vibrate, Sound and Light
        int defaults = 0;
        defaults = defaults | Notification.DEFAULT_LIGHTS;
        defaults = defaults | Notification.DEFAULT_VIBRATE;
        defaults = defaults | Notification.DEFAULT_SOUND;

        mNotifyBuilder.setDefaults(defaults);
        // Set autocancel
        mNotifyBuilder.setAutoCancel(true);
        // Post a notification
        mNotificationManager.notify(notifyID, mNotifyBuilder.build());
    }
}*/
