package com.web.agenda.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.agenda.models.UserModel;
import com.web.agenda.service.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		
		this.userService = userService;
		
	}
	
	
	@PostMapping
	public ResponseEntity<Object> createUser(@RequestBody UserModel newUser){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(newUser));
	}
	
	
	@GetMapping
	public ResponseEntity<List<UserModel>> listUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findUserById(@PathVariable(value = "id") UUID id){
		Optional<UserModel> userModelOptional = userService.fingByID(id);
		if(userModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id, @RequestBody UserModel updatedUser){
		Optional<UserModel> updatedUserOptional = userService.fingByID(id);
		if(updatedUserOptional.isPresent()) {
			updatedUser.setId(id);
			return ResponseEntity.status(HttpStatus.OK).body(userService.save(updatedUser));
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id){
		Optional<UserModel> userOptional = userService.fingByID(id);
		if(userOptional.isPresent()) {
			userService.delete(userOptional.get());
			return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
			
	}

}
