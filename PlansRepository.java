package com.voizfonica.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlansRepository extends JpaRepository<Plans, Integer> {
	public List<Plans> findByplantype(String planType);
	public Plans findByplanid(int id);

}