package com.jianhuazhao6.ecom.customeraccountbes.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerAccountVo {

    Integer id;
    String userName;
    String password;
    String firstName;
    String lastName;
    String gender;
    String email;
    Date birthday;
    String phoneNumber;
    String address;
    Instant createdDate;
    Instant modifiedDate;
    String createdUser;
    String modifiedUser;
}
