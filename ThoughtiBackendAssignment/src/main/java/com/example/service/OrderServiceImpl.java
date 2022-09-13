package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.CustomException;
import com.example.entity.Order;
import com.example.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order saveOrder(Order order) {
		log.info("order {}", order);
		order.getItems().stream().forEach(item -> item.setOrder(order));
		orderRepository.save(order);
		return order;
	}

	@Override
	public List<Order> getAllOrder() {
		try {
			return (List<Order>) orderRepository.findAll();

		} catch (Exception e) {

			log.error(e.getMessage());
			throw new CustomException(500, e.getMessage());

		}

	}

	@Override
	public Optional<Order> findById(Integer id) {

		try {
			return orderRepository.findById(id);

		} catch (Exception e) {

			log.error(e.getMessage());
			throw new CustomException(500, e.getMessage());

		}

	}
}
