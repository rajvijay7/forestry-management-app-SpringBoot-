package com.cg.fms.controller;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Customer;
import com.cg.fms.entities.Login;
import com.cg.fms.entities.User;
import com.cg.fms.exception.ConfirmPasswordException;
import com.cg.fms.exception.CustomerNotFoundException;
import com.cg.fms.exception.InvalidEmailAndPassword;
import com.cg.fms.exception.UserDoesNotExist;
import com.cg.fms.exception.UserEmailAlreadyExistException;
import com.cg.fms.exception.UserNameException;
import com.cg.fms.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/registration")
public class RegistrationController {
		
	@Autowired
	private IUserService userService;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	@PostMapping("registration")
	public ResponseEntity<User> registerUserAccount(@Valid @RequestBody User user) throws UserEmailAlreadyExistException, UserNameException, ConfirmPasswordException
	{
//		bCryptPasswordEncoder.encode(user.getPassword());
				
		User user1 = userService.save(user);
		
		return new ResponseEntity<User>(user1,HttpStatus.CREATED);
	}	
	

	
	@PostMapping("login")
	public ResponseEntity<Login>  login(@RequestBody  Login login,HttpSession session) throws InvalidEmailAndPassword
	{
		String email= login.getEmail();
		String pwd = login.getPassword();
		
		
		if(userService.findByEmailAndPassword(email, pwd)==false) 
		{
			throw new InvalidEmailAndPassword();
		}
		
		
		
		return new ResponseEntity<>(login, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all Customers Details")
	public List<User> fetch() {
		return userService.fetchAll();
	}
	
	
	@GetMapping("/getById/{id}")
	@ApiOperation("Get Customer By ID")
	public User fetchById(@PathVariable int id) throws UserDoesNotExist {
		return userService.fetchById(id);
	}
	
	
	@GetMapping("user/{email}")
	public User getUserDetails(@PathVariable String email) throws UserDoesNotExist{
		User user=userService.getByEmail(email);
		return user;
		
	}
	


	
	
	@PutMapping("/update")
	@ApiOperation("update customer details ")
	public User update(@Valid @RequestBody User user) {
		
		return userService.updateUser(user);
		
	}

	
}


