package org.store.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.store.Application;
import org.store.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class )
@WebAppConfiguration
@Transactional
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	User user;
	
	@Before
	public void setUp() {
		user = new User();
		user.setUsername("Yihoyoung");
	}
	
	@Test(expected = DataIntegrityViolationException.class)
	public void saveExcpectSQLError(){
		userService.save(user.getEmail(), user.getPassword(), user.getUsername());
	}
	
	@Test
	public void saveOK(){
		user.setPassword("james");
		user.setEmail("yihoyoung@nate.com");
		User user2 = userService.save(user.getEmail(), user.getPassword(), user.getUsername());
		assertEquals(user.getEmail(), user2.getEmail());
		assertNotNull(user2.getId());
		assertEquals(user.getPassword(), user2.getPassword());
	}
	
	@Test
	public void findUserByEmailTest(){
		user.setPassword("james");
		user.setEmail("yihoyoung@nate.com");
		User user2 = userService.save(user.getEmail(), user.getPassword(), user.getUsername());
		User user3 = userService.find(user.getEmail());
		assertEquals(user3.getEmail(), user2.getEmail());
		assertNotNull(user3.getId());
		assertEquals(user3.getPassword(), user2.getPassword());
	}
}
