package com.jianhuazhao6.ecom.customeraccountbes.entity;

import com.jianhuazhao6.ecom.customeraccountbes.commom.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer_account")
public class CustomerAccount extends BaseEntity {
    @Column(name = "user_name", length = 30, nullable = false)
    private String userName;
    @Column(name = "password", length = 32, nullable = false)
    private String password;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 10, nullable = false)
    private Gender gender;
    @Column(name = "email", length = 255)
    private String email;
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "phone_number",length = 30)
    private String phoneNumber;
    @Column(name = "address", length = 1000)
    private String address;
}
