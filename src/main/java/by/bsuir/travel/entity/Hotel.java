package by.bsuir.travel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Veranika_Chyhir on 4/3/2017.
 */
public class Hotel {
    private Integer id;
    private String name;
    private Integer stars;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference
    private City city;
}
