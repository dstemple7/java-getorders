package com.lambda.orders.services;

import com.lambda.orders.models.Order;
import com.lambda.orders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "orderServices")
public class OrderServicesImpl implements OrderServices
{
    @Autowired
    OrdersRepository orderrepos;

    @Override
    public Order save(Order order){
        return orderrepos.save(order);
    }
}
