package com.voizfonica.project;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

public class UserOrdersController {
	@Autowired
	private UserOrdersService ordersService;
	@Autowired
	private PlansService plansService;

	@PostMapping("/saveorder")
	public ResponseEntity<?> saveorder(@RequestBody UserOrders order) {
		try {
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			order.setOrderdate(date);

			UserOrders returnedOrder = ordersService.saveOrder(order);
			return new ResponseEntity<>(returnedOrder, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getorders/{customerid}")
	public List<UserPlan> getOrders(@PathVariable int customerid) {
		try {
			List<UserOrders> orders = ordersService.getOrders(customerid);
			List<UserPlan> userPlans = new ArrayList<>();
			for (UserOrders order : orders) {
				UserPlan userPlan = new UserPlan();
				userPlan.setPlandate(order.getOrderdate());
				Plans plan = plansService.getPlanById(order.getPlanid());

				userPlan.setPlandescription(plan.getPlandescription());
				userPlan.setPlanid(plan.getplanid());
				userPlan.setPlanprice(plan.getPlanprice());
				userPlan.setPlantype(plan.getPlantype());
				userPlan.setPlanvalidity(plan.getPlanvalidity());
				userPlans.add(userPlan);

			}
			return (userPlans);

		} catch (Exception exception) {
			List<UserPlan> userPlans = new ArrayList();
			return (userPlans);
		}

	}

}
