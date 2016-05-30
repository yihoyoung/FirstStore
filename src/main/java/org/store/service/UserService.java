package org.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.store.domain.User;
import org.store.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
	User user;

	public User save(String email, String password, String userName) {
		// TODO Auto-generated method stub
		user = new User(email, password, userName);
		userRepository.save(user);
		return user;
	}

}