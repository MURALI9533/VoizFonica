package com.voizfonica.project;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByemailid(String emailid);

}
