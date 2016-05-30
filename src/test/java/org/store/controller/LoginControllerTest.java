package org.store.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.store.Application;
import org.store.MvcConfig;
import org.store.SecurityConfig;
import org.store.domain.User;
import org.store.repository.UserRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, MvcConfig.class, SecurityConfig.class})
@WebAppConfiguration
@IntegrationTest("server.port=8888")
@Transactional
public class LoginControllerTest {
 
    private User user;
 
    @Autowired private UserRepository userRepository;
    @Autowired private WebApplicationContext wac;
    private MockMvc mock;
 
    @Before
    public void setUp() throws Exception {
        this.mock = MockMvcBuilders.webAppContextSetup(wac).build();
        user = new User();
        user.setUsername("James");
        user.setPassword("123");
        user.setEmail("yihoyoung@nate.com");
    }
 
    @Test
    public void testCreateUserError() throws Exception {
        ResultActions resultActions =
                mock.perform(MockMvcRequestBuilders.post("/regist")
                        .contentType(MediaType.TEXT_HTML_VALUE)
                        .param("password", "123")
                        .param("email", "yihoyoung@nate.com"));
 
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.view().name("registForm"))
                .andExpect(MockMvcResultMatchers.model().attribute("isRegisted", false));
    }
 
    @Test
    public void testCreateUser() throws Exception {
        ResultActions resultActions =
                mock.perform(MockMvcRequestBuilders.post("/regist")
                        .contentType(MediaType.TEXT_HTML_VALUE)
                        .param("username", "James")
                        .param("password", "123")
                        .param("email", "yihoyoung@nate.com"));
 
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
 
    @Test
    public void testGetUserList() throws Exception {
        userRepository.save(user);
 
        ResultActions resultActions =
                mock.perform(MockMvcRequestBuilders.post("/login")
                		.contentType(MediaType.TEXT_HTML_VALUE)
                		.param("username", "James")
                        .param("password", "123")
                        .param("email", "yihoyoung@nate.com"));
 
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}