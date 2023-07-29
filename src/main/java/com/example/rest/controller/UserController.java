package com.example.rest.controller;


import com.example.rest.entity.UserEntity;
import com.example.rest.exception.UserAlreadyExistException;
import com.example.rest.exception.UserNotFoundException;
import com.example.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity registration(@RequestBody UserEntity user) {
		try {
			userService.registration(user);
			return ResponseEntity.ok(("User saved"));
		} catch (UserAlreadyExistException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Something wrong...");
		}
	}

	@GetMapping
	public ResponseEntity getOneUser(@RequestParam Long id) {
		try {
			return ResponseEntity.ok(userService.getOne(id));
		} catch (UserNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Something wrong...");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id){
		try {
			return ResponseEntity.ok(userService.deleteUser(id));
		} catch (UserNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Something wrong...");
		}
	}
}
