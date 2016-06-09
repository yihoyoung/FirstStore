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
		user = new User(email, password, userName);
		user = userRepository.save(user);
		return user;
	}

	public User find(String email) {
		return userRepository.findByEmail(email);
	}

	public User save(User user) {
		userRepository.save(user);
		return user;
	}

}
