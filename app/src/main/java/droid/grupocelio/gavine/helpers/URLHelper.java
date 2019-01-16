package droid.grupocelio.gavine.helpers;

import droid.grupocelio.gavine.utils.AppPreferences;

public class URLHelper {

    private static String HTTP_URL = "https://";
    private static String RIOT_URL = ".api.riotgames.com/lol/";
    private static String RIOT_API_VERSION = "/v4/";
    private static String RIOT_REQUEST_KEY = "?api_key=";

    public static String getUrl(String region, String apiClass, String apiType, String request, String parameter) {

        return HTTP_URL + region + RIOT_URL + apiClass + RIOT_API_VERSION + apiType + "/" + request + "/" +
                parameter + RIOT_REQUEST_KEY + AppPreferences.riotApiKey;

    }

}
