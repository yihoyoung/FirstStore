package org.store.service;

import static org.junit.Assert.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

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
		user.setUserId(1111);
		user.setPassword("james");
		user.setEmail("yihoyoung@nate.com");
		user.setSocialId("1123123123123");
		user.setSocialType("n");
		user.setUsername("james");
		User user2 = userService.save(user.getEmail(), user.getPassword(), user.getUsername());
		assertEquals(user.getEmail(), user2.getEmail());
		assertNotNull(user2.getUserId());
		//assertEquals(user.getPassword(), user2.getPassword());
	}
	
	@Test
	public void findUserByEmailTest(){
		user.setPassword("james");
		user.setEmail("yihoyoung@nate.com");
		User user2 = userService.save(user.getEmail(), user.getPassword(), user.getUsername());
		User user3 = userService.find(user.getEmail());
		assertEquals(user3.getEmail(), user2.getEmail());
		assertEquals(user3.getUserId(), user2.getUserId());
		assertEquals(user3.getSocialId(), user2.getSocialId());
		assertEquals(user3.getUsername(), user2.getUsername());
		assertEquals(user3.getSocialType(), user2.getSocialType());
		assertNotNull(user3.getUserId());
		//assertEquals(user3.getPassword(), user2.getPassword());
	}
	
	@Test
	public void saveAllArgu(){
		user = new User(332, "james", "password", "yihoyoung@nate.com", "1231231412381231", "f");
		userService.save(user);
		User user2 = userService.find(user.getEmail());
		User user3 = userService.find(user.getEmail());
		assertEquals(user3.getEmail(), user2.getEmail());
		assertEquals(user3.getSocialId(), user2.getSocialId());
		assertEquals(user3.getUsername(), user2.getUsername());
		assertEquals(user3.getSocialType(), user2.getSocialType());
		assertNotNull(user3.getUserId());
		assertNotNull(user3.getPassword());
		assertTrue(user3.equals(user2));
		assertEquals(user3.hashCode(), user2.hashCode());
		assertEquals(user3.toString(), user2.toString());
		//assertEquals(user3.getPassword(), user2.getPassword());
	}
}
