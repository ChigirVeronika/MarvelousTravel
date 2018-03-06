package by.bsuir.travel.entity;

import java.util.List;

public class UserTravelParams {

    private Integer user_id;
    private List<String> favoriteSeasons;//winter, spring, summer, fall
    private List<Region> favoriteRegions;
    private String comfortLevel;//low, medium, high
    private String natureOrCity;//nature, city, both
    private String travelAgencyOrOwn;//agency, own, both //???is it needed

    public UserTravelParams(){}

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public List<String> getFavoriteSeasons() {
        return favoriteSeasons;
    }

    public void setFavoriteSeasons(List<String> favoriteSeasons) {
        this.favoriteSeasons = favoriteSeasons;
    }

    public List<Region> getFavoriteRegions() {
        return favoriteRegions;
    }

    public void setFavoriteRegions(List<Region> favoriteRegions) {
        this.favoriteRegions = favoriteRegions;
    }

    public String getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(String comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public String getNatureOrCity() {
        return natureOrCity;
    }

    public void setNatureOrCity(String natureOrCity) {
        this.natureOrCity = natureOrCity;
    }

    public String getTravelAgencyOrOwn() {
        return travelAgencyOrOwn;
    }

    public void setTravelAgencyOrOwn(String travelAgencyOrOwn) {
        this.travelAgencyOrOwn = travelAgencyOrOwn;
    }
}
