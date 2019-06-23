package by.bsuir.travel.dto;

public class RatedPlaceDto {

    private String name;

    private String about;

    private String cityName;

    private Double rating;

    public RatedPlaceDto() {
    }

    public RatedPlaceDto(String name, String about, String cityName) {
        this.name = name;
        this.about = about;
        this.cityName = cityName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
