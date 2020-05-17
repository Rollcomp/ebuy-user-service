package org.ebuy.userservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.ebuy.userservice.model.Gender;
import org.ebuy.userservice.model.Membership;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ozgur Ustun on May, 2020
 */

@Entity
@Getter
@Setter
@Table(name="regular_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, updatable = false, unique = true)
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "membership")
    private Membership membership;

    //Payment asamasinda kullanilan address buraya eklenecek
    @Column(name = "address")
    private String lastUsedAddress;

}
