package com.nitj.utkansh.utkansh_app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import com.nitj.utkansh.utkansh_app.helper.SQLiteHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

public class Camera extends Fragment {

    private static final int REQUEST_PHOTO = 0;
    private static final String LOG_TAG1 = "Dimensions";
    private final String mFB_URL = "https://www.facebook.com/utkansh/";
    //ImageView test_view;
    private FloatingActionButton mPhotoButton;
    private ImageView mPhotoView;
    private File mPhotoFile;
    private FloatingActionButton mFB_LinkButton;
    private ProgressDialog mProgressDialog;

    private SQLiteHelper db;
    private String utk;

    /**
     * Create a File for saving an image
     */
    private static File getOutputMediaFile() {

        File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "Utkansh");

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("Utkansh", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;

        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                "IMG_" + timeStamp + ".jpg");

        return mediaFile;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new SQLiteHelper(getActivity().getApplicationContext());
        HashMap<String, String> values = db.getUserDetails();
        utk = values.get("utk");
        Log.d(LOG_TAG1, "utk" + utk);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View v = inflater.inflate(R.layout.fragment_camera, container, false);

        mFB_LinkButton = (FloatingActionButton) v.findViewById(R.id.open_fb_page);

        mFB_LinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(mFB_URL));
                startActivity(i);

            }
        });

        mPhotoButton = (FloatingActionButton) v.findViewById(R.id.camera_button);
        //   mPhotoView = (ImageView) v.findViewById(R.id.photo_view);


        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isStoragePermissionGranted()) {
                    takeImage();
                }
            }
        });

        return v;


    }

/*public String getPhotoFilename() {
        return "IMG_" + UUID.randomUUID().toString() + ".jpg";
    }*/

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_home, menu);


    }

    public void takeImage() {
        mPhotoFile = getOutputMediaFile();

        PackageManager packageManager = getActivity().getPackageManager();

        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        boolean canTakePhoto = mPhotoFile != null &&
                captureImage.resolveActivity(packageManager) != null;
        mPhotoButton.setEnabled(canTakePhoto);
        if (canTakePhoto) {
            Uri uri = Uri.fromFile(mPhotoFile);
            captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        }

        startActivityForResult(captureImage, REQUEST_PHOTO);


    }

    public void addWatermark() {
        Resources res = getResources();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;

        Bitmap source = BitmapFactory.decodeFile(mPhotoFile.getPath(), options);

        int w, h;
        Canvas c;
        Paint paint;
        Bitmap bmp;
        Matrix matrix;
        float scale;
        RectF r;

        w = source.getWidth();
        h = source.getHeight();

        long resolution = h * w;
        Log.d(LOG_TAG1, "addWatermark Started");
        Log.d(LOG_TAG1, "image resolution = " + resolution);

// Create the new bitmap
        bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.FILTER_BITMAP_FLAG);

// Copy the original bitmap into the new one
        c = new Canvas(bmp);
        c.drawBitmap(source, 0, 0, paint);

        source.recycle();


        int k;

        if (h > w)
            k = h;
        else
            k = w;


// Load the watermark
        source = BitmapFactory.decodeResource(res, R.drawable.logo);
// Scale the watermark to be approximately 10% of the source image height
        scale = (float) (((float) k * 0.13) / (float) source.getHeight());
// Create the matrix

        matrix = new Matrix();
        matrix.postScale(scale, scale);

// Determine the post-scaled size of the watermark
        r = new RectF(0, 0, source.getWidth(), source.getHeight());
        matrix.mapRect(r);

// Move the watermark to the bottom right corner
        matrix.postTranslate(0, 0);
// Draw the watermark

        c.drawBitmap(source, matrix, paint);

        source.recycle();
        source = null;


        OutputStream outStream = null;

        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);
        paint1.setStrokeWidth(2); // Text Size
        paint1.setColor(Color.GRAY); // Text Color
        paint1.setTextSize(60);


        c.drawText(utk, 10, h - 100, paint1);


        Paint paint2 = new Paint();
        paint2.setColor(Color.BLACK); // Text Color
        paint2.setStrokeWidth(0); // Text Size
        paint2.setTextSize(60);
        c.drawText(utk, 10, h - 100, paint2);

        //File file = new File(filename + ".png");
        if (mPhotoFile.exists()) {
            mPhotoFile.delete();
        }
        try {
            // make a new bitmap from your file

            outStream = new FileOutputStream(mPhotoFile);
            bmp.compress(Bitmap.CompressFormat.JPEG, 95, outStream);
            outStream.flush();
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Log.e("file", "" + file);

// Free up the bitmap memory
        c = null;
        bmp.recycle();
        // source.recycle();


        bmp = null;
        //  source=null;


    /*    Toast.makeText(getActivity(), "Image saved in Utkansh folder", Toast.LENGTH_LONG)
                .show();*/

        Log.d(LOG_TAG1, "addWatermark Ends");
    }

    public void addWatermarkReduced() {
        Resources res = getResources();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;

        Bitmap source = BitmapFactory.decodeFile(mPhotoFile.getPath(), options);

        int w, h;
        Canvas c;
        Paint paint;
        Bitmap bmp;
        Matrix matrix;
        float scale;
        RectF r;

        w = source.getWidth();
        h = source.getHeight();

        long resolution = h * w;

        Log.d(LOG_TAG1, "addWatermarkReduced");
        Log.d(LOG_TAG1, "image resolution = " + resolution);

// Create the new bitmap
        bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.FILTER_BITMAP_FLAG);

