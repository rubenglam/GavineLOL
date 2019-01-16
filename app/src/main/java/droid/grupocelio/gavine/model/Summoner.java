package droid.grupocelio.gavine.model;

import droid.grupocelio.gavine.dao.SummonerDAO;

public class Summoner {

    int profileIconId;
    String name;
    String puuid;
    int summonerLevel;
    long revisionDate;
    String encryptedId;
    String accountEncryptedId;

    public static Summoner getSummonerByName(String name) throws Exception
    {
        Summoner summoner = SummonerDAO.getSummonerByName(name);
        return summoner;
    }

    public static Summoner getSummonerById(int id)
    {
        return new Summoner();
    }

    public static Summoner getSummonerByPUUID(String puuid)
    {
        return new Summoner();
    }

    public Summoner getSummonerByEncryptedId(String encryptedId)
    {
        return new Summoner();
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

    public long getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(long revisionDate) {
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


