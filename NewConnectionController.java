package com.voizfonica.project;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NewConnectionController {
	@Autowired
	private NewConnectionService newConnectionService;

	@PostMapping("/registerForNewConnection")
	public ResponseEntity<NewConnection> registerUser(@RequestBody NewConnection newConnection) {
		try {
			NewConnection newReturnedConnection = newConnectionService.saveNewConnectionRequest(newConnection);
			return new ResponseEntity<NewConnection>(newReturnedConnection, HttpStatus.OK);
		} catch (NoSuchElementException exception) {
			return new ResponseEntity<NewConnection>(newConnection, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAllNewConnectionDetails")
	public ResponseEntity<List<?>> getAllData() {
		try {
			List<NewConnection> list = newConnectionService.getAllData();
			return new ResponseEntity<List<?>>(list, HttpStatus.OK);
		} catch (NoSuchElementException exception) {
			return new ResponseEntity<List<?>>(HttpStatus.BAD_REQUEST);
		}
	}
}
