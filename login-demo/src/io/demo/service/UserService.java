package io.demo.service;

import io.demo.domain.User;
import io.demo.exception.UserExistException;

public interface UserService {

	void register(User user) throws UserExistException;

	User login(String username, String password);

}