package com.jianhuazhao6.ecom.customeraccountbes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.security.Security;

@SpringBootApplication
public class CustomerAccountBesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerAccountBesApplication.class, args);
    }

}
