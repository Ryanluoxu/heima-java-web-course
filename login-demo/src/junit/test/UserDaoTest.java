package junit.test;

import org.junit.jupiter.api.Test;

import io.demo.dao.UserDao;
import io.demo.dao.impl.UserDaoImpl;
import io.demo.domain.User;

public class UserDaoTest {

	@Test
	public void testAddUser() {
		User user = new User();
		user.setId("test0001");
		user.setUsername("test1");
		user.setPassword("test1");
		user.setEmail("test1@test.com");
		
		UserDao userDaoImpl = new UserDaoImpl();
		userDaoImpl.addUser(user);
	}
	
	@Test
	public void testGetUser() {
		UserDao userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.getUser("test2", "test2");
		if (user != null) {
			System.out.println(user.getId()+" "+user.getUsername()+" "+user.getEmail());
		}
	}
	
	@Test
	public void testCheckUser() {
		UserDao userDaoImpl = new UserDaoImpl();
		if (userDaoImpl.checkUser("rya1n")) {
			System.out.println("ryan is here");
		} else {
			System.out.println("ryan is not here");
		}
	}
}
