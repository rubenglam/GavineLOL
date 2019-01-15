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

public class ConnectionApi extends Thread {

    private static String API_KEY = "RGAPI-e339225e-a4f4-44b9-8015-b4bc13d516d4";
    private static String RIOT_URL_API = "https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name/RubenGlam?api_key=";

    String htmlCode;

    @Override
    public void run() {

        try
        {
            URL url = new URL(RIOT_URL_API + API_KEY);
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
