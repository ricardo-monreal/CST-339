package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;
import com.gcu.model.UserModel;

@Service
public class UserBusinessService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	
	
	// non-default constructor for constructor injection
	public UserBusinessService(UsersRepository usersRepository) {
		
		this.usersRepository = usersRepository;
	}
	
	// get all users from the database
	public List<UserModel> getAllUsers(){
		
		
		// get all the entity users
		List<UserEntity> usersEntity = usersRepository.findAll();
		// iterate over the entity users and create a List of domain users
		List<UserModel> usersDomain = new ArrayList<UserModel>();
		for(UserEntity user : usersEntity)
		{
			usersDomain.add(new UserModel(user.getId(), user.getUsername(), user.getPassword()));
		}
		
		// return list of domain users
		return usersDomain;
		
		
	}

}
