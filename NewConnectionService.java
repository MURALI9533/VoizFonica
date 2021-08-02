package com.voizfonica.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NewConnectionService {
	@Autowired
	private NewConnectionRepository newConnectionRepository;
	public NewConnection saveNewConnectionRequest(NewConnection newConnection) {
		return newConnectionRepository.save(newConnection);
	}
	public List<NewConnection> getAllData(){
		return newConnectionRepository.findAll();
	}

}
