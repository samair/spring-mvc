package com.webvidhi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.webvidhi.web.model.User;

import redis.clients.jedis.Jedis;

@Controller
public class WebApplication {
	
	User user;
	
	@GetMapping("/User/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		Jedis jedis = new Jedis("localhost");
		String username = jedis.get(id.toString());
		this.user = new User();
		this.user.setUserName(username);
		this.user.setId(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/User")
	public ResponseEntity<User> setUser(@RequestBody User user) {

		Jedis jedis = new Jedis("localhost");
		
		//jedis.clientSetname("test-webapp");
		jedis.set(user.getId().toString(), user.getUserName());
		jedis.close();
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
