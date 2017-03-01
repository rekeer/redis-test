package com.red.redis.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.red.redis.user.dao.UserDao;
import com.red.redis.user.entity.User;

public class ReditSpringTest {

	@Before
	public void setupBefore() {


	}
	@Test
	public void testRedisAppRunning() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        UserDao userDAO = (UserDao)ac.getBean("userDaoImpl");
        User user1 = new User();
        user1.setId(1);
        user1.setName("Trump");
        userDAO.saveUser(user1);
        User user2 = userDAO.getUser(1);
        System.out.println(user2.getName());
        assertEquals("Trump", user2.getName());
		
	}
	
	@After
	public void setupAfter() {
		
	}
}
