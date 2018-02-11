package by.bsuir.travel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "city_from_id")
    @JsonBackReference
    private City cityFrom;

    @ManyToOne
    @JoinColumn(name = "city_to_id")
    @JsonBackReference
    private City cityTo;

    @Column(name = "price")
    private Double price;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    @JsonManagedReference
    private Set<Ticket> ticket;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    @JsonManagedReference
    private Set<Order> orders;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonBackReference
    private Group group;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    @JsonManagedReference
    private Set<Hotel> hotels;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tour")
    @JsonManagedReference
    private Set<Booking> bookings;

    public Tour() {
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(Set<Ticket> ticket) {
        this.ticket = ticket;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}
