package com.jianhuazhao6.ecom.customeraccountbes.service;

import com.jianhuazhao6.ecom.customeraccountbes.dto.CustomerAccountDto;
import com.jianhuazhao6.ecom.customeraccountbes.vo.CustomerAccountVo;

import java.util.List;

public interface CustomerAccountService {

    List<CustomerAccountVo> findByPhoneNumber(String phoneNumber);
    List<CustomerAccountVo> findByUserName(String userName);
    List<CustomerAccountVo> findByFirstNameAndLastName(String fistName, String lastName);
    CustomerAccountVo findByUserNameAndPassword(String userName,String password);
    CustomerAccountVo findByEmailAddress(String email);
    CustomerAccountVo createCustomerAccount(CustomerAccountDto customerAccountDto);
    CustomerAccountVo updateCustomerAccount(CustomerAccountDto customerAccountDto);
    CustomerAccountVo deleteCustomerAccount(Integer id);
}
