package com.jianhuazhao6.ecom.customeraccountbes.dao;

import com.jianhuazhao6.ecom.customeraccountbes.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Integer> {

    Optional<CustomerAccount> findByUserNameAndPassword(String userName,String password);
    List<CustomerAccount> findByUserNameContainsIgnoreCase(String userName);
    List<CustomerAccount> findByPhoneNumberContains(String phoneNumber);
    Optional<CustomerAccount> findByEmail(String email);
    List<CustomerAccount> findByFirstNameContainsIgnoreCaseAndLastNameContainsIgnoreCase
            (String firstName,String lastName);
}
