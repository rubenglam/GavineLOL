package droid.grupocelio.gavine.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

public class ConnectionApi {

    private static String API_KEY = "RGAPI-b03a1f17-89f7-47d5-8a7b-38c0983d9c04";
    private static String RIOT_URL_API = "https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name/RiotSchmick?api_key=";

    public static JSONObject getConnection() throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.get("curl --request GET 'https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name/RiotSchmick?api_key=RGAPI-b03a1f17-89f7-47d5-8a7b-38c0983d9c04' --include");

        return jsonObject;
    }

}
