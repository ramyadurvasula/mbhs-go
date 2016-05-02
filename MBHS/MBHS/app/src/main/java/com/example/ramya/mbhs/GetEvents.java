package com.example.ramya.mbhs;

import android.os.AsyncTask;
import android.content.Context;
import java.sql.Connection;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.Buffer;

/**
 * Created by Stephan Loh on 4/21/2016.
 */
public class GetEvents extends AsyncTask<String, String, String> {
    private Context context;


    public GetEvents(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... params) {
        /*
        String username = arg0[0];
        String password = arg0[1];

        String link;
        String data;
        String result;
        BufferedReader bfReader;


        try{
            link = "http://vote.mbhs.edu/pma449" + data;
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            bfReader = new BufferedReader(new InputStreamReader(con.))
        }
        */

        /*
    try {
        Connection con = SQLConnection.CONN();
    }
*/
        return "hi";

    }
}
