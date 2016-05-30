package org.store.controller;


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
import org.store.repository.UserRepository;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class )
@WebAppConfiguration
@Transactional
public class UserRepositoryTest {
	@Autowired private UserRepository userRepository;
	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User();
		user.setUsername("Yihoyoung");
	}

	@Test(expected = DataIntegrityViolationException.class)
    public void testCreateUserNoEmail()  {
		user.setPassword("111");
        userRepository.save(user);
    }

	@Test
    public void testCreateUserOK()  {
		user.setPassword("111");
		user.setEmail("yihoyoung@nate.com");
        User dbUser = userRepository.save(user);
        assertEquals("user", user, dbUser);
    }
}
