package com.jianhuazhao6.ecom.customeraccountbes.service;

import com.jianhuazhao6.ecom.customeraccountbes.dto.CustomerAccountDto;
import com.jianhuazhao6.ecom.customeraccountbes.vo.CustomerAccountVo;

import java.util.List;

public interface CustomerAccountService {

    List<CustomerAccountVo> findCustomerAccounts(String findType, CustomerAccountDto customerAccountDto);
    CustomerAccountVo createCustomerAccount(CustomerAccountDto customerAccountDto);
    CustomerAccountVo updateCustomerAccount(CustomerAccountDto customerAccountDto);
    CustomerAccountVo deleteCustomerAccount(Integer id);
}
