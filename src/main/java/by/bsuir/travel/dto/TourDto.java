package by.bsuir.travel.dto;

import by.bsuir.travel.entity.City;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("tourDto")
public class TourDto {

    private Integer id;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date startDate;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date endDate;

    private City cityFrom;

    private City cityTo;

    public TourDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }
}
