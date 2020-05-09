package org.ebuy.userservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.ebuy.userservice.model.Gender;
import org.ebuy.userservice.model.Membership;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Ozgur Ustun on May, 2020
 */

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Date birthDate;
    private Gender gender;
    private Membership membership;

}
