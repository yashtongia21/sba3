package com.verizon.isp.service;

import com.verizon.isp.model.User;

public interface UserService {

	User addUser(User user);
	
	User getUserById(long id);

}
