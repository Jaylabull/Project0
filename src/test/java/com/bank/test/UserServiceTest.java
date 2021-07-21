package com.bank.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import com.bank.dao.UserDao;
import com.bank.models.User;
import com.bank.services.UserService;

public class UserServiceTest {

	@InjectMocks
	public UserService uServ;
	
	@Mock
	public UserDao uDao;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSignUp() {

		User u = new User(1, "NewUser", "Test", "new@mail.com", "testpass");
		User not = new User(0, "user", "test", "test@mail.com", "testpass");
		
		when(uDao.getUserByUsername(any())).thenReturn(u);
		
		User loggedIn = uServ.signIn("NewUser", "testpass");
		
		assertEquals(u.getId(), loggedIn.getId());
	}

}
