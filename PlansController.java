package com.voizfonica.project;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PlansController {
	@Autowired
	private PlansService plansService;

	@PostMapping("/getplan")
	public ResponseEntity<List<?>> getPlan(@RequestBody Plans plans) {
		try {
			List<Plans> plansList = plansService.fetchPlansByPlanType(plans.getPlantype());
			if(plansList.isEmpty()) {
				return new ResponseEntity<List<?>>( HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<List<?>>(plansList, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<List<?>>( HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getallplans")
	public List<Plans> getAllPlans(){
		return plansService.getAllPlans();
	}

	@PostMapping("/registerplan")
	public ResponseEntity<?> registerPlan(@RequestBody Plans plans) {
		try {
			plansService.save(plans);
			return new ResponseEntity<>(plans,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/deleteplan/{id}")
	public ResponseEntity<?> deleteplan(@PathVariable int id){
		try {
			plansService.deletePlan(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("getplain/{id}")
	public ResponseEntity<Plans> getPlainById(@PathVariable int id){
		try {
			return new ResponseEntity<Plans>(plansService.getPlanById(id),HttpStatus.OK);
			
		}
		catch(Exception exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
