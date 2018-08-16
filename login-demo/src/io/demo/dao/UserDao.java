package io.demo.dao;

import io.demo.domain.User;

public interface UserDao {

	void addUser(User user);

	User getUser(String username, String password);

	boolean checkUser(String username);

}