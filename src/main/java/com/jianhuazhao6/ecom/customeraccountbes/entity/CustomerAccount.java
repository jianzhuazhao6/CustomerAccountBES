package com.jianhuazhao6.ecom.customeraccountbes.entity;

import com.jianhuazhao6.ecom.customeraccountbes.commom.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder(toBuilder = true)
@Table(name = "customer_account", indexes = {
        @Index(name = "idx_customeraccount_user_name", columnList = "user_name", unique = true),
        @Index(name = "idx_customeraccount_email", columnList = "email", unique = true)
})
public class CustomerAccount extends BaseEntity {
    @Column(name = "user_name", length = 30, nullable = false, unique = true)
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
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Instant birthday;
    @Column(name = "phone_number",length = 30)
    private String phoneNumber;
    @Column(name = "address", length = 1000)
    private String address;
}
