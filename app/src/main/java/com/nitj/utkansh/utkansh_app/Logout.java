package com.nitj.utkansh.utkansh_app;


import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nitj.utkansh.utkansh_app.activity.ApplicationConstants;

public class Logout {

    RequestParams params = new RequestParams();

    GoogleCloudMessaging gcmObj;



    public void unRegisterUserForNotifications(String email,String regId) {

            deleteUserFromGCM(email,regId);

    }

    // Share RegID and Email ID with GCM Server Application (Php)
    private void deleteUserFromGCM(final String email,final  String regId)
    {
        params.put("emailId", email);
       params.put("regId",regId);
        // Make RESTful webservice call using AsyncHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(ApplicationConstants.DELETE_USER_URL, params, new AsyncHttpResponseHandler() {
            // When the response returned by REST has Http
            // response code '200'
            @Override
            public void onSuccess(String response) {


            }

            @Override
            public void onFailure(int statusCode, Throwable error,
                                  String content) {

            }
        });
    }




}
