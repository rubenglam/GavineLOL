package droid.grupocelio.gavine.dao;

import droid.grupocelio.gavine.MainActivity;
import droid.grupocelio.gavine.helpers.URLHelper;
import droid.grupocelio.gavine.interfaces.ISummonerV4;
import droid.grupocelio.gavine.model.Summoner;
import droid.grupocelio.gavine.utils.AppPreferences;

public class SummonerDAO {

    private static String apiClass = "summoner";
    private static String apiTypeSummoners = "summoners";
    private static String url;

    public static Summoner getSummonerById(int id) {
        return null;
    }

    public static Summoner getSummonerByName(String name) {
        String request = "by-name";
        url = URLHelper.getUrl(AppPreferences.region, apiClass, apiTypeSummoners, request, name);
        Summoner summoner = new Summoner();
        return null;
        //summoner.
    }

    public static Summoner getSummonerByPUUID(String puuid) {
        return null;
    }

    public static Summoner getSummonerByEncryptedId(String encryptedId) {
        return null;
    }
}
