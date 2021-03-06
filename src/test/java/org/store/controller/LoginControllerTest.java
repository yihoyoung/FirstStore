package org.store.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
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
import org.store.domain.User;
import org.store.repository.UserRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.store.service.LoginUserDetailsService;
import org.store.service.UserService;

import javax.servlet.Filter;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, MvcConfig.class})
@WebAppConfiguration
@IntegrationTest("server.port=8888")
@Transactional
public class LoginControllerTest {
 
    private User user;
 
    @Autowired private UserRepository userRepository;
    @Autowired private WebApplicationContext wac;
    @Autowired
    private FilterChainProxy filterChainProxy;
    @Autowired
    private Filter springSecurityFilterChain;
    @Autowired
    UserService userService;
    @Autowired
    LoginUserDetailsService userDetailsService;

    private MockMvc mock;
 
    @Before
    public void setUp() throws Exception {
        this.mock = MockMvcBuilders.webAppContextSetup(wac).addFilters(this.springSecurityFilterChain).build();
        user = new User();
        user.setUsername("James");
        user.setPassword("123");
        user.setEmail("yihoyoung@nate.com");
    }
    
    @Test
    public void testGetLoginForm() throws Exception {
        ResultActions resultActions =
                mock.perform(MockMvcRequestBuilders.get("/loginPage"));
 
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("loginPage"));
    }
    
    @Test
    public void testGetRegistForm() throws Exception {
        ResultActions resultActions =
                mock.perform(MockMvcRequestBuilders.get("/registForm"));
 
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("registForm"));
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
    public void testlogin() throws Exception {
        userRepository.save(user);


        ResultActions resultActions =
                mock.perform(MockMvcRequestBuilders.post("/login")
                		.contentType(MediaType.TEXT_HTML_VALUE)
                        .param("password", user.getPassword())
                        .param("email", user.getEmail()));
 
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/menu"));
    }
 
    @Test
    public void testloginfail() throws Exception {
        userRepository.save(user);
 
        ResultActions resultActions =
                mock.perform(MockMvcRequestBuilders.post("/login")
                		.contentType(MediaType.TEXT_HTML_VALUE)
                        .param("password", "notapassword")
                        .param("email", user.getEmail()));
 
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/loginPage?error"));
    }

    @Test
    public void testloginNoPassword() throws Exception {
        userRepository.save(user);
 
        ResultActions resultActions =
                mock.perform(MockMvcRequestBuilders.post("/login")
                		.contentType(MediaType.TEXT_HTML_VALUE)
                        .param("email", user.getEmail()));
 
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/loginPage?error"));
    }

    @Test
    public void loginWrongEmailTest() throws Exception {
        userRepository.save(user);

        ResultActions resultActions =
                mock.perform(MockMvcRequestBuilders.post("/login")
                		.contentType(MediaType.TEXT_HTML_VALUE)
                		.param("_csrf", "cc20f377-a721-4eeb-ac11-72137ba4b952")
                		.param("password", "notapassword")
                        .param("email", "yihoyoung2222@aab.com"));
 
        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/loginPage?error"));

    }
    
    @Test
    public void facebookLoginTest(){
    	Facebook facebook = new FacebookTemplate(null);
    	
    }
}