package by.bsuir.travel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference
    private Country country;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "city")
    @JsonManagedReference
    private Set<Hotel> hotels;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cityFrom")
    @JsonManagedReference
    private Set<Ticket> ticketsFrom;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cityTo")
    @JsonManagedReference
    private Set<Ticket> ticketsTo;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "home")
    @JsonManagedReference
    private Set<User> citizens;

    public City(){}

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Set<Ticket> getTicketsFrom() {
        return ticketsFrom;
    }

    public void setTicketsFrom(Set<Ticket> ticketsFrom) {
        this.ticketsFrom = ticketsFrom;
    }

    public Set<Ticket> getTicketsTo() {
        return ticketsTo;
    }

    public void setTicketsTo(Set<Ticket> ticketsTo) {
        this.ticketsTo = ticketsTo;
    }

    public Set<User> getCitizens() {
        return citizens;
    }

    public void setCitizens(Set<User> citizens) {
        this.citizens = citizens;
    }
}
