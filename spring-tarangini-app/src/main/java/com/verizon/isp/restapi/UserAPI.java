package com.verizon.isp.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.isp.model.User;
import com.verizon.isp.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserAPI {

	@Autowired
	private UserService uSer;

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		ResponseEntity<User> resp = null;

		User u = uSer.getUserById(id);

		if (u == null) {
			resp = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			resp = new ResponseEntity<User>(u, HttpStatus.OK);
		}
		return resp;
	}

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
		ResponseEntity<User> resp = null;

		User u = uSer.addUser(user);

		if (u == null) {
			resp = new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		} else {
			resp = new ResponseEntity<User>(u, HttpStatus.OK);
		}

		return resp;

	}

}
