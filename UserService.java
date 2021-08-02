package com.voizfonica.project;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JavaMailSender javaMailSender;


	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User fetchUserByEmailId(String emailid) {
		return userRepository.findByemailid(emailid);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();

	}

	Integer sendEmail(String email) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		
		msg.setFrom("muralibhattu038@gmail.com");
		msg.setSubject("VoizFOnica Email Verification");

		Random rand = new Random();
		Integer otp = rand.nextInt((9999 - 100) + 1) + 10;
		msg.setText("Your otp is" + "	" + otp);

		javaMailSender.send(msg);
		return otp;

	}

}
