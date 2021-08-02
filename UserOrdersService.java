package com.voizfonica.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrdersService {
	@Autowired
	private UserOrdersRepository orderRepository;
	public UserOrders saveOrder(UserOrders order) {
		return orderRepository.save(order);
	}
	public List<UserOrders> getOrders(int id){
		return orderRepository.findByuserid(id);
	}

}
