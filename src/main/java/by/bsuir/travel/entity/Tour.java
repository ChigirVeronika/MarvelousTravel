package by.bsuir.travel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
}
