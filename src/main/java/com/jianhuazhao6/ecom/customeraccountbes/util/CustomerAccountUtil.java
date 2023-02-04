package com.jianhuazhao6.ecom.customeraccountbes.util;

import com.jianhuazhao6.ecom.customeraccountbes.commom.Gender;
import com.jianhuazhao6.ecom.customeraccountbes.dto.CustomerAccountDto;
import com.jianhuazhao6.ecom.customeraccountbes.entity.CustomerAccount;
import com.jianhuazhao6.ecom.customeraccountbes.vo.CustomerAccountVo;

public class CustomerAccountUtil {

    public static CustomerAccount toCustomerAccount(CustomerAccountDto customerAccountDto) {
        return CustomerAccount.builder().id(customerAccountDto.getId())
                .userName(customerAccountDto.getUserName())
                .password(customerAccountDto.getPassword())
                .firstName(customerAccountDto.getFirstName())
                .lastName(customerAccountDto.getLastName())
                .gender(Gender.valueOf(customerAccountDto.getGender()))
                .address(customerAccountDto.getAddress())
                .email(customerAccountDto.getEmail())
                .birthday(customerAccountDto.getBirthday())
                .phoneNumber(customerAccountDto.getPhoneNumber())
                .build();
    }

    public static CustomerAccountVo toCustomerAccountVo(CustomerAccount customerAccount) {
        return CustomerAccountVo.builder().id(customerAccount.getId())
                .userName(customerAccount.getUserName())
                .password(customerAccount.getPassword())
                .firstName(customerAccount.getFirstName())
                .lastName(customerAccount.getLastName())
                .gender(customerAccount.getGender().name())
                .address(customerAccount.getAddress())
                .email(customerAccount.getEmail())
                .birthday(customerAccount.getBirthday())
                .phoneNumber(customerAccount.getPhoneNumber())
                .createdUser(customerAccount.getCreatedUser())
                .createdDate(customerAccount.getCreatedDate())
                .modifiedUser(customerAccount.getModifiedUser())
                .modifiedDate(customerAccount.getModifiedDate())
                .build();
    }
}
