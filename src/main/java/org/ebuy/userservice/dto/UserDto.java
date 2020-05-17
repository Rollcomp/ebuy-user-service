package org.ebuy.userservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.ebuy.userservice.model.Gender;
import org.ebuy.userservice.model.Membership;

import java.util.Date;

/**
 * Created by Ozgur Ustun on May, 2020
 */

@Getter
@Setter
public class UserDto {

    private Long id;
    private String email;
    private Gender gender;
    private Membership membership;
    //Payment asamasinda kullanilan address buraya eklenecek
    private String lastUsedAddress;
}
