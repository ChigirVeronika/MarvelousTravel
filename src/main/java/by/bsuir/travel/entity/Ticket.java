package by.bsuir.travel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {//todo change db

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="number")
    private String number;//todo change db

    @ManyToOne
    @JoinColumn(name = "city_from_id")
    @JsonBackReference
    private City cityFrom;

    @ManyToOne
    @JoinColumn(name = "city_to_id")
    @JsonBackReference
    private City cityTo;

    @Column(name = "start_date")
    private Date startDate;//todo change db

    @Column(name = "end_date")
    private Date endDate;//todo change db

    @Column(name = "price")
    private Double price;

    //todo ???
    private Transport transport;//todo change db

    public Ticket(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
