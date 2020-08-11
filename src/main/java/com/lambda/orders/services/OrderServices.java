package com.lambda.orders.services;

import com.lambda.orders.models.Order;

public interface OrderServices
{

    Order findOrderById(long id);

    Order save(Order order);
}
