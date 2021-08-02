package com.voizfonica.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		String temporaryEmailId = user.getEmailid();
		if (temporaryEmailId != null && !"".equals(temporaryEmailId)) {
			User userObject = userService.fetchUserByEmailId(temporaryEmailId);
			if (userObject != null) {
				return new ResponseEntity<User>(userObject, HttpStatus.NOT_FOUND);
			}
		}
		User userObject = null;
		userObject = userService.saveUser(user);
		return new ResponseEntity<User>(userObject, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User user) {
		String temporaryEmailId = user.getEmailid();
		String temporaryPassword = user.getPassword();
		User userObject = userService.fetchUserByEmailId(temporaryEmailId);
		String userPassword = userObject.getPassword();
		if (userPassword.equals(temporaryPassword)) {
			return new ResponseEntity<User>(userObject, HttpStatus.OK);
		}
		return new ResponseEntity<User>(userObject, HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/getallusers")
	public ResponseEntity<List<?>> getAllUsers(){
//		userService.sendEmail();
		List<User> listUsers=userService.getAllUsers();
		if(listUsers.isEmpty()) {
			return new ResponseEntity<List<?>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<?>>(listUsers,HttpStatus.OK);
	}
	@GetMapping("/getuser/{emailid}")
	public ResponseEntity<?> getuser(@PathVariable String emailid){
		try {
			User user=userService.fetchUserByEmailId(emailid);
			if(user!=null) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		catch(Exception exception) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getotp/{emailid}")
	public ResponseEntity<?> getotp(@PathVariable String emailid){
		try {
			Integer otp=userService.sendEmail(emailid);
			return new ResponseEntity<>(otp,HttpStatus.OK);
		}
		catch(Exception exception) {
			System.out.println(exception);
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
	}
	@PostMapping("/updatepassword")
	public ResponseEntity<?> changepassword(@RequestBody User user){
		try {
			User updateUser=userService.fetchUserByEmailId(user.getEmailid());
			if(updateUser!=null) {
				updateUser.setPassword(user.getPassword());
				userService.saveUser(updateUser);
				return new ResponseEntity<User> (updateUser,HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		catch(Exception exception) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
