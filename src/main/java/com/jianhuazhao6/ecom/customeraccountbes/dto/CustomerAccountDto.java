package com.jianhuazhao6.ecom.customeraccountbes.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerAccountDto {

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
}
