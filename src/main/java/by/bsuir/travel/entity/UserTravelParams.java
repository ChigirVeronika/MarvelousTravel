package by.bsuir.travel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_travel_params")
public class UserTravelParams {

    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "user_id", unique = true, nullable = false)
    private Integer userId;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @JsonBackReference
    private User user;

    @Column(name = "favorite_seasons")
    private List<String> favoriteSeasons;//winter, spring, summer, fall

    @Column(name = "favourite_regions")
    private List<Region> favoriteRegions;

    @Column(name = "favorite_countries")
    private List<Country> favoriteCountries;

    @Column(name = "comfort_level")
    private String comfortLevel;//low, medium, high

    @Column(name = "nature_or_city")
    private String natureOrCity;//nature, city, both

    @Column(name = "service_type")
    private String serviceType;//travel_agency, own, both //???is it needed

    public UserTravelParams() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Country> getFavoriteCountries() {
        return favoriteCountries;
    }

    public void setFavoriteCountries(List<Country> favoriteCountries) {
        this.favoriteCountries = favoriteCountries;
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

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
