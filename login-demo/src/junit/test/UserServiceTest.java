package junit.test;

import org.junit.jupiter.api.Test;

import io.demo.domain.User;
import io.demo.exception.UserExistException;
import io.demo.service.UserService;
import io.demo.service.impl.UserServiceImpl;

public class UserServiceTest {

	@Test
	public void testRegister() {
		User user = new User();
		user.setId("test0002");
		user.setUsername("test2");
		user.setPassword("test2");
		user.setEmail("test2@test.com");
		
		UserService userService = new UserServiceImpl();
		try {
			userService.register(user);
		} catch (UserExistException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLogin() {
		UserService userService = new UserServiceImpl();
		userService.login("test2", "test2");
	}
}
