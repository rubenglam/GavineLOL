package droid.grupocelio.gavine.utils;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import droid.grupocelio.gavine.helpers.URLHelper;

public class ConnectionApi extends Thread {

    String url;
    JSONObject jsonObject;

    public ConnectionApi(String url)
    {
        this.url = url;
    }

    @Override
    public void run()
    {
        try { jsonObject = readJsonFromUrl(url); }
        catch (Exception e) { e.printStackTrace(); }
    }

    private static String readAll(Reader rd) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws Exception
    {
        InputStream inputStreamReader = null;
        try {
            inputStreamReader = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStreamReader, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);

            JSONObject jsonObj = new JSONObject(jsonText);
            System.out.print(jsonObj.toString());

            return jsonObj;
        }
        finally
        {
            if(inputStreamReader != null) inputStreamReader.close();
        }

    }

    public JSONObject getJSONObject()
    {
        return jsonObject;
    }

}
