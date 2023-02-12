package com.jianhuazhao6.ecom.customeraccountbes.service;

import com.jianhuazhao6.ecom.customeraccountbes.dao.CustomerAccountRepository;
import com.jianhuazhao6.ecom.customeraccountbes.dto.CustomerAccountDto;
import com.jianhuazhao6.ecom.customeraccountbes.entity.CustomerAccount;
import com.jianhuazhao6.ecom.customeraccountbes.exception.DataNotFoundException;
import com.jianhuazhao6.ecom.customeraccountbes.util.CustomerAccountUtil;
import com.jianhuazhao6.ecom.customeraccountbes.vo.CustomerAccountVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("CustomerAccountServiceJpaImpl")
@RequiredArgsConstructor
public class CustomerAccountServiceJpaImpl implements CustomerAccountService{

    private final CustomerAccountRepository customerAccountRepository;
    private final static List<CustomerAccountVo> emptyList = Collections.emptyList();

    @Override
    public List<CustomerAccountVo> findByPhoneNumber(String phoneNumber) {
        if(StringUtils.hasLength(phoneNumber)) {
            List<CustomerAccount> customerAccounts = customerAccountRepository.findByPhoneNumberContains(phoneNumber);
            if (!CollectionUtils.isEmpty(customerAccounts)) {
                return customerAccounts.stream().map(e -> CustomerAccountUtil.toCustomerAccountVo(e))
                        .collect(Collectors.toList());
            }
        }
        return emptyList;
    }

    @Override
    public List<CustomerAccountVo> findByUserName(String userName) {
        if(StringUtils.hasLength(userName)) {
            List<CustomerAccount> customerAccounts = customerAccountRepository.findByUserNameContainsIgnoreCase(userName);
            if (!CollectionUtils.isEmpty(customerAccounts)) {
                return customerAccounts.stream().map(e -> CustomerAccountUtil.toCustomerAccountVo(e))
                        .collect(Collectors.toList());
            }
        }
        return emptyList;
    }

    @Override
    public List<CustomerAccountVo> findByFirstNameAndLastName(String firstName, String lastName) {
        if(StringUtils.hasLength(firstName) || StringUtils.hasLength(lastName)) {
            List<CustomerAccount> customerAccounts = customerAccountRepository
                    .findByFirstNameContainsIgnoreCaseAndLastNameContainsIgnoreCase(firstName, lastName);
            if (!CollectionUtils.isEmpty(customerAccounts)) {
                return customerAccounts.stream().map(e -> CustomerAccountUtil.toCustomerAccountVo(e))
                        .collect(Collectors.toList());
            }
        }
        return emptyList;
    }

    @Override
    public CustomerAccountVo findByUserNameAndPassword(String userName, String password) {
        if (StringUtils.hasLength(userName) && StringUtils.hasLength(password)) {
            Optional<CustomerAccount> optCustomerAccount = customerAccountRepository
                    .findByUserNameAndPassword(userName, password);
            if (optCustomerAccount.isPresent()) {
                return CustomerAccountUtil.toCustomerAccountVo(optCustomerAccount.get());
            }
        }
        return null;
    }

    @Override
    public CustomerAccountVo findByEmailAddress(String email) {
        if (StringUtils.hasLength(email)) {
            Optional<CustomerAccount> optCustomerAccount = customerAccountRepository
                    .findByEmail(email);
            if (optCustomerAccount.isPresent()) {
                return CustomerAccountUtil.toCustomerAccountVo(optCustomerAccount.get());
            }
        }
        return null;
    }

    @Override
    public CustomerAccountVo createCustomerAccount(CustomerAccountDto customerAccountDto) {
        if (Objects.isNull(customerAccountDto)) {
            return null;
        }
        CustomerAccount newCustomerAccount = CustomerAccountUtil.toCustomerAccount(customerAccountDto);
        customerAccountRepository.save(newCustomerAccount);
        return CustomerAccountUtil.toCustomerAccountVo(newCustomerAccount);
    }

    @Override
    public CustomerAccountVo updateCustomerAccount(CustomerAccountDto customerAccountDto) {
        if (Objects.isNull(customerAccountDto)) {
            return null;
        }
        if (Objects.isNull(customerAccountDto.getId())) {
            return null;
        }
        Optional<CustomerAccount> optCustomerAccount = customerAccountRepository.findById(customerAccountDto.getId());
        if (optCustomerAccount.isEmpty()) {
            return null;
        }
        CustomerAccount customerAccount = optCustomerAccount.get();
        customerAccountRepository.save(customerAccount);
        return CustomerAccountUtil.toCustomerAccountVo(customerAccount);
    }

    @Override
    public CustomerAccountVo deleteCustomerAccount(Integer id) {
        if (Objects.isNull(id)) {
            return null;
        }
        Optional<CustomerAccount> optCustomerAccount = customerAccountRepository.findById(id);
        if (optCustomerAccount.isEmpty()) {
            return null;
        }
        customerAccountRepository.deleteById(id);
        return CustomerAccountUtil.toCustomerAccountVo(optCustomerAccount.get());
    }
}
