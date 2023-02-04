package com.jianhuazhao6.ecom.customeraccountbes.service;

import com.jianhuazhao6.ecom.customeraccountbes.dao.CustomerAccountRepository;
import com.jianhuazhao6.ecom.customeraccountbes.dto.CustomerAccountDto;
import com.jianhuazhao6.ecom.customeraccountbes.entity.CustomerAccount;
import com.jianhuazhao6.ecom.customeraccountbes.util.CustomerAccountUtil;
import com.jianhuazhao6.ecom.customeraccountbes.vo.CustomerAccountVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("CustomerAccountServiceJpaImpl")
@RequiredArgsConstructor
public class CustomerAccountServiceJpaImpl implements CustomerAccountService{

    private final CustomerAccountRepository customerAccountRepository;

    @Override
    public List<CustomerAccountVo> findCustomerAccounts(String findType, CustomerAccountDto customerAccountDto) {
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
