package droid.grupocelio.gavine.model;

import android.os.Parcel;
import android.os.Parcelable;

import droid.grupocelio.gavine.dao.SummonerDAO;

public class Summoner implements Parcelable {

    int profileIconId;
    String name;
    String puuid;
    int summonerLevel;
    long revisionDate;
    String encryptedId;
    String encryptedAccountId;

    public Summoner() {}

    protected Summoner(Parcel in) {
        profileIconId = in.readInt();
        name = in.readString();
        puuid = in.readString();
        summonerLevel = in.readInt();
        revisionDate = in.readLong();
        encryptedId = in.readString();
        encryptedAccountId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(profileIconId);
        dest.writeString(name);
        dest.writeString(puuid);
        dest.writeInt(summonerLevel);
        dest.writeLong(revisionDate);
        dest.writeString(encryptedId);
        dest.writeString(encryptedAccountId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Summoner> CREATOR = new Creator<Summoner>() {
        @Override
        public Summoner createFromParcel(Parcel in) {
            return new Summoner(in);
        }

        @Override
        public Summoner[] newArray(int size) {
            return new Summoner[size];
        }
    };

    public static Summoner getSummonerByName(String name) throws Exception {
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
        return encryptedAccountId;
    }

    public void setAccountEncryptedId(String accountEncryptedId) {
        this.encryptedAccountId = accountEncryptedId;
    }

}


