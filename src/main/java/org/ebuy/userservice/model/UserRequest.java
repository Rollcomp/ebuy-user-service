package org.ebuy.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Ozgur Ustun on May, 2020
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Date birthDate;
    private Gender gender;
    private Membership membership;
    private String lastUsedAddress;

}
