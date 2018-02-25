package by.bsuir.travel.dto;

import org.springframework.stereotype.Component;

@Component("tourDto")
public class TourDto {

    private String country;

    private String month;

    private Integer priceTopLimit;

    private String cityFrom;

    public TourDto(){}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getPriceTopLimit() {
        return priceTopLimit;
    }

    public void setPriceTopLimit(Integer priceTopLimit) {
        this.priceTopLimit = priceTopLimit;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }
}
