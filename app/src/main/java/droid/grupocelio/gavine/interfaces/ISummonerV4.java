package droid.grupocelio.gavine.interfaces;

import droid.grupocelio.gavine.model.Summoner;

public interface ISummonerV4 {

    Summoner getSummonerById(int id);
    Summoner getSummonerByName(String name);
    Summoner getSummonerByPUUID(String puuid);
    Summoner getSummonerByEncryptedId(String encryptedId);

}
