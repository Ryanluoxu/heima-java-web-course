package io.demo.service.impl;

import io.demo.dao.UserDao;
import io.demo.dao.impl.UserDaoImpl;
import io.demo.domain.User;
import io.demo.exception.UserExistException;
import io.demo.service.UserService;
import io.demo.utils.ServiceUtils;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	/* (non-Javadoc)
	 * @see io.demo.service.impl.UserService#register(io.demo.domain.User)
	 */
	@Override
	public void register(User user) throws UserExistException {
		boolean isUserExisted = userDao.checkUser(user.getUsername());
		if (isUserExisted) {
			System.out.println("user existed : "+user.getUsername());
			throw new UserExistException();
		}
		user.setPassword(ServiceUtils.md5(user.getPassword()));
		userDao.addUser(user);
		System.out.println("user register successfully : "+user.getUsername());
	}
	
	/* (non-Javadoc)
	 * @see io.demo.service.impl.UserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String username, String password) {
		password = ServiceUtils.md5(password);
		User user = userDao.getUser(username, password);
		if (user!=null) {
			System.out.println("user login successfully : "+username);
		} else {
			System.out.println("user login unsuccessfully : "+username);
		}
		return user;
	}
}
