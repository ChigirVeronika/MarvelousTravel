package by.bsuir.travel.entity;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {


//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "creator")
//    private Set<Bill> bills;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    @NotEmpty(message = "Please fill the field.")
    @Size(min = 2, max = 25, message = "Value must be between 2 and 25 characters")
    private String firstName;

    @Column(name = "lastname")
    @NotEmpty(message = "Please fill the field.")
    @Size(min = 2, max = 25, message = "Value must be between 2 and 25 characters")
    private String lastName;

    @Column(name = "middlename")
    @NotEmpty(message = "Please fill the field.")
    @Size(min = 2, max = 25, message = "Value must be between 2 and 25 characters")
    private String middleName;

    @Column(name = "birthday")
    @NotEmpty(message = "Please fill the field.")
    private Date birthday;

    @Column(name = "gender")
    @NotEmpty(message = "Please fill the field.")
    private String gender;

    //private String passportSeriesAndNumber;

    @Column(name = "whomgranted")
    @NotEmpty(message = "Please fill the field.")
    private String whomGranted;

    @Column(name = "granteddate")
    @NotEmpty(message = "Please fill the field.")
    private Date grantedDate;

    @Column(name = "idnumber")
    @NotEmpty(message = "Please fill the field.")
    @Size(min = 2, max = 25, message = "Value must be between 2 and 25 characters")
    private String idNumber;

    @Column(name = "birthplace")
    @NotEmpty(message = "Please fill the field.")
    private String birthPlace;

    @Column(name = "accommodationaddres")
    @NotEmpty(message = "Please fill the field.")
    private String accommodationAddress;

    @Column(name = "homephone")
    private String homePhone;
    @Column(name = "cellphone")
    private String cellPhone;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name="workplace")
    private String workPlace;
    @Column(name="position")
    private String position;

    @Column(name="pensioner")
    private Boolean pensioner;
    @Column(name="monthincome")
    private Double monthIncome;

    @Column(name = "passportseries")
    private String passportSeries;

    @Column(name = "passportnumber")
    private String passportNumber;

    public User() {
    }

}
