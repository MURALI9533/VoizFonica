package com.voizfonica.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrdersRepository extends JpaRepository<UserOrders, Integer>{
	public List<UserOrders> findByuserid(int id);

}
