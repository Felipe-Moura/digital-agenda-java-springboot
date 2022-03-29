package com.web.agenda.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.agenda.models.UserModel;
import com.web.agenda.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
		
	}

	
	@Transactional
	public UserModel save(UserModel newUser) {
		return userRepository.save(newUser);
	}

	
	public List<UserModel> findAll() {
		return userRepository.findAll();
	}

	
	public Optional<UserModel> fingByID(UUID id) {
		return userRepository.findById(id);
	}

	@Transactional
	public void delete(UserModel user) {
		userRepository.delete(user);
	}

}
