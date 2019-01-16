package droid.grupocelio.gavine.dao;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import droid.grupocelio.gavine.MainActivity;
import droid.grupocelio.gavine.helpers.URLHelper;
import droid.grupocelio.gavine.model.Summoner;
import droid.grupocelio.gavine.utils.AppPreferences;
import droid.grupocelio.gavine.utils.ConnectionApi;

public class SummonerDAO {

    private static String apiClass = "summoner";
    private static String apiTypeSummoners = "summoners";
    private static String url;
    private static String request;

    public static Summoner getSummonerById(int id) {
        return null;
    }

    public static Summoner getSummonerByName(String name) throws Exception {
        request = "by-name";
        url = URLHelper.getUrl(AppPreferences.region, apiClass, apiTypeSummoners, request, name);
        Summoner summoner = new Summoner();
        JSONObject jsonObject = null;
        ConnectionApi connection = new ConnectionApi(url);
        connection.start();
        while (connection.getJSONObject() == null) {
            jsonObject = connection.getJSONObject();
        }
        summoner.setProfileIconId(Integer.valueOf(String.valueOf(jsonObject.get("profileIconId"))));
        summoner.setName(String.valueOf(jsonObject.get("name")));
        summoner.setPuuid(String.valueOf(jsonObject.get("puuid")));
        summoner.setSummonerLevel(Integer.valueOf(String.valueOf(jsonObject.get("summonerLevel"))));
        summoner.setRevisionDate(Long.valueOf(String.valueOf(jsonObject.get("revisionDate"))));
        summoner.setEncryptedId(String.valueOf(jsonObject.get("id")));
        summoner.setProfileIconId(Integer.valueOf(String.valueOf(jsonObject.get("profileIconId"))));
        summoner.setAccountEncryptedId(String.valueOf(jsonObject.get("accountId")));
        connection.interrupt();
        return summoner;
    }

    public static Summoner getSummonerByPUUID(String puuid) {
        return null;
    }

    public static Summoner getSummonerByEncryptedId(String encryptedId) {
        return null;
    }
}
