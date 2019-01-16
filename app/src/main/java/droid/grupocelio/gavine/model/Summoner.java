package droid.grupocelio.gavine.model;

import droid.grupocelio.gavine.dao.SummonerDAO;
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
    public Summoner getSummonerByName(String name)
    {
        Summoner summoner = SummonerDAO.getSummonerByName(name);
        return summoner;
    }

    @Override
    public Summoner getSummonerByPUUID(String puuid) {
        return null;
    }

    @Override
    public Summoner getSummonerByEncryptedId(String encryptedId) {
        return null;
    }

    //region PROPERTIES

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public int getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(int revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getEncryptedId() {
        return encryptedId;
    }

    public void setEncryptedId(String encryptedId) {
        this.encryptedId = encryptedId;
    }

    public String getAccountEncryptedId() {
        return accountEncryptedId;
    }

    public void setAccountEncryptedId(String accountEncryptedId) {
        this.accountEncryptedId = accountEncryptedId;
    }

}


