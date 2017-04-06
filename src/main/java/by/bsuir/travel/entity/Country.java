package by.bsuir.travel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id")
    @JsonBackReference
    private Region region;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "country")
    @JsonManagedReference
    private Set<City> cities;

    @Column(name = "about")
    private String about;

    @Column(name = "climate")
    private String climate;

    @Column(name = "temperature")
    private Double temperatureC;

    @Column(name = "best_start_date")
    private Timestamp bestStartDate;

    @Column(name = "best_end_date")
    private Timestamp bestEndDate;

    @Column(name = "activities")
    private String activities;

    public Country(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public Double getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(Double temperatureC) {
        this.temperatureC = temperatureC;
    }

    public Timestamp getBestStartDate() {
        return bestStartDate;
    }

    public void setBestStartDate(Timestamp bestStartDate) {
        this.bestStartDate = bestStartDate;
    }

    public Timestamp getBestEndDate() {
        return bestEndDate;
    }

    public void setBestEndDate(Timestamp bestEndDate) {
        this.bestEndDate = bestEndDate;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }
}
