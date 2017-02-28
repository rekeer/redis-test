package com.red.redis.test;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class ReditTest {

	@Before
	public void setupBefore() {


	}
	@Test
	public void testRedisAppRunning() {
		//Connecting to Redis server on localhost 
	      Jedis jedis = new Jedis("localhost"); 
	      System.out.println("testRedisAppRunning Connection to server sucessfully"); 
	      //check whether server is running or not 
	      System.out.println("Server is running: "+jedis.ping()); 
		
	}
	@Test
	public void testRedisString(){
		 //Connecting to Redis server on localhost 
	      Jedis jedis = new Jedis("localhost"); 
	      System.out.println("testRedisString Connection to server sucessfully"); 
	      //set the data in redis string 
	      jedis.set("tutorial-name", "Redis tutorial"); 
	      // Get the stored data and print it 
	      System.out.println("Stored string in redis:: "+ jedis.get("tutorial-name")); 
	}
	@Test
	public void testRedisList(){
		//Connecting to Redis server on localhost 
	      Jedis jedis = new Jedis("localhost"); 
	      System.out.println("testRedisList Connection to server sucessfully"); 

	      //store data in redis list 
	      jedis.lpush("tutorial-list", "Redis"); 
	      jedis.lpush("tutorial-list", "Mongodb"); 
	      jedis.lpush("tutorial-list", "Mysql"); 
	      List<String> list = jedis.lrange("tutorial-list", 0 ,10); 

	      for(int i = 0; i<list.size(); i++) { 
	         System.out.println("Stored string in redis:: "+list.get(i)); 
	      } 
	}
	@Test
	public void testRedisKey(){
		//Connecting to Redis server on localhost 
	      Jedis jedis = new Jedis("localhost"); 
	      System.out.println("testRedisKey Connection to server sucessfully"); 
	       Set<String> list = jedis.keys("*"); 

	      for(int i = 0; i<list.size(); i++) { 
	         System.out.println("List of stored keys:: "+list.toString()); 
	      } 
	}
	
	@After
	public void setupAfter() {
		
	}
}
