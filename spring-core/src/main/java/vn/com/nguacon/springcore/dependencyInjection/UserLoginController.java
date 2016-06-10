package vn.com.nguacon.springcore.dependencyInjection;

public class UserLoginController {
	private UserDAO userDao;
	
	public UserLoginController() {
	}
	
	public UserLoginController(UserDAO userDao) {
		this.setUserDao(userDao);
	}
	
	public boolean login(String username, String password) {
		User user = userDao.getUser(username);
		
		if(user== null) {
			return false;
		}
		
		//TODO check password;
		
		return true;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
}
