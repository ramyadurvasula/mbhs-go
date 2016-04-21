package com.example.ramya.mbhs;

/**
 * Created by Stephan Loh on 4/19/2016.
 * Code adapted from: http://www.parallelcodes.com/connect-android-to-ms-sql-database-2/2/
 */
import android.annotation.SuppressLint;
import android.os.StrictMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import android.util.Log;
public class SQLConnection {
    private String ip = "localhost";
    private String db =  "mbhsweb";
    private String un = "mbhsgo";
    private String password = "softwaredesign";

    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn =  null;
        String connURL;
        try{
           connURL = "https://vote.mbhs.edu/pma449" +
                   ip + ";" + "dtabaseName=" +
                   db +";user=" + un + ";password=" +
                   password + ";";
            conn = DriverManager.getConnection(connURL);
        } catch (SQLException se) {
            Log.e("Error", se.getMessage());
        } catch (Exception e){
            Log.e("Error", e.getMessage());
        }
        return conn;
    }
}
