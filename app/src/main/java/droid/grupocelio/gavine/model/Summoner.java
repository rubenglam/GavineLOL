package droid.grupocelio.gavine.model;

import droid.grupocelio.gavine.interfaces.ISummonerV4;

public class Summoner implements ISummonerV4 {

    int profileIconId;
    String name;
    String puuid;
    int summonerLevel;
    int revisionDate;
    String encryptedId;
    String accountEncryptedId;

    @Override
    public Summoner getSummonerById(int id) {
        return null;
    }

    @Override
    public Summoner getSummonerByName(String name) {
        return null;
    }

    @Override
    public Summoner getSummonerByPUUID(String puuid) {
        return null;
    }

    @Override
    public Summoner getSummonerByEncryptedId(String encryptedId) {
        return null;
    }

}


