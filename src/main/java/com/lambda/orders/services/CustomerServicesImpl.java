package com.lambda.orders.services;

import com.lambda.orders.models.Customer;
import com.lambda.orders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "customerServices")
public class CustomerServicesImpl implements CustomerServices
{
    @Autowired
    CustomersRepository custrepos;

    @Override
    public Customer save(Customer customer){
        return custrepos.save(customer);
    }
}
