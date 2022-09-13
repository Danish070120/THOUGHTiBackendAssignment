package com.example.service;



import java.util.List;
import java.util.Optional;

import com.example.entity.Order;

public interface OrderService {

	Order saveOrder(Order order);

	//Order addOrder(Order order);

	List<Order> getAllOrder();

	Optional<Order> findById(Integer id);

}
