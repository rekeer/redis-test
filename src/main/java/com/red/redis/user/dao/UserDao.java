package com.red.redis.user.dao;

import com.red.redis.user.entity.User;

public interface UserDao {
	public void saveUser(final User user);
	public User getUser(final long id);
}
