package com.nitj.utkansh.utkansh_app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by rupeshwar on 06-02-2017.
 */

public class SingleNotification extends AppCompatActivity {
    private ImageView mImageView;
    private TextView mHeading;
    private TextView mDescription;

    private String mBitmapURL;
    private String mHeadingText;
    private String mDescriptionText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_single_notification);

        Bundle extras = getIntent().getExtras();
        mBitmapURL = extras.getString("BitmapURL");
        mHeadingText = extras.getString("Heading");
        mDescriptionText = extras.getString("Description");

        mImageView = (ImageView) findViewById(R.id.noti_image);
        mHeading = (TextView) findViewById(R.id.noti_heading);
        mDescription = (TextView) findViewById(R.id.noti_desc);

        mImageView.setImageResource(R.drawable.utkansh_photo);
        mHeading.setText(mHeadingText);
        mDescription.setText(mDescriptionText);

        new DownloadImage().execute(mBitmapURL);

    }

    private void setImage(Drawable drawable)
    {
        mImageView.setImageDrawable(drawable);
    }

    public class DownloadImage extends AsyncTask<String, Integer, Drawable> {

        /*@Override
        protected void onPreExecute() {
            super.onPreExecute();
            mImageView.setImageResource(R.drawable.utkansh_photo);
        }
*/
        @Override
        protected Drawable doInBackground(String... arg0) {
            // This is done in a background thread
            return downloadImage(arg0[0]);
        }

        /**
         * Called after the image has been downloaded
         * -> this calls a function on the main thread again
         */
        protected void onPostExecute(Drawable image)
        {
            setImage(image);
        }


        /**
         * Actually download the Image from the _url
         * @param _url
         * @return
         */
        private Drawable downloadImage(String _url)
        {
            //Prepare to download image
            URL url;
            BufferedOutputStream out;
            InputStream in;
            BufferedInputStream buf;

            //BufferedInputStream buf;
            try {
                url = new URL(_url);
                in = url.openStream();

                // Read the inputstream
                buf = new BufferedInputStream(in);

                // Convert the BufferedInputStream to a Bitmap
                Bitmap bMap = BitmapFactory.decodeStream(buf);
                if (in != null) {
                    in.close();
                }
                if (buf != null) {
                    buf.close();
                }

                return new BitmapDrawable(getApplicationContext().getResources(), bMap);



            } catch (Exception e) {
                Log.e("Error reading file", e.toString());
            }

            return null;
        }

    }


}
