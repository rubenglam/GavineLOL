package droid.grupocelio.gavine.utils;

import android.os.AsyncTask;

import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import droid.grupocelio.gavine.helpers.URLHelper;

public class ConnectionApi extends Thread {

    String htmlCode;

    @Override
    public void run() {

        try
        {
            //URL url = new URL(URLHelper.getUrl());
            InputStream inputStream = url.openStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            byte[] buffer = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int bytesRead = 0;
            while((bytesRead = bis.read(buffer)) > 0) {
                String text = new String(buffer, 0, bytesRead);
                sb.append(text);
            }
            bis.close();

            htmlCode = sb.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public String getNameS() {
        return htmlCode;
    }

}
