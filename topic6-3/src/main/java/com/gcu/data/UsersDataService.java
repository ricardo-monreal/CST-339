package com.gcu.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;

import com.gcu.data.repository.UsersRepository;

@Service
public class UsersDataService implements DataAccessInterface<UserEntity>, UsersDataAccessInterface <UserEntity>
{
	@Autowired
	private UsersRepository usersRepository;
	
	
	//testing
	public UsersDataService(UsersRepository usersRepository) 
	{
		this.usersRepository = usersRepository;
	}
	

	public UserEntity findByUsername(String username)
	{
		return usersRepository.findByUsername(username);
	}


	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean create(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}








}
