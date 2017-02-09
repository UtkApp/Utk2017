package com.nitj.utkansh.utkansh_app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.R.id.message;

/**
 * Created by rupeshwar on 30-01-2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FirebaseMessaging";

   /* Bitmap bitmap;*/

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());


        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        if (remoteMessage.getData().size() > 0) {
            Log.v(TAG, "Data Payload: " + remoteMessage.getData().toString());

            try {
                JSONObject json = new JSONObject(remoteMessage.getData().toString());
                handleDataMessage(json);
            } catch (Exception e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }
        }


    }

    private void handleDataMessage(JSONObject json) {
        Log.v(TAG, "push json: " + json.toString());


        try {
            JSONObject data = json.getJSONObject("data");

            String heading = data.getString("heading");
            String type = data.getString("type");
            String message = data.getString("message");
            String imageUri = data.getString("image");
            String timestamp = data.getString("timestamp");

            Log.v(TAG, "title: " + heading);
            Log.v(TAG, "message: " + message);
            Log.v(TAG, "type: " + type);
            Log.v(TAG, "imageUri: " + imageUri);
            Log.v(TAG, "timestamp: " + timestamp);

            Bitmap bitmap = getBitmapfromUrl(imageUri);
            sendNotification(heading, bitmap, type, imageUri, message);
        } catch (JSONException e) {
            Log.e(TAG, "Json Exception: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
    }


    /**
     * Create and show a simple notification containing the received FCM message.
     */

    private void sendNotification(String Heading, Bitmap image, String type, String BitmapUrl, String Description) {
        Intent intent = new Intent(this, SingleNotification.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        intent.putExtra("BitmapURL", BitmapUrl);
        intent.putExtra("Heading", Heading);
        intent.putExtra("Description", Description);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setLargeIcon(image)/*Notification icon image*/
                .setSmallIcon(R.drawable.utkansh_photo)
                .setContentTitle(Heading)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(image))/*Notification with Image*/
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

    /*
    *To get a Bitmap image from the URL received
    * */
    public Bitmap getBitmapfromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }
    }
}