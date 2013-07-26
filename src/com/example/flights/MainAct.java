package com.example.flights;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.android.volley.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created with IntelliJ IDEA.
 * User: 1
 * Date: 24.07.13
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */
public class MainAct extends Activity {
    public final String TAG = getClass().getSimpleName();
    private ArrayList<flight> Flist;
    private ListView listView;
    private FAdapter ba;
    private ProgressDialog progress;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Flist = new ArrayList<flight>();
        listView = (ListView) findViewById(R.id.listView);
        fa = new FAdapter(this, R.layout.blog_item, Flist);

        listView.setAdapter(fa);
        RequestQueue reqQueue = Volley.newRequestQueue(this);
        String url = null;
        url = "http://localhost:8888/mongo1";
        try {
            String w;
            w = "{\"a2\":\"владивосток\"}";  //собрать строку из данных, введенных пользователем
            JSONObject myString;
            myString = new JSONObject(w);


            JsonObjectRequest jr = new JsonObjectRequest(Request.Method.POST, url, myString, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    // TODO Auto-generated method stub
                    parseJSONRespone(response);
                    fa.notifyDataSetChanged();
                    progress.dismiss();
                }

            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO Auto-generated method stub
                    Log.v(TAG, error.getMessage());
                }
            });
                reqQueue.add(jr);
            reqQueue.start();
                    progress = ProgressDialog.show(this, "",
                    "Loading123");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

    }
}
    private void parseJSONRespone(JSONObject response) {
        // TODO Auto-generated method stub
        try {
            JSONObject responseData = response.getJSONObject("responseData");
            JSONArray entries = responseData.getJSONArray("entries");

            for (int count = 0; count < entries.length(); count++) {

                JSONObject anEntry = entries.getJSONObject(count);
                flight aFlight = new flight(anEntry.optString("1"),  //указать точные строки
                        anEntry.optString("2"));
                Flist.add(aFlight);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}