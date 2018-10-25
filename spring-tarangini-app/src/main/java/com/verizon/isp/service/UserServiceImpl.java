package com.verizon.isp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.isp.dao.UserRepository;
import com.verizon.isp.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository uRep;

	@Override
	public User addUser(User user) {
		return uRep.save(user);
	}

	@Override
	public User getUserById(long id) {
		Optional<User> optUser = uRep.findById(id);

		User u = null;
		if (optUser.isPresent()) {
			u = optUser.get();
		}
		return u;
	}

}
