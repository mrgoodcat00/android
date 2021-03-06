package com.goodcat.vkclient.application.model.user;


import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("id")
    private long id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("last_seen")
    private UserLastSeenModel lastSeen;

    @SerializedName("home_town")
    private String homeTown;

    @SerializedName("counters")
    private UserCountersModel counters;

    @SerializedName("photo_200")
    private String photo200;

    @SerializedName("photo_100")
    private String photo100;

    @SerializedName("photo_50")
    private String photo50;

    public long getId() {
        return id;
    }

    public String getStringId() {
        return id+"";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserLastSeenModel getLastSeen() {
        return lastSeen;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public UserCountersModel getCounters() {
        return counters;
    }

    public String getPhoto200() {
        return photo200;
    }

    public String getPhoto50() {
        return photo50;
    }

    public String getPhoto100() {
        return photo100;
    }

    public void setPhoto100(String photo100) {
        this.photo100 = photo100;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLastSeen(UserLastSeenModel lastSeen) {
        this.lastSeen = lastSeen;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public void setCounters(UserCountersModel counters) {
        this.counters = counters;
    }

    public void setPhoto200(String photo200) {
        this.photo200 = photo200;
    }
}
