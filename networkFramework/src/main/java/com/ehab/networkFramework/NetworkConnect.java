package com.ehab.networkFramework;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkConnect extends AsyncTask<Void, Void, JSONObject> {

    private String JSON_URL ,RequestMethod ;
    String charset = "UTF-8";
    HttpURLConnection conn;
    StringBuilder result;
    URL urlObj;
    JSONObjectRequestListener listener ;


    public NetworkConnect(String url, String requestMethod) {
        this.JSON_URL = url;
        this.RequestMethod = requestMethod;
    }
    public void setCustomEventListener(JSONObjectRequestListener eventListener) {
        this.execute();

        listener = eventListener;
    }
//    public void build(){
//    }

    @Override
    protected JSONObject doInBackground(Void... args) {

        JSONObject retObj = null;

        try {
            urlObj = new URL(JSON_URL);

            conn = (HttpURLConnection) urlObj.openConnection();
            conn.setDoOutput(false);
            conn.setRequestMethod(RequestMethod);
            conn.setRequestProperty("Accept-Charset", charset);
            conn.setConnectTimeout(15000);
            conn.connect();

            //Receive the response from the server
            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            Log.d("NetworkConnect", "result: " + result.toString());

            retObj = new JSONObject(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return retObj;
    }

    @Override
    protected void onPostExecute(JSONObject json) {
        if (json != null) {
            Log.d("JSON result", "onPostExecute: "+json.toString());
            listener.onResponse(json);
        }
    }
}

