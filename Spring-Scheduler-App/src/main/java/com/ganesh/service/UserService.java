package com.ganesh.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ganesh.model.User;
import com.ganesh.service.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	
	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	// adding Object every 5 sec in db using scheduler
	
	//@Scheduled(fixedRate=5000)
	@Scheduled(initialDelay=1000L ,fixedDelayString="PT05S")
	public void add2DbJob() {
		
		User user = new User();
		user.setName("User"+ new Random().nextInt(374483));
		userRepo.save(user);
		System.out.println("Adding User Name In Db: "+ new Date().toString());
		
	}
	
	//@Scheduled(cron="0/15 * * * * *")
	@Scheduled(fixedDelayString="PT01M")
	public void fetchDbData() {
		List<User> users = userRepo.findAll();
		System.out.println("Fetching User Name In Db: "+ new Date().toString());
		System.out.println("Number of User Name Fatche from Db: "+ users.size());
		log.info("users: {}", users);
	}
}