// Copy the original bitmap into the new one
        c = new Canvas(bmp);
        c.drawBitmap(source, 0, 0, paint);

        source.recycle();

        int k;

        if (h > w)
            k = h;
        else
            k = w;

// Load the watermark
        source = BitmapFactory.decodeResource(res, R.drawable.logo);
// Scale the watermark to be approximately 15% of the source image height
        scale = (float) (((float) k * 0.13) / (float) source.getHeight());
// Create the matrix

        matrix = new Matrix();
        matrix.postScale(scale, scale);

// Determine the post-scaled size of the watermark
        r = new RectF(0, 0, source.getWidth(), source.getHeight());
        matrix.mapRect(r);

// Move the watermark to the bottom right corner
        matrix.postTranslate(0, 0);
// Draw the watermark

        c.drawBitmap(source, matrix, paint);

        source.recycle();
        source = null;


        // String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        OutputStream outStream = null;

        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);
        paint1.setStrokeWidth(2); // Text Size
        paint1.setColor(Color.GRAY); // Text Color
        paint1.setTextSize(60);

        c.drawText(utk, 10, h - 100, paint1);


        Paint paint2 = new Paint();
        paint2.setColor(Color.BLACK); // Text Color
        paint2.setStrokeWidth(0); // Text Size
        paint2.setTextSize(60);
        //      paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)); // Text Overlapping Pattern
        c.drawText(utk, 10, h - 100, paint2);


        //File file = new File(filename + ".png");
        if (mPhotoFile.exists()) {
            mPhotoFile.delete();
            /*file = new File(extStorageDirectory, filename + ".png");
            Log.e("file exist", "" + file + ",Bitmap= " + filename);*/
        }
        try {
            // make a new bitmap from your file

            outStream = new FileOutputStream(mPhotoFile);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            outStream.flush();
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Log.e("file", "" + file);

// Free up the bitmap memory

        bmp.recycle();
        // source.recycle();

        c = null;
        bmp = null;
        //  source=null;

        /*Toast.makeText(getActivity(), "Image saved in Utkansh folder", Toast.LENGTH_SHORT)
                .show();*/


    }


    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {

                Log.v(TAG, "Permission is revoked");
                requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        Log.d(LOG_TAG1, "onRequestPermissionsResult");
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(LOG_TAG1, "Launch Camera");
                    takeImage();
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(getActivity(), "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_PHOTO) {
            if (mPhotoFile != null) {

                mProgressDialog = new ProgressDialog(getActivity());
                mProgressDialog.setMessage("Saving Image :)");
                mProgressDialog.setCancelable(false);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.show();

                Thread mThread = new Thread() {
                    @Override
                    public void run() {

                        Log.d(LOG_TAG1, "In mProgressDialog");

                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(mPhotoFile.getPath(), options);
                        int imageHeight = options.outHeight;
                        int imageWidth = options.outWidth;
                        long resolution = imageHeight * imageWidth;

                        Log.d(LOG_TAG1, "image Height = " + imageHeight);
                        Log.d(LOG_TAG1, "image Width = " + imageWidth);
                        Log.d(LOG_TAG1, "image resolution = " + resolution);
                        Log.d(LOG_TAG1, mPhotoFile.getPath());

                        if (resolution > 7000272) {
                            addWatermarkReduced();
                            //addWatermark();
                        } else
                            addWatermark();

                        mProgressDialog.dismiss();
                    }
                };
                mThread.start();
/*
                if (resolution > 7000272)
                    addWatermarkReduced();
                else
                    addWatermark();

                mProgressDialog.dismiss();*/

                Toast.makeText(getActivity(), "Image saved in Utkansh folder", Toast.LENGTH_LONG)
                        .show();

                Log.d(LOG_TAG1, "Intent Called");
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_VIEW);
                intent1.setDataAndType(Uri.parse("file://" + mPhotoFile.getPath()), "image/*");
                startActivity(intent1);
            }
        }


    }


}
